package yungshun.chang.springaoplms.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    public void addUser() {
        System.out.println(getClass() + ": Adding a user");
    }
}
