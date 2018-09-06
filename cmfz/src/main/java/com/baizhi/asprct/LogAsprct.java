package com.baizhi.asprct;

import com.baizhi.entity.Admin;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * Created by 畅均江 on 2018/9/5.
 */

@Configuration
@Aspect
public class LogAsprct {

    @Around(value="@annotation(LogAnnotation)")
    public void log(ProceedingJoinPoint proceedingJoinPoint){
        /*什么人*/
        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        String username = admin.getUsername();
        /*时间*/
        Date date = new Date();
        /*干了什么事*/
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        /*方法名*/
        Method method = signature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String name = annotation.name();

        /*放行*/
        Boolean flag=false;
            try {
                Object proceed = proceedingJoinPoint.proceed();
                flag=true;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
         System.out.println(flag);

    }
}
