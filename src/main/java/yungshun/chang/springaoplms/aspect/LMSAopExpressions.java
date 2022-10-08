package yungshun.chang.springaoplms.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LMSAopExpressions {

    @Pointcut("execution(* yungshun.chang.springaoplms.dao.*.*(..))")
    private void forDaoPackage() {}

    // Create pointcut for getter methods
    @Pointcut("execution(* yungshun.chang.springaoplms.dao.*.get*(..))")
    private void getter() {}

    // Create pointcut for setter methods
    @Pointcut("execution(* yungshun.chang.springaoplms.dao.*.set*(..))")
    private void setter() {}

    // Create pointcut: include package... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}
}


