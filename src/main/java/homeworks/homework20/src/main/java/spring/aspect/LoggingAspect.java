package spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* spring.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before method: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* spring.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Method {} returned: {}", joinPoint.getSignature().getName(), result);
    }
}