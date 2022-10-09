package yungshun.chang.springaoplms.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import yungshun.chang.springaoplms.entity.User;

import java.util.List;

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

    // Add a new advice for `@AfterReturning` on the `findUsers` method
    @AfterReturning(pointcut="execution(* yungshun.chang.springaoplms.dao.UserDAO.findUsers(..))", returning="users")
    public void afterReturningFindUsersAdvice(JoinPoint joinPoint, List<User> users) {

        // Print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\\n=====>>> Executing @AfterReturning on method: " + method);

        // Print out the user list returning by the method
        System.out.println("\n=====>>> Find users: " + users);
        
        // Post-process the data. Convert the user names to uppercase

        System.out.println("\n=====>>> Find users: " + users);
    }

    private void convertUserNamesToUpperCase(List<User> users) {

    }
}
