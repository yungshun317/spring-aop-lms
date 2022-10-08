package yungshun.chang.springaoplms.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LMSAsyncLoggingAspect {

    @Before("yungshun.chang.springaoplms.aspect.LMSAopExpressions.forDaoPackageNoGetterSetter()")
    public void performLogging() {
        System.out.println("\n=====>>> Performing Async logging");
    }
}
