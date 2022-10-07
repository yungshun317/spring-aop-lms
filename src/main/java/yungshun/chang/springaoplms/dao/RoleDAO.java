package yungshun.chang.springaoplms.dao;

import org.springframework.stereotype.Component;

@Component
public class RoleDAO {

    public boolean addRole() {
        System.out.println(getClass() + ": Adding a role");
        return true;
    }

    public void updateRole() {
        System.out.println(getClass() + ": Updating a role");
    }
}
