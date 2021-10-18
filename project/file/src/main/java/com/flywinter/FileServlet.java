package com.flywinter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/21 13:50
 * Description:
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //判断是普通表单还是上传文件
        if (!ServletFileUpload.isMultipartContent(req)) {
            return;//终止方法运行，如果是普通表单
        }
        //创建上传文件的保存路径，最好保存在WEB-INF目录下，用户无法直接访问
        String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdir();//创建这个目录
        }
        //缓存 临时文件
//        临时路径，一旦文件超过了预期的大小，就把它放到一个临时文件中，过几天自动删除，或者提醒用户转存为永久
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        File tempFile = new File(tempPath);
        if (!tempFile.exists()) {
            tempFile.mkdir();
        }
        //处理上传文件，一般需要处理流使用request.getInputStream()，获取，原生文件获取流十分麻烦
//        使用apache的文件上传组件来实现 common-fileupload 依赖于 commons-io

        //1.创建DiskFileItemFactory对象，处理文件上传路径或大小限制
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //通过工厂设置一个缓存区，当上传的文件大于这个缓存区的时候，将其转存到临时文件中
        factory.setSizeThreshold(1024*1024);//缓存区大小1M
        factory.setRepository(tempFile);//临时文件保存路径，需要一个File
        //2.获取ServletFileUpload
        ServletFileUpload upload = new ServletFileUpload(factory);
        //监听文件上传进度
        upload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long l, long l1, int i) {
//                l 已经读取的文件大小   l1文件大小
                System.out.println("总大小:"+l1+",已经上传的文件大小:"+l);
            }
        });
        //处理乱码问题
        upload.setHeaderEncoding("UTF-8");
        //设置单个文件最大值
        upload.setFileSizeMax(1024*1024*10);
        //设置总共能上传的文件大小
        upload.setSizeMax(1024*1024*100);

        //3.处理上传的文件
        try {
            //把前端请求解析，封装成FileItem对象,需要从ServletFileUpload中获取对象
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                //判断上传的文件是普通的表单还是文件
                if (fileItem.isFormField()){
                    //getFieldName获取的是前端表单控件的name
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");//处理乱码
                    System.out.println(name + ":" +value);
                }else {
                    //处理文件
                    String uploadFileName = fileItem.getName();
                    //可能存在文件名不合法的情况
                    if (uploadFileName.trim().equals("") ||uploadFileName == null) {
                        continue;
                    }
                    //获得上传的文件名
                    String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                    String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
                    System.out.println(fileName+fileExtName);
                    //使用UUID生成唯一文件名
                    //网络中所有传输的数据，都需要序列化，
                    //实体类如果要在多个电脑上运行，需要其将序列化
                    //implements Serializable 标记接口 JVM在本地native方法中找
                    String uuidPath = UUID.randomUUID().toString();
                    //存放地址
                    String realPath = uploadPath + "/"+uuidPath;
                    //给每个文件一个相应的文件夹
                    File realPathFile = new File(realPath);
                    if (!realPathFile.exists()) {
                        realPathFile.mkdir();
                    }
                    //文件传输
                    //获得文件上传的流
                    InputStream inputStream = fileItem.getInputStream();
                    FileOutputStream fileOutputStream = new FileOutputStream(realPath + "/" +fileName);
                    System.out.println(realPath + "/" +fileName);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = inputStream.read(buffer))>0){
                        fileOutputStream.write(buffer,0,len);
                    }
                    //关闭流
                    fileOutputStream.close();
                    inputStream.close();
                    System.out.println("文件上传成功");
                    fileItem.delete();
                    //Servlet请求转发信息
                    req.setAttribute("msg","文件上传成功");
                    req.getRequestDispatcher("info.jsp").forward(req,resp);
                }

            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
