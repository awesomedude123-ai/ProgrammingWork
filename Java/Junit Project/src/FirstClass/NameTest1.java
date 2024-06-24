package FirstClass;

import static org.junit.Assert.*;


import org.junit.Test;

public class NameTest1 {

	@Test
	public void test() {
		System.out.println("The string is about to be checked.");
		String str1="Cool";
		assertEquals("Cool",str1);

	}

}
