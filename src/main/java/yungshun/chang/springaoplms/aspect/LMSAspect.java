package yungshun.chang.springaoplms.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LMSAspect {

    @Before("execution(public void addUser(..))")
    public void beforeAddUserAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addUser()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performLogging() {
        System.out.println("\n=====>>> Performing logging");
    }
}
