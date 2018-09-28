package net.azalea.springbootaoplog.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * https://www.cnblogs.com/bigben0123/p/7779357.html
 * @author user
 *
 */
//@Aspect
//@Configuration
public class LogAspect {
	
    @Pointcut("execution(* net.azalea.springbootaoplog.controller.*.*(..))")  
	public void webLog(){}
	
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable{
		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest  request = attribute.getRequest();
		System.out.println(request.getRequestURI());
	}
	
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret){
		// 处理完请求，返回内容  
        System.out.println("方法的返回值 : " + ret);  
	}
	
	/**
	 * 后置异常通知
	 * @param joinPoint
	 */
	@AfterThrowing("webLog()")
	public void throwss(JoinPoint joinPoint){
		System.out.println("方法异常时执行.....");  
	}
	
	/**
	 * 后置最终通知，finalz增强，不管抛出异常或者正常退出都会执行	
	 */
	@After("webLog()")
	public void after(JoinPoint joinPoint){
		System.out.println("方法最后执行.....");  
	}
	
	/**
	 * 环绕通知，环绕增强，相当于MethodInterceptor
	 */
	@Around("webLog()")
	public Object around(ProceedingJoinPoint pjp){
		System.out.println("方法环绕start.....");  
		try {
			Object o = pjp.proceed();
			System.out.println("方法环绕proceed，结果是 :" + o); 
			return o;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
