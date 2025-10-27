package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {

	public static Dealership getDealership(String csvName) {

		try {

			FileReader fileReader = new FileReader(csvName);
			BufferedReader buffReader = new BufferedReader(fileReader);
			String[] initLine = buffReader.readLine().split("\\|");
			Dealership returnDealership = new Dealership(initLine[0], initLine[1], initLine[2]);

			String line;
			while ((line = buffReader.readLine()) != null) {
				String[] lineParsed = line.split("\\|");
				//todo: i swear this can be better i just don't know how
				returnDealership.addVehicle(new Vehicle(Integer.parseInt(lineParsed[0]), Integer.parseInt(lineParsed[1]), lineParsed[2], lineParsed[3], lineParsed[4], lineParsed[5], Integer.parseInt(lineParsed[6]), Integer.parseInt(lineParsed[7])));
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
