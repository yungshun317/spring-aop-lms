package yungshun.chang.springaoplms.dao;

import org.springframework.stereotype.Component;
import yungshun.chang.springaoplms.entity.User;

@Component
public class UserDAO {

    private String firstName;
    private String lastName;

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
