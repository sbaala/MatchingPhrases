
package com.squareshift.util;

import java.util.Iterator;
import java.util.List;
/**
 * 
 * @author Admin
 *
 */
public class GenericUtil {

	public static String convertListOfStringstoString(List<String> list) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String phrase = (String) iterator.next();
			stringBuilder.append(phrase);
		}
		return stringBuilder.toString();
	}

	public static String replaceDotWithHyphen(String string) {
		return string.replaceAll("[.]", "-");
	}

	public static String replaceSpacewithHyphen(String string) {
		return string.replaceAll("\\s", "-");
	}
	
	public static String removeEveryPunctuation(String string) {
		return string.replaceAll("[^a-zA-Z0-9]", "");
	}

}
