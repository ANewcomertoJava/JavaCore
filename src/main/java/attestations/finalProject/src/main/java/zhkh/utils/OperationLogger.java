package zhkh.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class OperationLogger {

    @AfterReturning(
            pointcut = "execution(* zhkh.service.*Service.save*(..))",
            returning = "result"
    )
    public void logSaveOperation(JoinPoint joinPoint, Object result) {
        log.info("Saved entity: {}", result);
    }

    @AfterReturning("execution(* zhkh.service.*Service.delete*(..)) && args(id)")
    public void logDeleteOperation(JoinPoint joinPoint, Long id) {
        log.info("Deleted entity with ID: {}", id);
    }
}