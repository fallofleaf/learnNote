import com.flywinter.entity.User;
import com.flywinter.service.UserService;
import com.flywinter.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/27 17:35
 * Description:
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService bean = (UserService)context.getBean("userServiceImpl");
        bean.add("名字");
    }

    @Test
    public void verifyEntityTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService bean = (UserService)context.getBean("userServiceImpl");
        User user = new User("name", 2);
        bean.delete(user);
    }

  
}
