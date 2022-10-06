package yungshun.chang.springaoplms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yungshun.chang.springaoplms.dao.AccountDAO;

public class LMS {

    public static void main(String[] args) {

        // Read Spring Config Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LMSConfig.class);

        // Get the bean from Spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // Call the business method
        accountDAO.addAccount();

        // Call it again
        System.out.println("\nCall the method again!\n");

        // Call the business method
        accountDAO.addAccount();

        // Close the context
        context.close();
    }
}
