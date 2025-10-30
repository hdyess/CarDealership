package com.pluralsight;

public class UserInterface {

	private Dealership dealership;

	private void initDealership() {
		this.dealership = DealershipFileManager.getDealership("dealership.csv");
	}

	private void printMenuBumper() {
		System.out.println("----------------------------------------------------------------");
	}

	private void printMenuLine(String line) {
		System.out.printf("| %60s |\n", line);
	}


	//public
	public void userInterface() {

	}

	public void display() {

	}

	public void processGetByPriceRequest() {

	}

	public void processGetByMakeModelRequest() {

	}

	public void processGetByYearRequest() {

	}

	public void processGetByColorRequest() {

	}

	public void processGetByMileageRequest() {

	}

	public void processGetByVehicleTypeRequest() {

	}

	public void processGetAllVehiclesRequest() {

	}

	public void processAddVehicleRequest() {

	}

	public void processRemoveVehicleRequest() {

	}



}
