package com.cael.vraptor.testme;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMeTest {

	private TestMe subject;
	
	@Before
	public void setup() {
		subject = new TestMe();
	}
	
	@Test
	public void shoudReturnTrueIfIsOdd() {
		boolean odd = subject.isOdd(11);
		
		Assert.assertTrue(odd);
	}
	
	@Test
	public void shoudReturnFalseIfIsEven() {
		boolean even = subject.isOdd(10);
		
		Assert.assertFalse(even);
	}
	
}
