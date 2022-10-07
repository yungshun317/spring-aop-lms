package yungshun.chang.springaoplms.dao;

import org.springframework.stereotype.Component;
import yungshun.chang.springaoplms.entity.User;

@Component
public class UserDAO {

    public void addUser(User user, boolean vipFlag) {
        System.out.println(getClass() + ": Adding a user");
    }

    public boolean updateUser() {
        System.out.println(getClass() + ": Updating a user");
        return false;
    }
}
