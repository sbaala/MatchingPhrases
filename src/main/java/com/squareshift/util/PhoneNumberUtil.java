
package com.squareshift.util;

import java.util.*;

import com.google.common.collect.Sets;
import com.squareshift.dto.PhoneNumberDTO;
import com.squareshift.entities.DictionaryEntity;
/**
 * 
 * @author Admin
 *
 */
public class PhoneNumberUtil {
	/**
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static List<Set<String>> getListOfPossiblePhrasesForEachNumber(PhoneNumberDTO phoneNumber) {
		List<Set<String>> listOfPossiblePhrasesForEachNumber = new ArrayList<Set<String>>();
		List<String> listOfNumbersWithIn = phoneNumber.getListOfNumbersWithin();
		DictionaryEntity alphaPhraseDictionary = new DictionaryEntity();

		for (Iterator<String> iterator = listOfNumbersWithIn.iterator(); iterator.hasNext();) {
			String number = (String) iterator.next();
			Set<String> listOfPossibleAlternatesForNumber = alphaPhraseDictionary
					.getSetOfPossiblePhrasesForNumber(number);
			listOfPossiblePhrasesForEachNumber.add(listOfPossibleAlternatesForNumber);
		}

		return listOfPossiblePhrasesForEachNumber;
	}
	
	/**
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public static List<String> getListofPossiblePhrasesForPhoneNumber(PhoneNumberDTO phoneNumber) {
		List<String> listofPossiblePhrasesForNumber = new ArrayList<String>();
		List<Set<String>> listOfPossiblePhrasesForEachNumber = PhoneNumberUtil
				.getListOfPossiblePhrasesForEachNumber(phoneNumber);
		Set<List<String>> combinations = Sets.cartesianProduct(listOfPossiblePhrasesForEachNumber);
		for (Iterator<List<String>> iterator = combinations.iterator(); iterator.hasNext();) {
			List<String> list = (List<String>) iterator.next();
			String alphaPhrase = GenericUtil.convertListOfStringstoString(list);
			String alphaPhraseWithHyphen = GenericUtil
					.replaceDotWithHyphen(GenericUtil.replaceSpacewithHyphen(alphaPhrase));
			listofPossiblePhrasesForNumber.add(alphaPhraseWithHyphen);
		}
		return listofPossiblePhrasesForNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public static void setCanHaveReplacementsFlagForNumber(PhoneNumberDTO phoneNumber) {
		PhoneNumberDTO numberWithoutPunctuation = new PhoneNumberDTO(GenericUtil.removeEveryPunctuation(phoneNumber.getNumber()));
		
		List<String> listOfNumbersWithIn = numberWithoutPunctuation.getListOfNumbersWithin();
		DictionaryEntity alphaPhraseDictionary = new DictionaryEntity();
		for (int i = 1; i < listOfNumbersWithIn.size(); i++) {
			String currentNumber = listOfNumbersWithIn.get(i);
			String previousNumber = listOfNumbersWithIn.get(i - 1);
			Boolean currentNumberReplacementFlag = alphaPhraseDictionary
					.checkWhetherDigitHasReplacements(currentNumber);
			Boolean previousNumberReplacementFlag = alphaPhraseDictionary
					.checkWhetherDigitHasReplacements(previousNumber);
			if (!currentNumberReplacementFlag && !previousNumberReplacementFlag) {
				phoneNumber.setCanHaveReplacements(false);
			} 
		}

	}

}
