package junitCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitWorksheet2 {
	

	
	
	@Test
	public final void additionofIntsTest() {
		ExampleClass2 testClass = new ExampleClass2();
		int add = testClass.additionOfInts(200, 300);
		
		assertEquals(500, add);
		
		
	}
	
	@Test
	public final void concatOfStringsTest() {
		ExampleClass2 testClass = new ExampleClass2();
		String concat = testClass.concatOfStrings("Hello", "World");
		
		assertEquals("HelloWorld", concat);
	}
	
	@Test
	public final void isXORTest() {
		ExampleClass2 testClass = new ExampleClass2();
	    boolean a = true;
		boolean b = false;
		boolean XOR = testClass.isXOR(a, b);
		
		assertTrue(XOR);
	}

}
