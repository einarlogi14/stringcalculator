package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
	public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    	}	
	
	@Test
	public void testNewLine(){
	assertEquals(6, Calculator.add("1\n2,3"));
	}	
	
	@Test
	public void testDelim(){
	assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testDelimAddBiggerNumbers(){
	assertEquals(20, Calculator.add("//;\n10;10"));
	}

	@Test(expected = IllegalArgumentException.class)
        public void testInsertNegativeNumbers(){
        Calculator.add("1, -3");
        }

	@Test
	public void ThrowAndShowExceptionMessage(){
	try{
	Calculator.add("-2,2");
	}catch(IllegalArgumentException ex){
		assertEquals("Numbers not allowed: -2, ",ex.getMessage());
	}
	}

	@Test
	public void oneThousandOner(){
	assertEquals(2, Calculator.add("1001,2"));
	}
	
	@Test
	public void anyLengthDelim(){
	assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void anyLengthDelimPlusSign(){
	assertEquals(60, Calculator.add("//[++++]\n30++++20++++10"));
	}
	/*
	@Test
	public void multipleDelimeters(){
	assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}*/
}
