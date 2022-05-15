package com.example.springboot;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enums.eEnergy;
import utils.Garage;
import utils.InflateRequest;
import utils.VehicleRequest;
import vehicles.Vehicle;
import vehicles.Wheels;

@RestController
public class Controller {

	Garage garage;

	public Controller() {
		this.garage = new Garage();
	}
	
	// exposes get all vehicles endpoint by license number or without sorting (GET)
	@GetMapping("/get")
	public String GetAll(@RequestParam(name = "sortBy") String sortBy) {
		List<Vehicle> vehicles = this.garage.RetrieveAvailableVehicles();

		if (sortBy.equalsIgnoreCase("licenseNumber")) {
			vehicles.sort((Vehicle v1, Vehicle v2) -> v1.GetLicenseNumber().compareTo(v2.GetLicenseNumber()));
		}

		String result = "[ ";
		for (Vehicle v : vehicles) {
			result += v.toString() + ", ";
		}
		result += " ]";
		return result;
	}

	// exposes get vehicle by license number endpoint (GET)
	@GetMapping("/get/{licenseNumber}")
	public String GetOne(@PathVariable String licenseNumber) {
		return this.garage.RetrieveVehicle(licenseNumber).toString();
	}

	// exposes add vehicle endpoint (POST)
	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Create(@RequestBody VehicleRequest reqBody) {
		eEnergy energy = reqBody.getEnergy().equalsIgnoreCase("battery") ? eEnergy.Battery : eEnergy.Fuel;
		Vehicle newVehicle = this.garage.AddVehicle(reqBody.getType(), reqBody.getModelName(), energy,
				reqBody.getCurrentWheelsPressure(), reqBody.getCurrentEnergyLevel());
		return newVehicle.toString();
	}

	//exposes inflate wheels endpoint (PUT)
	@PutMapping(value ="/inflate-wheels", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Inflate(@RequestBody InflateRequest reqBody) {
		Vehicle vehicle = this.garage.RetrieveVehicle(reqBody.GetLicenseNumber());

		for (Wheels w : vehicle.GetWheels()) {
			w.InflateTire(reqBody.GetInflateAmount());
		}

		return vehicle.toString();
	}

	//exposes add energy by license number endpoint (PUT)
	@PutMapping("/add-energy/{licenseNumber}")
	public String AddEnergy(@PathVariable String licenseNumber) {
		Vehicle vehicle = this.garage.RetrieveVehicle(licenseNumber);
		vehicle.AddEnergy();
		return vehicle.toString();
	}
}
