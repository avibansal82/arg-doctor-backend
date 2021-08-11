/*
 * arg license
 *
 */

package com.arg.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.arg.common.utils.MapperUtil;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@EnableAspectJAutoProxy
@Slf4j
@Aspect
@Configuration
public class LogAspect {

    @SuppressWarnings({"unchecked"})
    @Around("@annotation(Log)")
    public Mono<Object> doAround(ProceedingJoinPoint joinPoint) {
        Mono<Object> mono = Mono.empty();
        log.debug("Start of {}.{} method with request data {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), MapperUtil.toJson(joinPoint.getArgs()));
        try {
            mono = (Mono<Object>) joinPoint.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
        return mono.doOnNext(result -> {
            log.debug("End of {}.{} method with data {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), MapperUtil.toJson(result));
        }).doOnError(error -> {
            log.error("Error in {}.{} method ", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), error);
        });
    }
}
