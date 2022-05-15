package vehicles;

import enums.eEnergy;

public class Car extends Vehicle
{
    public Car(String i_ModelName, eEnergy i_EnergySource, float[] i_CurrentWheelsPressure, float i_CurrentEnergyLevel)
    {
        super(i_ModelName, i_EnergySource, 35, 4, i_CurrentWheelsPressure, i_CurrentEnergyLevel);
    }
}
