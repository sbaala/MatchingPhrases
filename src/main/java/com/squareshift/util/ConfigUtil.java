
package com.squareshift.util;

import com.google.common.io.Resources;

/**
 * 
 * @author Admin
 *
 */
public class ConfigUtil {
	
	 public static final String DICTIONARY_PATH = Resources.getResource("data/dictionary.conf").getPath();
	 public static final String PHONE_DIRECTORY_PATH =Resources.getResource("data/phone-numbers.conf").getPath();
}