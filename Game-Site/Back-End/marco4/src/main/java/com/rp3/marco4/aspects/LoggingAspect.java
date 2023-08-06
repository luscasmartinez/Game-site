package com.rp3.marco4.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.rp3.marco4.repositories.*.save*(..))")
    public void savePointcut() {
    }

    @Pointcut("execution(* com.rp3.marco4.services.ClientService.findById(..))")
    public void findByIdPointcut() {
    }

    @Pointcut("execution(* com.rp3.marco4.repositories.*.delete*(..))")
    public void deletePointcut() {
    }

    @Before("savePointcut()")
    public void logBeforeSave(JoinPoint joinPoint) {
        log.info("Realizando uma operação de salvamento: {}.{}",
                joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "savePointcut()", returning = "object")
    public void logSaveOperation(JoinPoint joinPoint, Object object) {
        log.info("Objeto salvo: {}.{}() com dados = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), object);
    }

    @Before("deletePointcut()")
    public void logBeforeDelete(JoinPoint joinPoint) {
        log.info("Realizando uma operação de exclusão: {}.{}",
                joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "deletePointcut()", returning = "result")
    public void logAfterDelete(JoinPoint joinPoint, Object result) {
        log.info("Operação de exclusão concluída: {}.{}",
                joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "findByIdPointcut()", returning = "result")
    public void logEditOperation(JoinPoint joinPoint, Object result) {
        log.info("Tela de Edição ou Exclusão requisitada: {}.{}() com ID = {}",
                joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), result);
    }
}