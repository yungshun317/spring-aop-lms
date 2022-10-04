package yungshun.chang.springaoplms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LMS {

    public static void main(String[] args) {

        // Read Spring Config Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LMSConfig.class);

        // Close the context
        context.close();
    }
}
