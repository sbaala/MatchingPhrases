
package com.squareshift.entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.squareshift.dto.PhoneNumberDTO;
/**
 * 
 * @author Admin
 *
 */
public class PhoneEntity {


	public List<PhoneNumberDTO> getListOfNumbersInDirectory( String directoryPath ) {
		List<PhoneNumberDTO> listOfNumbers = new ArrayList<PhoneNumberDTO>();
		// Construct BufferedReader from FileReader
		try {
			File directoryInput = new File(directoryPath);
			BufferedReader br = new BufferedReader(new FileReader(directoryInput));
			String line = null;
			while ((line = br.readLine()) != null) {
				PhoneNumberDTO number = new PhoneNumberDTO(line);
				listOfNumbers.add(number);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listOfNumbers;
	}

}
