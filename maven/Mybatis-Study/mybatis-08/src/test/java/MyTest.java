import com.flywinter.dao.UserMapper;
import com.flywinter.entity.User;
import com.flywinter.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/24 19:14
 * Description:
 */
public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
//        sqlSession.clearCache();//清理一级缓存
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        System.out.println(user == user1);
        sqlSession.close();

    }
}
