package com.flywinter.aspect;

import com.flywinter.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA
 * User:Zhang Xingkun
 * Date:2021/7/27 17:27
 * Description:
 */

/**
 * 通过@Order来确定执行顺序,数字越小，切面执行顺序越靠前
 */
//@Order(1)
@Aspect
@Component
public class UserAspect {


    /**
     * 定义切点
     */
    @Pointcut("execution(* com.flywinter.service.UserServiceImpl.*(..))")
    private void userPointCut(){}
    @Pointcut("execution(* com.flywinter.service.UserServiceImpl.*(..))")
    private void userPointCutNew(){}


    /**
     * 多个相同注解，按照方法的首字母顺序执行
     * @param name
     */
    @Before("com.flywinter.aspect.UserAspect.userPointCut() && args (name)")
    public void bafter(String name){
        System.out.println("bafter");
    }
    @Before("com.flywinter.aspect.UserAspect.userPointCut() && args (name)")
    public void dafter(String name){
        System.out.println("dafter");
    }
    @Before("com.flywinter.aspect.UserAspect.userPointCut() && args (name)")
    public void aafter(String name){
        System.out.println("aafter");
    }
    @Before("com.flywinter.aspect.UserAspect.userPointCut() && args (name)")
    public void cafter(String name){
        System.out.println("cafter");
    }

    @After("userPointCut()")
    public void move(){
        System.out.println("执行了move");
    }



    @Before("userPointCutNew() && args(user)")
    public void verifyEntityBefore(User user){
        System.out.println("执行了verifyEntityBefore方法");
        user.setAge(1);
        user.setName("通过切面修改后的name");
        System.out.println(user);
    }

    /**
     * ProceedingJoinPoint变量必须在前面，其他传递的变量依次排在后面
     * 执行了proceed相当于执行了后面所有的before，after，以及要切面的方法本身
     * @param jp
     * @param user
     */
    @Around("userPointCutNew() && args(user)")
    public void verifyAround(ProceedingJoinPoint jp,User user){
        System.out.println("around");
        try {
            jp.proceed();
            System.out.println("around1");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }




}
