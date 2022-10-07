package yungshun.chang.springaoplms.dao;

import org.springframework.stereotype.Component;

@Component
public class RoleDAO {

    public void addRole() {
        System.out.println(getClass() + ": Adding a role");
    }
}
