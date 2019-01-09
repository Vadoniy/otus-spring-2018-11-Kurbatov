package homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* homework_4.homework.otus_spring_2018_11_Kurbatov.OTUS.services.CSVReaderService.*(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Method call : " + joinPoint.getSignature().getName());
    }
}