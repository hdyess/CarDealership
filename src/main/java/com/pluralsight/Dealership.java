package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

	//fields
	private String name;
	private String address;
	private String phoneNumber;
	private ArrayList<Vehicle> vehicles = new ArrayList<>();


	// get/setters for other fields
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	// constructor
	public Dealership(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	// get vehicles
	public ArrayList<Vehicle> getAllVehicles() {
		return vehicles;
	}

	public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.getPrice() >= min && v.getPrice() <= max) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.getYear() >= min && v.getYear() <= max) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getVehiclesByColor(String color) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.getColor().equalsIgnoreCase(color)) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.getOdometer() >= min && v.getOdometer() <= max) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getVehiclesByType(String type) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.getVehicleType().equalsIgnoreCase(type)) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}


	// add and remove vehicles
	public void addVehicle(Vehicle vehicleToAdd) {
		vehicles.add(vehicleToAdd);
	}

	public void removeVehicle(Vehicle vehicleToRemove) {
		vehicles.remove(vehicleToRemove);
	}

	@Override
	public String toString() {
		return name + " at " + address + "\nPhone: " + phoneNumber;
	}

} // Dealership