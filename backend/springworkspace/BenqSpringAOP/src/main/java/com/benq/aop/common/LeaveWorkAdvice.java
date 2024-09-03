package com.benq.aop.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LeaveWorkAdvice {
	
	@Pointcut("execution(* com.benq.aop..*Controller.checkLogout(..))" )
	public void ctrlPointCut()	{}
	@Before("ctrlPointCut()")
	public void printLeaveWorkTime() {
		System.out.println("퇴근하였습니다.");
	}
}
