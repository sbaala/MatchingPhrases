
package com.squareshift.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import com.google.common.collect.Sets;
import com.squareshift.util.ConfigUtil;
/**
 * 
 * @author Admin
 *
 */
public class DictionaryEntity {

	private String dictionaryPath = ConfigUtil.DICTIONARY_PATH;
	
	private Properties dictionaryData = new Properties();
	
	public DictionaryEntity() {
		setDictionaryData();
	}
	/**
	 * 
	 * @param number
	 * @return
	 */
	public Set<String> getSetOfPossiblePhrasesForNumber(String number) {
		String phrase = dictionaryData.getProperty(number);
		Set<String> possiblePhrasesForNumber;
		if (phrase == null) {
			possiblePhrasesForNumber = Sets.newHashSet(number);
		} else {
			possiblePhrasesForNumber = Sets.newHashSet(phrase.toUpperCase().split("\\s*,\\s*"));
		}
		return possiblePhrasesForNumber;
	}

	private void setDictionaryData() {
		try {
			File file = new File(dictionaryPath);
			FileInputStream fileInput;
			fileInput = new FileInputStream(file);
			dictionaryData.load(fileInput);
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	public boolean checkWhetherDigitHasReplacements(String number) {
		String phrase = dictionaryData.getProperty(number);
		if (phrase == null) {
			return false;
		} else {
			return true;
		}
	}

}
