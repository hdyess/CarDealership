package com.pluralsight;

public class Main {

	public static void main(String[] args) {

		Dealership dealership = DealershipFileManager.getDealership("dealership.csv");

		System.out.println(dealership);



	}

}// Main
