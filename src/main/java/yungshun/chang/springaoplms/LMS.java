package yungshun.chang.springaoplms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yungshun.chang.springaoplms.dao.RoleDAO;
import yungshun.chang.springaoplms.dao.UserDAO;
import yungshun.chang.springaoplms.entity.User;

public class LMS {

    public static void main(String[] args) {

        // Read Spring Config Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LMSConfig.class);

        // Get the user bean from Spring container
        UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

        // Get the role bean from Spring container
        RoleDAO roleDAO = context.getBean("roleDAO", RoleDAO.class);

        // Call the user business method
        User user = new User();
        userDAO.addUser(user, true);
        userDAO.updateUser();

        // Call the role business method
        roleDAO.addRole();
        roleDAO.updateRole();

        // Close the context
        context.close();
    }
}
