package yungshun.chang.springaoplms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LMS {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LMSConfig.class);
    }
}
