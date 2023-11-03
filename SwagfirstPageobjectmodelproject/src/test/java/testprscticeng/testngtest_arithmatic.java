package testprscticeng;

import org.testng.annotations.Test;

public class testngtest_arithmatic {
	@Test(expectedExceptions = ArithmeticException.class)   
	public void divisionWithException() {   
	int i = 1/0; 
	}
	
	@Test(enabled=false) 
	public void divisionWithException2() {   
	System.out.println("Method is not ready yet"); 
	} 
	
	@Test(timeOut = 1000)   
	 public void infinity() {   
	  while (true);   
	 } 
}
