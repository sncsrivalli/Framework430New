package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass2 {

	@Test
	public void test1() {
		System.out.println("TestClass2 => test1");
	}
	
	@Test
	public void test2() {
		System.out.println("TestClass2 => test2");
		Assert.fail();
	}
}
