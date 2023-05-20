package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLib.SampleBaseClass;

//@Listeners(genericLib.SampleListenersImp.class)
public class TestClass1 {

	@Test
	public void test1() {
		System.out.println("TestClass1 => test1");
	}
	
	@Test
	public void test2() {
		System.out.println("TestClass1 => test2");
		Assert.fail();
	}
}
