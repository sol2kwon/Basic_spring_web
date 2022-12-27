package mini_project.mini_project_solyi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect//AOP 사용
@Component
public class TimeTraceAop {

    @Around("execution(* mini_project.mini_project_solyi.service..*(..))") // 패키지 하위에 모두 적용
    //("execution(* mini_project.mini_project_solyi..*(..))") 패키지 하위에 모두 적용
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
