package utils;
import enums.eEnergy;
import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Truck;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Garage
{
    List <Vehicle> m_Vehicles;

    public Garage()
    {
        this.m_Vehicles = new ArrayList<Vehicle>();
    }

    public Vehicle RetrieveVehicle(String i_LicenseNumber)
    {
        Vehicle vehicle = null;
        for (Vehicle v : m_Vehicles)
        {
            if (v.GetLicenseNumber().equals(i_LicenseNumber))
            {
                vehicle = v;
            }
        }
        
        return vehicle;
    }

    public List<Vehicle> RetrieveAvailableVehicles()
    {
        List <Vehicle> avaliableVehicles = new ArrayList<Vehicle>();
        for (Vehicle v : m_Vehicles)
        {
            if (v.GetAvailableEnergyPercentage() > 0)
            {
                avaliableVehicles.add(v);
            }
        }
        return avaliableVehicles;
    }

    public void AddEnergy(String i_LicenseNumber)
    {
        for (Vehicle v : m_Vehicles)
        {
            if (v.GetLicenseNumber().equals(i_LicenseNumber))
            {
                v.AddEnergy();
            }
        }
    }

    public Vehicle AddVehicle(String type, String modelName, eEnergy energy, float[] i_currentWheelsPressure, float i_currentEnergyLevel) {
        Vehicle newVehicle;
        switch (type) {
            case "truck":
                newVehicle = new Truck(modelName, i_currentWheelsPressure, i_currentEnergyLevel);
                m_Vehicles.add(newVehicle);
                break;
            case "car":
                newVehicle = new Car(modelName, energy, i_currentWheelsPressure, i_currentEnergyLevel);
                m_Vehicles.add(newVehicle);
                break;
            case "motorcycle":
                newVehicle = new Motorcycle(modelName, energy, i_currentWheelsPressure, i_currentEnergyLevel);
                m_Vehicles.add(newVehicle);
                break;
            default:
                return null;
        }
        return newVehicle;
    }
}
