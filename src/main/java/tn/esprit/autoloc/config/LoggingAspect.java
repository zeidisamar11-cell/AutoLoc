package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().getName();

        Object[] parameters = joinPoint.getArgs();

        log.info("Before - Méthode appelée : " + methodName + " avec les paramètres : " + Arrays.toString(parameters));
    }
}


