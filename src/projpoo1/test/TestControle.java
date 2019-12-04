package test;


import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import projpoo1.Programme;

public class TestControle {

	@Test
	public void testVerifDate() {
		try {
			assertTrue(Programme.verifDate("10/12/2019") instanceof Date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
