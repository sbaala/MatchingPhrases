
package com.squareshift.tests;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.squareshift.util.GenericUtil;
/**
 * 
 * @author Admin
 *
 */
public class GenericHelperTest {

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
	public void testConvertListOfStringstoString() {
		List<String> inputList = Arrays.asList("a", "b", "c");
		String expectedString = "abc";
		String actualString = GenericUtil.convertListOfStringstoString(inputList);
		Assert.assertEquals(expectedString, actualString);
	}

	@Test
	public void testReplaceDotWithHyphen() {
		String input = "ab.c";
		String expected = "ab-c";
		String actual = GenericUtil.replaceDotWithHyphen(input);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testReplaceSpacewithHyphen() {
		String input = "a b c";
		String expected = "a-b-c";
		String actual = GenericUtil.replaceSpacewithHyphen(input);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testReplaceAllPunctuationFromString() {
		String input = "1,3,$,124";
		String expected = "13124";
		String actual = GenericUtil.removeEveryPunctuation(input);
		Assert.assertEquals(expected, actual);
	}

}
