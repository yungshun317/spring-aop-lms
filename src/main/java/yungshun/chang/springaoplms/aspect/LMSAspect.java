package yungshun.chang.springaoplms.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import yungshun.chang.springaoplms.entity.User;

@Aspect
@Component
@Order(2)
public class LMSAspect {

    @Before("execution(public void addUser(..))")
    public void beforeAddUserAdvice(JoinPoint joinPoint) {

        System.out.println("\n=====>>> Executing @Before advice on addUser()");

        // Display the method signature
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSig);

        // Get method arguments
        Object[] args = joinPoint.getArgs();

        // Loop through & Display method arguments
        for (Object tmpArg: args) {

            System.out.println(tmpArg);

            if (tmpArg instanceof User) {
                // Downcast & print User specific stuff
                User user = (User) tmpArg;

                System.out.println("User firstName: " + user.getFirstName());
                System.out.println("User lastName: " + user.getLastName());
            }
        }
    }
}
