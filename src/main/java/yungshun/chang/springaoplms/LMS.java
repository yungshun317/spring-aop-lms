package yungshun.chang.springaoplms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yungshun.chang.springaoplms.dao.RoleDAO;
import yungshun.chang.springaoplms.dao.UserDAO;
import yungshun.chang.springaoplms.entity.User;
import yungshun.chang.springaoplms.service.UserService;

import java.util.List;

public class LMS {

    public static void main(String[] args) {

        // Read Spring Config Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LMSConfig.class);

        // Get the User bean from Spring container
        UserDAO userDAO = context.getBean("userDAO", UserDAO.class);

        /* [1] `@Before`
        // Get the Role bean from Spring container
        RoleDAO roleDAO = context.getBean("roleDAO", RoleDAO.class);

        // Call the User business method
        User user = new User();
        user.setFirstName("Lili");
        user.setLastName("Rochefort");

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
         */

        /* [2] `@AfterReturning`
        // Call method to find the users
        List<User> users = userDAO.findUsers();

        // Display the users
        System.out.println(users);
         */

        /* [3] `@AfterThrowing`
        // Call method to find the users
        List<User> users = null;

        try {
            // Add a boolean flag to simulate exceptions
            boolean tripWire = true;
            users = userDAO.findUsers(tripWire);
        } catch (Exception exc) {
            System.out.println("Caught exception: " + exc);
        }

        // Display the users
        System.out.println(users);
         */

        /* [4] `@AfterFinally`
        // Call method to find the users
        List<User> users = null;

        try {
            // Add a boolean flag to simulate exceptions
            boolean tripWire = false;
            users = userDAO.findUsers(tripWire);
        } catch (Exception exc) {
            System.out.println("Caught exception: " + exc);
        }

        // Display the users
        System.out.println(users);
         */

        // [5] `@Around`
        // Get the bean from Spring container
        UserService userService = context.getBean("userService", UserService.class);

        System.out.println("Call getPermission");
        String notification = userService.getPermission();
        System.out.println("Your permission is: " + notification);
        System.out.println("Done.");

        // Close the context
        context.close();
    }
}
