 package util;

import javax.jdo.Transaction;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TransactionJdoUtil {
	private ThreadLocal<Transaction> local = new ThreadLocal<Transaction>();
	@Before("execution(* service.impl.*.*(..))")
	public void beginTransaction(){
		Transaction t = PMF.getManager().currentTransaction();
		local.set(t);
		t.begin();
	}
	
	@AfterReturning(pointcut="execution(* service.impl.*.*(..))")
	public void commitTransaction(){
		local.get().commit();
	}
}
