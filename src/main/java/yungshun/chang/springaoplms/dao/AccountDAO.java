package yungshun.chang.springaoplms.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": Adding an account");
    }
}
