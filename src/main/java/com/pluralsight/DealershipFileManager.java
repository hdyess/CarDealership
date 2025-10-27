package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {

	public static Dealership getDealership(String csvName) {

		try {

			FileReader fileReader = new FileReader(csvName);
			BufferedReader buffReader = new BufferedReader(fileReader);
			String[] dealLine = buffReader.readLine().split("\\|");
			Dealership returnDealership = new Dealership(dealLine[0], dealLine[1], dealLine[2]);

			String line;
			String[] lineParsed;
			while ((line = buffReader.readLine()) != null) {
				lineParsed = line.split("\\|");
				

			}

			return returnDealership;

		} catch (Exception ex) {
			System.out.println("Error occurred, check your dealership.csv file.");
		}



		return new Dealership("error", "error", "error");
	}

	public void saveDealership(Dealership dealershipToSave) {

	}

}
