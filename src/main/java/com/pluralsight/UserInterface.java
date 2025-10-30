package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class UserInterface {

	// fields
	private Dealership dealership;
	private String menu = "home";
	Scanner getInput = new Scanner(System.in);


	// constructor
	public UserInterface() {

	}


	// make ui pretty <3
	private void printMenuBumper() {
						  //[1011 | 1920 | Silver     | Lockheed   | Model 10 Electra | Turbo-prop | 875339   | $352947.00  ]
		System.out.println("-------------------------------------------------------------------------------------------------");
	}

	private void printMenuSoftBumper() {
						  //[1011 | 1920 | Silver     | Lockheed   | Model 10 Electra | Turbo-prop | 875339   | $352947.00  ]
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
	}

	private void printMenuConnector() {
		                  //[1011 | 1920 | Silver     | Lockheed   | Model 10 Electra | Turbo-prop | 875339   | $352947.00  ]
		System.out.println("|-----------------------------------------------------------------------------------------------|");
	}

	private void printMenuLine(String line) {
		System.out.printf("| %-93s |\n", line);
	}

	private void clearScreen() {
		System.out.print("\033\143" + "\n");
	}


	// helpers
	private void displayVehicles(ArrayList<Vehicle> vehiclesToPrint) {
		for(Vehicle v : vehiclesToPrint) {
			System.out.println(v);
		}
	}

	private void loadDealership() {
		this.dealership = DealershipFileManager.getDealership("dealership.csv");
	}


	// displays menus
	public void display() {

		loadDealership();


		while(menu != null) {
			switch(menu) {
				case "home":
					printMenuBumper();

					printMenuLine("Welcome to " + dealership.getName() + "!");
					printMenuLine(dealership.getAddress());
					printMenuLine(dealership.getPhoneNumber());

					printMenuLine("");
					printMenuLine("What would you like to do?");
					printMenuConnector();
					printMenuLine("va --------------------------- View All");
					printMenuLine("av ------------------------ Add Vehicle");
					printMenuLine("rv --------------------- Remove Vehicle");
					printMenuConnector();
					printMenuLine("qq ------ Quit Program and Save Changes");
					printMenuLine("q! -------- Quit Program Without Saving");
					printMenuConnector();
					printMenuLine("ps ----------------------- Price Search");
					printMenuLine("ms ------------------ Make/Model Search");
					printMenuLine("ys ------------------------ Year Search");
					printMenuLine("cs ----------------------- Color Search");
					printMenuLine("os -------------------- Odometer Search");
					printMenuLine("ts ------------------------ Type Search");
					printMenuBumper();

					menu = getInput.nextLine().toLowerCase();

					clearScreen();
					break;
				case "va":
					processGetAllVehiclesRequest();
					clearScreen();
					break;
				case "av":
					processAddVehicleRequest();
					menu = "home";
					clearScreen();
					break;
				case "q!":
					printMenuBumper();
					printMenuLine("Are you sure you want to quit without saving?");
					printMenuLine("Enter 'y' to confirm.");
					printMenuBumper();

					if(getInput.nextLine().equalsIgnoreCase("y")) {
						menu = null;
						break;
					}

					clearScreen();
					menu = "home";
					break;
				case "qq":
					System.out.println("Saving...");

					try {
						DealershipFileManager.saveDealership(dealership);
					} catch(Exception ex) {
						printMenuBumper();
						printMenuLine("WARNING! Saving FAILED.");
						printMenuLine("Check your .csv file and consider backing it up.");
						printMenuLine("Press enter to continue...");
						printMenuBumper();
						menu = "home";

						getInput.nextLine();

						break;
					}

					clearScreen();
					System.out.println("Saved successfully.");

					menu = null;
					break;
				default:
					menu = "home";
					break;
			}
		}

	} // display

	// processing requests
	public void processGetAllVehiclesRequest() {
		printMenuBumper();
		printMenuLine("Showing all vehicles...");
		printMenuSoftBumper();
		//[1011 | 1920 | Silver     | Lockheed   | Model 10 Electra | Turbo-prop | 875339   | $352947.00  ]
		System.out.println("[Vin  | Year | Color      | Make       | Model            | Type       | Mileage  | Price(USD)  ]");

		printMenuSoftBumper();
		printMenuLine("Press enter to continue...");
		printMenuBumper();

		menu = "home";
		getInput.nextLine();
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

	public void processAddVehicleRequest() {
		printMenuBumper();
		printMenuLine("Enter vehicle info in format: ");
		printMenuLine("VIN|Year|Make|Model|Type|Color|Odometer|Price");

		try {
			String[] lineParsed = getInput.nextLine().split("\\|");
			ArrayList<Integer> vins = new ArrayList<Integer>();
			for (Vehicle v : dealership.getAllVehicles()) {
				vins.add(v.getVin());
			}
			if(!vins.contains(Integer.parseInt(lineParsed[0]))) {
				dealership.addVehicle(new Vehicle(Integer.parseInt(lineParsed[0]), Integer.parseInt(lineParsed[1]), lineParsed[2], lineParsed[3], lineParsed[4], lineParsed[5], Integer.parseInt(lineParsed[6]), Double.parseDouble(lineParsed[7])));
			}
		} catch (Exception ex) {
			System.out.println();
			printMenuBumper();
			printMenuLine("WARNING! Adding vehicle FAILED.");
			printMenuLine("You probably entered a vehicle with a VIN number that already exists.");
			printMenuLine("Otherwise, make sure you formatted your input correctly.");
			printMenuLine("Press enter to continue...");
			printMenuBumper();
		}

		getInput.nextLine();
	}

	public void processRemoveVehicleRequest() {

	}

}// UserInterface
