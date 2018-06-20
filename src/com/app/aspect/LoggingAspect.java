package com.app.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//@Component
//@Aspect
public class LoggingAspect {
	//create logger object
	private final Log log=LogFactory.getLog(getClass());
	
	@Pointcut("execution(* com.app..*.*(..))")
	public void p1(){}
	
	@Around("p1()")
	public Object checkAround(ProceedingJoinPoint jp){
		String clsName=jp.getTarget().getClass().getName();
		StopWatch watch=new StopWatch(clsName);
		
		Object ob=null;
		try {
			log.info(jp.getSignature().getName()+" is started...");
			watch.start(jp.getSignature().getName());
			ob=jp.proceed();
			watch.stop();
			log.info(jp.getSignature().getName()+" is stopped...");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.debug(watch.prettyPrint());
		return ob;
	}
	@AfterThrowing(pointcut="p1()",throwing="th")
	public void getErrors(Throwable th){
		log.error(th);		
	}
	
	@AfterReturning(pointcut="p1()",returning="ob")
	public void simpleWarn(Object ob){
		log.warn("Method end .. variables memory needs to check..");
	}
	@AfterThrowing(pointcut="p1()",throwing="th")
	public void highProblems(Throwable th){
		if(th.getMessage().contains("BeanCreationError")){
			log.fatal("Highe level problem in config..");
		}
		
	}
	
	
}




