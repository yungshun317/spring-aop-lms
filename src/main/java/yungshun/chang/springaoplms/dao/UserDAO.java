package yungshun.chang.springaoplms.dao;

import org.springframework.stereotype.Component;
import yungshun.chang.springaoplms.entity.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    private String firstName;
    private String lastName;

    public List<User> findUsers() {

        List<User> users = new ArrayList<>();

        // Create sample users
        User tmpUser1 = new User("Morrigan", "Aensland");
        User tmpUser2 = new User("Kula", "Diamond");
        User tmpUser3 = new User("Blue", "Mary");

        // Add them to user list
        users.add(tmpUser1);
        users.add(tmpUser2);
        users.add(tmpUser3);

        return users;
    }

    public void addUser(User user, boolean vipFlag) {
        System.out.println(getClass() + ": Adding a user");
    }

    public boolean updateUser() {
        System.out.println(getClass() + ": Updating a user");
        return false;
    }

    public String getFirstName() {
        System.out.println(getClass() + ": in getFirstName()");
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println(getClass() + ": in setFirstName()");
        this.firstName = firstName;
    }

    public String getLastName() {
        System.out.println(getClass() + ": in getLastName()");
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println(getClass() + ": in setLastName()");
        this.lastName = lastName;
    }
}
