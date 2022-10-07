package yungshun.chang.springaoplms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yungshun.chang.springaoplms.dao.UserDAO;

public class LMS {

    public static void main(String[] args) {

        // Read Spring Config Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LMSConfig.class);

        // Get the bean from Spring container
        UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

        // Call the business method
        userDAO.addUser();

        // Call it again
        System.out.println("\nCall the method again!\n");

        // Call the business method
        userDAO.addUser();

        // Close the context
        context.close();
    }
}
