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

    // Create pointcut for getter methods
    @Pointcut("execution(* yungshun.chang.springaoplms.dao.*.get*(..))")
    private void getter() {}

    // Create pointcut for setter methods
    @Pointcut("execution(* yungshun.chang.springaoplms.dao.*.set*(..))")
    private void setter() {}

    // Create pointcut: include package... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

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
