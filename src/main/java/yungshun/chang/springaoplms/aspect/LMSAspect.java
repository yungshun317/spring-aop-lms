package yungshun.chang.springaoplms.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LMSAspect {

    @Before("execution(public void addUser(..))")
    public void beforeAddUserAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addUser()");
    }
}
