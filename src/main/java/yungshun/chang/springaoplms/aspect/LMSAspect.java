package yungshun.chang.springaoplms.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import yungshun.chang.springaoplms.entity.User;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LMSAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Before("execution(public void addUser(..))")
    public void beforeAddUserAdvice(JoinPoint joinPoint) {

        System.out.println("\n=====>>> Executing @Before advice on addUser()");

        // Display the method signature
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: " + methodSig);

        // Get method arguments
        Object[] args = joinPoint.getArgs();

        // Loop through & Display method arguments
        for (Object tmpArg: args) {

            logger.info(tmpArg.toString());

            if (tmpArg instanceof User) {
                // Downcast & print User specific stuff
                User user = (User) tmpArg;

                logger.info("User firstName: " + user.getFirstName());
                logger.info("User lastName: " + user.getLastName());
            }
        }
    }

    // Add a new advice for `@AfterReturning` on the `findUsers` method
    @AfterReturning(
            pointcut="execution(* yungshun.chang.springaoplms.dao.UserDAO.findUsers(..))",
            returning="users"
    )
    public void afterReturningFindUsersAdvice(JoinPoint joinPoint, List<User> users) {

        // Print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @AfterReturning on method: " + method);

        // Print out the user list returning by the method
        logger.info("\n=====>>> Find users: " + users);

        // Post-process the data. Convert the user names to uppercase
        convertUserNamesToUpperCase(users);

        logger.info("\n=====>>> Find users: " + users);
    }

    private void convertUserNamesToUpperCase(List<User> users) {

        // Loop through users
        for (User tmpUser: users) {

            // Get uppercase version of firstName & lastName
            String upperFirstName = tmpUser.getFirstName().toUpperCase();
            String upperLastName = tmpUser.getLastName().toUpperCase();

            // Update the names on the `User`
            tmpUser.setFirstName(upperFirstName);
            tmpUser.setLastName(upperLastName);
        }
    }

    @AfterThrowing(
            pointcut="execution(* yungshun.chang.springaoplms.dao.UserDAO.findUsers(..))",
            throwing="exc"
    )
    public void afterThrowingFindUsersAdvice(JoinPoint joinPoint, Throwable exc) {

        // Print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @AfterThrowing on method: " + method);

        // Log the exception
        logger.info("\n=====>>> The exception is: " + exc);
    }

    @After("execution(* yungshun.chang.springaoplms.dao.UserDAO.findUsers(..))")
    public void afterFinallyFindUsersAdvice(JoinPoint joinPoint) {

        // Print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @After (finally) on method: " + method);
    }

    @Around("execution(* yungshun.chang.springaoplms.service.*.getPermission(..))")
    public Object aroundGetPermission(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // Print out which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>> Executing @Around on method: " + method);

        // Get `begin` timestamp
        long begin = System.currentTimeMillis();

        // Execute the method
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exc) {
            // Log the exception
            logger.warning(exc.getMessage());

            // Give users a custom message
            result = "Denied!";
        }

        // Get `end` timestamp
        long end = System.currentTimeMillis();

        // Compute duration & display it
        long duration = end - begin;
        logger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }
}
