import com.flywinter.dao.StudentMapper;
import com.flywinter.dao.TeacherMapper;
import com.flywinter.entity.Student;
import com.flywinter.entity.Teacher;
import com.flywinter.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/22 22:49
 * Description:
 */
public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent2();
        System.out.println(student);
        sqlSession.close();
    }
}
