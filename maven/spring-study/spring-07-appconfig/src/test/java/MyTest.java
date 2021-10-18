import com.flywinter.config.Appconfig;
import com.flywinter.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/25 17:41
 * Description:
 */
public class MyTest {
    public static void main(String[] args) {
        //如果完全使用了配置类方式去做,我们就只能通过AnnotationConfig上下文来获取容器,通
        // 过配置类的class对象加载
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        User getUser = (User) context.getBean("user");
        System.out.println(getUser);
    }
}
