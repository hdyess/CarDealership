package com.pluralsight;

public class Vehicle {

	int vin;
	int year;
	String make;
	String model;
	String vehicleType;
	String color;
	int odometer;
	double price;

	public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
		this.vin = vin;
		this.year = year;
		this.make = make;
		this.model = model;
		this.vehicleType = vehicleType;
		this.color	= color;
		this.odometer = odometer;
		this.price = price;
	}

	//override
	@Override
	public String toString() {
		String returnString = "VIN: %10d |%s %d %s %10s | %s20 | Mileage: %d10 | $%.2f";
		return String.format(returnString, this.vin, this.color, this.year, this. make, this.model, this.vehicleType, this.odometer, this.price);
	}


} // vehicle
