import com.flywinter.dao.UserDaoMysqlImpl;
import com.flywinter.service.UserService;
import com.flywinter.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/24 22:26
 * Description:
 */
public class MyTest {

    public static void main(String[] args) {
        //用户实际调用的是业务层，dao层不需要接触
//        UserService userService = new UserServiceImpl();
//        ((UserServiceImpl) userService).setUserDao(new UserDaoMysqlImpl());
//        userService.getUser();
        //获取ApplicationContext 拿到spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //需要什么就直接get什么
        UserServiceImpl bean =(UserServiceImpl) context.getBean("UserServiceImpl");
        bean.getUser();

    }
}
