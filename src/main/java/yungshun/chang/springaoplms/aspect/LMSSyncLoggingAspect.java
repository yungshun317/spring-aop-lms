package yungshun.chang.springaoplms.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class LMSSyncLoggingAspect {

    @Before("yungshun.chang.springaoplms.aspect.LMSAopExpressions.setter()")
    public void performLogging() {
        System.out.println("\n=====>>> Performing Sync logging");
    }
}
