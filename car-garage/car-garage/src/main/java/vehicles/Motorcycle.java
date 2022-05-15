package vehicles;
import enums.eEnergy;

public class Motorcycle extends Vehicle
{
    public Motorcycle(String i_ModelName, eEnergy i_EnergySource, float[] i_CurrentWheelsPressure, float i_CurrentEnergyLevel)
    {
        super(i_ModelName, i_EnergySource, 20, 2, i_CurrentWheelsPressure, i_CurrentEnergyLevel);
    }
}
