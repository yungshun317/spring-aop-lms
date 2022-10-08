package yungshun.chang.springaoplms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yungshun.chang.springaoplms.dao.RoleDAO;
import yungshun.chang.springaoplms.dao.UserDAO;
import yungshun.chang.springaoplms.entity.User;

public class LMS {

    public static void main(String[] args) {

        // Read Spring Config Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LMSConfig.class);

        // Get the User bean from Spring container
        UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

        // Get the Role bean from Spring container
        RoleDAO roleDAO = context.getBean("roleDAO", RoleDAO.class);

        // Call the User business method
        User user = new User();
        userDAO.addUser(user, true);
        userDAO.updateUser();

        // Call the UserDAO getter/setter methods
        userDAO.setFirstName("Mai");
        userDAO.setLastName("Shiranui");

        String firstName = userDAO.getFirstName();
        String lastName = userDAO.getLastName();

        // Call the Role business method
        roleDAO.addRole();
        roleDAO.updateRole();

        // Close the context
        context.close();
    }
}
