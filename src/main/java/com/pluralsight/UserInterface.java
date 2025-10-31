package com.pluralsight;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

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

	private void displayVehicles(ArrayList<Vehicle> vehiclesToPrint) {
		for(Vehicle v : vehiclesToPrint) {
			System.out.println(v);
		}
	}

	private void loadDealershipFromFile() {
		this.dealership = DealershipFileManager.getDealership("inventory.csv");
	}


	// displays menus
	public void display() {

		loadDealershipFromFile();

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
					menu = "home";
					clearScreen();
					break;
				case "av":
					processAddVehicleRequest();
					menu = "home";
					clearScreen();
					break;
				case "rv":
					processRemoveVehicleRequest();
					menu = "home";
					clearScreen();
					break;
				case "ps":
					processGetByPriceRequest();
					menu = "home";
					clearScreen();
					break;
				case "ms":
					processGetByMakeModelRequest();
					menu = "home";
					clearScreen();
					break;
				case "ys":
					processGetByYearRequest();
					menu = "home";
					clearScreen();
					break;
				case "cs":
					processGetByColorRequest();
					menu = "home";
					clearScreen();
					break;
				case "os":
					processGetByMileageRequest();
					menu = "home";
					clearScreen();
					break;
				case "ts":
					processGetByVehicleTypeRequest();
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

						  // 1011 | 1920 | Silver     | Lockheed   | Model 10 Electra | Turbo-prop | 875339   | $352947.00
		System.out.println( "Vin  | Year | Color      | Make       | Model            | Type       | Mileage  | Price(USD)  ");
		displayVehicles(dealership.getAllVehicles());

		printMenuSoftBumper();
		printMenuLine("Press enter to continue...");
		printMenuBumper();

		getInput.nextLine();
	}

	public void processGetByPriceRequest() {
		printMenuBumper();
		printMenuLine("Please enter MAXIMUM price:");
		printMenuBumper();
		double max = Double.parseDouble(getInput.nextLine());

		printMenuBumper();
		printMenuLine("Please enter MINIMUM price:");
		printMenuBumper();
		double min = Double.parseDouble(getInput.nextLine());
		clearScreen();


		printMenuBumper();
		printMenuLine(String.format("Showing vehicles in price range: %.2f - %.2f", max, min));
		printMenuSoftBumper();
		// 1011 | 1920 | Silver     | Lockheed   | Model 10 Electra | Turbo-prop | 875339   | $352947.00
		System.out.println( "Vin  | Year | Color      | Make       | Model            | Type       | Mileage  | Price(USD)  ");
		displayVehicles(dealership.getVehiclesByPrice(min, max));

		printMenuSoftBumper();
		printMenuLine("Press enter to continue...");
		printMenuBumper();

		getInput.nextLine();
	}

	public void processGetByMakeModelRequest() {
		printMenuBumper();
		printMenuLine("Please enter make to search (case insensitive):");
		printMenuBumper();
		String makeSearch = getInput.nextLine();
		clearScreen();

		printMenuBumper();
		printMenuLine("Please enter model to search (case insensitive):");
		printMenuBumper();
		String modelSearch = getInput.nextLine();
		clearScreen();

		printMenuBumper();
		printMenuLine(String.format("Showing vehicles with make/model: %s/%s", makeSearch, modelSearch));
		printMenuSoftBumper();

		                     // 1011 | 1920 | Silver     | Lockheed   | Model 10 Electra | Turbo-prop | 875339   | $352947.00
		System.out.println( "Vin  | Year | Color      | Make       | Model            | Type       | Mileage  | Price(USD)  ");
		displayVehicles(dealership.getVehiclesByMakeModel(makeSearch, modelSearch));

		printMenuSoftBumper();
		printMenuLine("Press enter to continue...");
		printMenuBumper();

		getInput.nextLine();
	}

	public void processGetByYearRequest() {
		printMenuBumper();
		printMenuLine("Please enter MAXIMUM year:");
		printMenuBumper();
		int max = Integer.parseInt(getInput.nextLine());

		printMenuBumper();
		printMenuLine("Please enter MINIMUM year:");
		printMenuBumper();
		int min = Integer.parseInt(getInput.nextLine());
		clearScreen();

		printMenuBumper();
		printMenuLine(String.format("Showing vehicles by year range: %d - %d", max, min));
		printMenuSoftBumper();
		// 1011 | 1920 | Silver     | Lockheed   | Model 10 Electra | Turbo-prop | 875339   | $352947.00
		System.out.println( "Vin  | Year | Color      | Make       | Model            | Type       | Mileage  | Price(USD)  ");
		displayVehicles(dealership.getVehiclesByYear(min, max));

		printMenuSoftBumper();
		printMenuLine("Press enter to continue...");
		printMenuBumper();

		getInput.nextLine();
	}

	public void processGetByColorRequest() {
		printMenuBumper();
		printMenuLine("Please enter color to search (case insensitive):");
		printMenuBumper();
		String colorSearch = getInput.nextLine();
		clearScreen();

		printMenuBumper();
		printMenuLine(String.format("Showing vehicles with color: %s", colorSearch));
		printMenuSoftBumper();

		// 1011 | 1920 | Silver     | Lockheed   | Model 10 Electra | Turbo-prop | 875339   | $352947.00
		System.out.println( "Vin  | Year | Color      | Make       | Model            | Type       | Mileage  | Price(USD)  ");
		displayVehicles(dealership.getVehiclesByColor(colorSearch));

		printMenuSoftBumper();
		printMenuLine("Press enter to continue...");
		printMenuBumper();

		getInput.nextLine();
	}

	public void processGetByMileageRequest() {
		printMenuBumper();
		printMenuLine("Please enter MAXIMUM mileage:");
		printMenuBumper();
		int max = Integer.parseInt(getInput.nextLine());

		printMenuBumper();
		printMenuLine("Please enter MINIMUM mileage:");
		printMenuBumper();
		int min = Integer.parseInt(getInput.nextLine());
		clearScreen();

		printMenuBumper();
		printMenuLine(String.format("Showing vehicles by mileage range: %d - %d", max, min));
		printMenuSoftBumper();
		// 1011 | 1920 | Silver     | Lockheed   | Model 10 Electra | Turbo-prop | 875339   | $352947.00
		System.out.println( "Vin  | Year | Color      | Make       | Model            | Type       | Mileage  | Price(USD)  ");
		displayVehicles(dealership.getVehiclesByMileage(min, max));

		printMenuSoftBumper();
		printMenuLine("Press enter to continue...");
		printMenuBumper();

		getInput.nextLine();
	}

	public void processGetByVehicleTypeRequest() {
		printMenuBumper();
		printMenuLine("Please enter vehicle type to search (EX. dual-prop, turbo-prop, etc.):");
		printMenuBumper();
		String typeSearch = getInput.nextLine();
		clearScreen();

		printMenuBumper();
		printMenuLine(String.format("Showing vehicles of type: %s", typeSearch));
		printMenuSoftBumper();
		//
		System.out.println( "Vin  | Year | Color      | Make       | Model            | Type       | Mileage  | Price(USD)  ");
		displayVehicles(dealership.getVehiclesByType(typeSearch));

		printMenuSoftBumper();
		printMenuLine("Press enter to continue...");
		printMenuBumper();

		getInput.nextLine();
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
				printMenuLine("Vehicle added successfully.");
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
		String statusString = "WARNING, vehicle removal failed. No matching vehicle found.";
		printMenuBumper();
		printMenuLine("Enter the VIN of the vehicle you want to remove:");
		printMenuBumper();

		int vin = Integer.parseInt(getInput.nextLine());
		clearScreen();
		try {
			for (Vehicle v : dealership.getAllVehicles()) {
				if (v.getVin() == vin) {
					dealership.removeVehicle(v);
					statusString = "Vehicles with selected VIN have been removed.";
					break;
				}
			}
		} catch (Exception ex) {
			statusString = "WARNING, vehicle removal failed. Check your CSV file and consider backing it up.";
		}

		printMenuBumper();
		printMenuLine(statusString);
		printMenuLine("Press enter to continue...");
		printMenuBumper();
		getInput.nextLine();
	}

}// UserInterface