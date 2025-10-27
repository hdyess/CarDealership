package com.pluralsight;

import java.sql.SQLOutput;

public class Main {

	public static void main(String[] args) {

		Dealership dealership = DealershipFileManager.getDealership("dealership.csv");

		System.out.println(dealership);

		System.out.println(dealership.getAllVehicles());

	}

}// Main
