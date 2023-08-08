package test12;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Te1 {

	
	@BeforeClass
	public void beforeclass() {
		System.out.println("hello");
	}
	
	
	@Test
	public void teA() {
		System.out.println("hii");
	}
}
