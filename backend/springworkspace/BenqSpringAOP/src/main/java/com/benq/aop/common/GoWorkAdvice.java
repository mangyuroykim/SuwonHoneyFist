package com.benq.aop.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GoWorkAdvice {
	
	@Pointcut("execution(* com.benq.aop..*ServiceImpl.checkLogi(..))")
	public void implPointcut() {}
	@After("implPointCut()")
	public void printGoWorkTime() {
		System.out.println("출근하였습니다.");
	}
}
