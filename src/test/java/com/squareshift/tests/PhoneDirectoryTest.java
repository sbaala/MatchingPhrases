
package com.squareshift.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.squareshift.dto.PhoneNumberDTO;
import com.squareshift.entities.PhoneEntity;
/**
 * 
 * @author Admin
 *
 */
public class PhoneDirectoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetListOfNumbersInDirectory() {
		String directoryPath="D:\\data\\squareshift\\src\\main\\resources\\data\\phone-numbers.conf";
		PhoneEntity phoneDirectory = new PhoneEntity();
		List<String> expectedListOfNumbers = Arrays.asList("26588409", "9535572239", "23452366");
		List<PhoneNumberDTO> ListOfNumbers = phoneDirectory.getListOfNumbersInDirectory(directoryPath);
		List<String> actualListOfNumbers = new ArrayList<String>();
		for (Iterator<PhoneNumberDTO> iterator = ListOfNumbers.iterator(); iterator.hasNext();) {
			PhoneNumberDTO phoneNumber = (PhoneNumberDTO) iterator.next();
			actualListOfNumbers.add(phoneNumber.getNumber());
		}
		Assert.assertArrayEquals(expectedListOfNumbers.toArray(), actualListOfNumbers.toArray());
	}

}
