
package com.squareshift.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.squareshift.dto.PhoneNumberDTO;
import com.squareshift.entities.DictionaryEntity;
import com.squareshift.util.PhoneNumberUtil;
/**
 * 
 * @author Admin
 *
 */
public class PhoneNumberHelperTest {

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
	public void testGetListOfAlternativesListOfEachNumber() {
		String number = "23";
		PhoneNumberDTO phoneNumber = new PhoneNumberDTO(number);
		DictionaryEntity alphaPhraseDictionary = new DictionaryEntity();
		Set<String> alternativesfor2 = alphaPhraseDictionary.getSetOfPossiblePhrasesForNumber("2");
		Set<String> alternativesfor3 = alphaPhraseDictionary.getSetOfPossiblePhrasesForNumber("3");
		List<Set<String>> expectedListOfAlternativeSetsOfEachNumber = new ArrayList<Set<String>>();
		expectedListOfAlternativeSetsOfEachNumber.add(alternativesfor2);
		expectedListOfAlternativeSetsOfEachNumber.add(alternativesfor3);
		List<Set<String>> actualListOfAlternativeSetsOfEachNumber = PhoneNumberUtil
				.getListOfPossiblePhrasesForEachNumber(phoneNumber);
		Assert.assertArrayEquals(expectedListOfAlternativeSetsOfEachNumber.toArray(),
				actualListOfAlternativeSetsOfEachNumber.toArray());
	}

	@Test
	public void testGetListOfPossiblePhrasesForNumber() {
		String number = "23";
		PhoneNumberDTO phoneNumber = new PhoneNumberDTO(number);
		List<String> expectedList = Arrays.asList("AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF");
		List<String> actualList = PhoneNumberUtil.getListofPossiblePhrasesForPhoneNumber(phoneNumber);
		Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	@Test
	public void testSetCanHaveReplacementsFlagForNumber() {
		String number = "26500039";
		PhoneNumberDTO phoneNumber = new PhoneNumberDTO(number);
		PhoneNumberUtil.setCanHaveReplacementsFlagForNumber(phoneNumber);
		Assert.assertFalse("",phoneNumber.getCanHaveReplacements());
	}
	

	@Test
	public void testSetCanHaveReplacementsFlagForNumbersWithHyphen() {
		String number = "26-039";
		PhoneNumberDTO phoneNumber = new PhoneNumberDTO(number);
		PhoneNumberUtil.setCanHaveReplacementsFlagForNumber(phoneNumber);
		Assert.assertTrue("Possitive condition failes", phoneNumber.getCanHaveReplacements());
	}
	
	@Test
	public void testGetListOfPossiblePhrasesForNumberWithHyphen() {
		String number = "2-3";
		PhoneNumberDTO phoneNumber = new PhoneNumberDTO(number);
		List<String> expectedList = Arrays.asList("A-D", "A-E", "A-F", "B-D", "B-E", "B-F", "C-D", "C-E", "C-F");
		List<String> actualList = PhoneNumberUtil.getListofPossiblePhrasesForPhoneNumber(phoneNumber);
		Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	@Test
	public void testGetListOfPossiblePhrasesForNumberWithComma() {
		String number = "2,3";
		PhoneNumberDTO phoneNumber = new PhoneNumberDTO(number);
		List<String> expectedList = Arrays.asList("A,D", "A,E", "A,F", "B,D", "B,E", "B,F", "C,D", "C,E", "C,F");
		List<String> actualList = PhoneNumberUtil.getListofPossiblePhrasesForPhoneNumber(phoneNumber);
		Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	@Test
	public void testGetListOfPossiblePhrasesForNumberWithDot() {
		String number = "2.3";
		PhoneNumberDTO phoneNumber = new PhoneNumberDTO(number);
		List<String> expectedList = Arrays.asList("A-D", "A-E", "A-F", "B-D", "B-E", "B-F", "C-D", "C-E", "C-F");
		List<String> actualList = PhoneNumberUtil.getListofPossiblePhrasesForPhoneNumber(phoneNumber);
		Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	@Test
	public void testGetListOfPossiblePhrasesWithSpace() {
		String number = "2 3";
		PhoneNumberDTO phoneNumber = new PhoneNumberDTO(number);
		List<String> expectedList = Arrays.asList("A-D", "A-E", "A-F", "B-D", "B-E", "B-F", "C-D", "C-E", "C-F");
		List<String> actualList = PhoneNumberUtil.getListofPossiblePhrasesForPhoneNumber(phoneNumber);
		Assert.assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}


}
