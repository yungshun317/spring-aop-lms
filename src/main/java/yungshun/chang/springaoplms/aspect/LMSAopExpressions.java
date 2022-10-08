package yungshun.chang.springaoplms.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LMSAopExpressions {

    @Pointcut("execution(* yungshun.chang.springaoplms.dao.*.*(..))")
    public void forDaoPackage() {}

    // Create pointcut for getter methods
    @Pointcut("execution(* yungshun.chang.springaoplms.dao.*.get*(..))")
    public void getter() {}

    // Create pointcut for setter methods
    @Pointcut("execution(* yungshun.chang.springaoplms.dao.*.set*(..))")
    public void setter() {}

    // Create pointcut: include package... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}


