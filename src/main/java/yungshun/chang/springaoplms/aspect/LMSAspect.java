package yungshun.chang.springaoplms.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LMSAspect {

    @Pointcut("execution(* yungshun.chang.springaoplms.dao.*.*(..))")
    private void forDaoPackage() {}

    @Before("execution(public void addUser(..))")
    public void beforeAddUserAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addUser()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }

    @Before("forDaoPackage()")
    public void performLogging() {
        System.out.println("\n=====>>> Performing logging");
    }
}
