package vehicles;
import enums.eEnergy;

public class Truck extends Vehicle
{
    public Truck(String i_ModelName, float[] i_CurrentWheelsPressure, float i_CurrentEnergyLevel)
    {
        super(i_ModelName, eEnergy.Fuel, 50, 16, i_CurrentWheelsPressure, i_CurrentEnergyLevel);
    }
}
