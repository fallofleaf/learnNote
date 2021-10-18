import com.flywinter.dao.BlogMapper;
import com.flywinter.entity.Blog;
import com.flywinter.utils.IdUtil;
import com.flywinter.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/23 16:37
 * Description:
 */
public class MyTest {
    @Test
    public void  insert(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();

        blog.setId(IdUtil.getId());
        blog.setTitle("示例文章1");
        blog.setAuthor("Alex");
        blog.setCreateTime(new Date());
        blog.setViews(89);
        mapper.addBlog(blog);

        blog.setId(IdUtil.getId());
        blog.setTitle("示例文章2");
        blog.setAuthor("Max");
        blog.setViews(12);
        mapper.addBlog(blog);

        blog.setId(IdUtil.getId());
        blog.setTitle("示例文章3");
        blog.setAuthor("Yam");
        blog.setViews(500);
        mapper.addBlog(blog);


        blog.setId(IdUtil.getId());
        blog.setTitle("示例文章4");
        blog.setAuthor("Mark");
        blog.setViews(800);
        mapper.addBlog(blog);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryResult(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,String> map = new HashMap<>();
        map.put("author","Max");
        List<Blog> blogs = mapper.queryBlogIF(map);
        System.out.println(blogs);
        sqlSession.close();
    }

    @Test
    public void updateResult(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String,String> map = new HashMap<>();
        map.put("author","Marry");
        map.put("id","70c1a77b040d45ffab170bc31dd205f7");
        int i = mapper.updateBlog(map);
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }
}
