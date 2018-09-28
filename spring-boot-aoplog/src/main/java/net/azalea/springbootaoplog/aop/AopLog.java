package net.azalea.springbootaoplog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;
import net.azalea.springbootaoplog.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * aop �����¼������־
 *
 * @package: com.xkcoding.springbootdemoaoplog.aspectj
 * @description��aop �����¼������־
 * @author: yangkai.shen
 * @date: Created in 2017/11/24 ����9:43
 * @copyright: Copyright (c) 2017
 * @version: 0.0.1
 * @modified: yangkai.shen
 */
/*@Aspect
@Component*/
@Slf4j
public class AopLog {
	private static final String START_TIME = "start-request";

	@Pointcut("execution(* net.azalea.springbootaoplog.controller.*.*(..))")  
	public void log() {
	}

	@Before("log()")
	public void beforeLog(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		log.info("������ URL����{}", request.getRequestURL());
		log.info("������ IP����{}", request.getRemoteAddr());
		log.info("��������������{}�������󷽷�������{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
		Map parameterMap = request.getParameterMap();
		log.info("�������������{}��", JsonMapper.obj2Str(parameterMap));
		Long start = System.currentTimeMillis();
		request.setAttribute(START_TIME, start);
	}

	@Around("log()")
	public Object arroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = proceedingJoinPoint.proceed();
		log.info("������ֵ����{}", JsonMapper.obj2Str(result));
		return result;
	}

	@AfterReturning("log()")
	public void afterReturning(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		Long start = (Long) request.getAttribute(START_TIME);
		Long end = System.currentTimeMillis();
		log.info("�������ʱ����{}����", end - start);
		String header = request.getHeader("User-Agent");
	}
}
