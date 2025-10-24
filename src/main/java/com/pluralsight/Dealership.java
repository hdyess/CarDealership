package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

	//fields
	String name;
	String address;
	String phoneNumber;
	ArrayList<Vehicle> vehicles = new ArrayList<>();


	// constructor
	public void dealership(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	// get vehicles w/filters
	public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.price >= min && v.price <= max) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.make.equalsIgnoreCase(make) && v.model.equalsIgnoreCase(model)) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.year >= min && v.year <= max) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getVehiclesByColor(String color) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.color.equalsIgnoreCase(color)) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.odometer >= min && v.odometer <= max) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getVehiclesByType(String type) {
		ArrayList<Vehicle> vehiclesToReturn = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.vehicleType.equalsIgnoreCase(type)) {
				vehiclesToReturn.add(v);
			}
		}
		return vehiclesToReturn;
	}

	public ArrayList<Vehicle> getAllVehicles() {
		return vehicles;
	}

	// add and remove vehicles
	public void addVehicle(Vehicle vehicleToAdd) {
		vehicles.add(vehicleToAdd);
	}

	public void removeVehicle(Vehicle vehicleToRemove) {
		vehicles.remove(vehicleToRemove);
	}

} // Dealership