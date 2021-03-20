package com.squareshift.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.squareshift.dto.PhoneNumberDTO;
import com.squareshift.entities.PhoneEntity;
import com.squareshift.util.ConfigUtil;
import com.squareshift.util.PhoneNumberUtil;

/**
 * 
 * @author Admin
 *
 */
public class MainApp {

	public static void main(String[] args) {
		
		Scanner inputObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter the phone number file path ");

		String directoryPath = inputObj.nextLine(); 
		
		if(directoryPath.isEmpty())
			directoryPath=ConfigUtil.PHONE_DIRECTORY_PATH;

		
		PhoneEntity phoneEntity = new PhoneEntity();
		List<PhoneNumberDTO> listOfNumbersInDirectory = phoneEntity.getListOfNumbersInDirectory(directoryPath);
		List<PhoneNumberDTO> listOfIgnoredNumbers = new ArrayList<PhoneNumberDTO>();
		for (Iterator<PhoneNumberDTO> iterator = listOfNumbersInDirectory.iterator(); iterator.hasNext();) {
			PhoneNumberDTO phoneNumber = (PhoneNumberDTO) iterator.next();
			PhoneNumberUtil.setCanHaveReplacementsFlagForNumber(phoneNumber);
			if (phoneNumber.getCanHaveReplacements()) {
				List<String> listOfPossiblePhrases = PhoneNumberUtil
						.getListofPossiblePhrasesForPhoneNumber(phoneNumber);
				MainApp.displayList(listOfPossiblePhrases, phoneNumber.getNumber());
			} else {
				listOfIgnoredNumbers.add(phoneNumber);
			}
		}
		
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Completed Processing all phone numbers in the directory");
		System.out.println("-------------------------------------------------------------------");
		
		if(listOfIgnoredNumbers.size() > 0 ) {
			
			System.out.println("Below are the numbers ignored ");
			System.out.println("Reason : - These numbers have consecutive digits which does not have replacements in dictionary");
			System.out.println("-------------------------------------------------------------------");
			for (Iterator<PhoneNumberDTO> iterator = listOfIgnoredNumbers.iterator(); iterator.hasNext();) {
				PhoneNumberDTO phoneNumber = (PhoneNumberDTO) iterator.next();
				System.out.println(phoneNumber.getNumber());
			}
		}
		System.exit(0);
	}
	/**
	 * 
	 * @param combinations
	 * @param number
	 */
	private static void displayList(List<String> combinations, String number) {
		System.out.println("--------------------------------------");
		System.out.println("Possible Phrases of : " + number);
		System.out.println("--------------------------------------");
		for (Iterator<String> iterator = combinations.iterator(); iterator.hasNext();) {
			String alphaPhrase = (String) iterator.next();
			System.out.println(alphaPhrase);
		}

	}

}
