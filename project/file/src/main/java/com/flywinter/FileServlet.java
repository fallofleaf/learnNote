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
       //�ж�����ͨ�������ϴ��ļ�
        if (!ServletFileUpload.isMultipartContent(req)) {
            return;//��ֹ�������У��������ͨ��
        }
        //�����ϴ��ļ��ı���·������ñ�����WEB-INFĿ¼�£��û��޷�ֱ�ӷ���
        String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdir();//�������Ŀ¼
        }
        //���� ��ʱ�ļ�
//        ��ʱ·����һ���ļ�������Ԥ�ڵĴ�С���Ͱ����ŵ�һ����ʱ�ļ��У��������Զ�ɾ�������������û�ת��Ϊ����
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        File tempFile = new File(tempPath);
        if (!tempFile.exists()) {
            tempFile.mkdir();
        }
        //�����ϴ��ļ���һ����Ҫ������ʹ��request.getInputStream()����ȡ��ԭ���ļ���ȡ��ʮ���鷳
//        ʹ��apache���ļ��ϴ������ʵ�� common-fileupload ������ commons-io

        //1.����DiskFileItemFactory���󣬴����ļ��ϴ�·�����С����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //ͨ����������һ�������������ϴ����ļ����������������ʱ�򣬽���ת�浽��ʱ�ļ���
        factory.setSizeThreshold(1024*1024);//��������С1M
        factory.setRepository(tempFile);//��ʱ�ļ�����·������Ҫһ��File
        //2.��ȡServletFileUpload
        ServletFileUpload upload = new ServletFileUpload(factory);
        //�����ļ��ϴ�����
        upload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long l, long l1, int i) {
//                l �Ѿ���ȡ���ļ���С   l1�ļ���С
                System.out.println("�ܴ�С:"+l1+",�Ѿ��ϴ����ļ���С:"+l);
            }
        });
        //������������
        upload.setHeaderEncoding("UTF-8");
        //���õ����ļ����ֵ
        upload.setFileSizeMax(1024*1024*10);
        //�����ܹ����ϴ����ļ���С
        upload.setSizeMax(1024*1024*100);

        //3.�����ϴ����ļ�
        try {
            //��ǰ�������������װ��FileItem����,��Ҫ��ServletFileUpload�л�ȡ����
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                //�ж��ϴ����ļ�����ͨ�ı������ļ�
                if (fileItem.isFormField()){
                    //getFieldName��ȡ����ǰ�˱��ؼ���name
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");//��������
                    System.out.println(name + ":" +value);
                }else {
                    //�����ļ�
                    String uploadFileName = fileItem.getName();
                    //���ܴ����ļ������Ϸ������
                    if (uploadFileName.trim().equals("") ||uploadFileName == null) {
                        continue;
                    }
                    //����ϴ����ļ���
                    String fileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
                    String fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
                    System.out.println(fileName+fileExtName);
                    //ʹ��UUID����Ψһ�ļ���
                    //���������д�������ݣ�����Ҫ���л���
                    //ʵ�������Ҫ�ڶ�����������У���Ҫ�佫���л�
                    //implements Serializable ��ǽӿ� JVM�ڱ���native��������
                    String uuidPath = UUID.randomUUID().toString();
                    //��ŵ�ַ
                    String realPath = uploadPath + "/"+uuidPath;
                    //��ÿ���ļ�һ����Ӧ���ļ���
                    File realPathFile = new File(realPath);
                    if (!realPathFile.exists()) {
                        realPathFile.mkdir();
                    }
                    //�ļ�����
                    //����ļ��ϴ�����
                    InputStream inputStream = fileItem.getInputStream();
                    FileOutputStream fileOutputStream = new FileOutputStream(realPath + "/" +fileName);
                    System.out.println(realPath + "/" +fileName);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = inputStream.read(buffer))>0){
                        fileOutputStream.write(buffer,0,len);
                    }
                    //�ر���
                    fileOutputStream.close();
                    inputStream.close();
                    System.out.println("�ļ��ϴ��ɹ�");
                    fileItem.delete();
                    //Servlet����ת����Ϣ
                    req.setAttribute("msg","�ļ��ϴ��ɹ�");
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
