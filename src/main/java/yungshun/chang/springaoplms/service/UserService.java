package yungshun.chang.springaoplms.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class UserService {

    public String getPermission() {

        // Simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a notification
        return "Permission is under review";
    }

    public String getPermission(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Your application is denied!");
        }

        return getPermission();
    }
}
