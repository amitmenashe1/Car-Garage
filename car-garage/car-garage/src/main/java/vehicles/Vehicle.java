package vehicles;

import java.util.ArrayList;
import java.util.List;
import enums.eEnergy;

public class Vehicle extends Object {
    List<Wheels> m_Wheels;
    String m_ModelName;
    String m_LicenseNumber;
    float m_AvailableEnergyPercentage;
    float m_MaximumTirePressure;
    int m_WheelsNumber;
    eEnergy m_eEnergy;

    public Vehicle(String i_ModelName, eEnergy i_EnergySource, float i_MaximumTirePressure, int i_WheelsNumber, float[] i_CurrentWheelsPressure, float i_CurrentEnergyLevel) {
        this.m_Wheels = new ArrayList<Wheels>();
        this.m_ModelName = i_ModelName;
        this.m_LicenseNumber = GenerateLicenseNumber();
        this.m_eEnergy = i_EnergySource;
        this.m_MaximumTirePressure = i_MaximumTirePressure;
        this.m_AvailableEnergyPercentage = i_CurrentEnergyLevel;
        this.m_WheelsNumber = i_WheelsNumber;
        for (int i = 0; i < this.m_WheelsNumber; i++) {
            this.AddWheel(i_CurrentWheelsPressure[i]);
        }
    }

    public String GenerateLicenseNumber() {
        String licenseNumber = "";
        for (int i = 0; i < 4; i++) {
            licenseNumber += (char) (Math.random() * 26 + 65);
        }
        for (int i = 0; i < 4; i++) {
            licenseNumber += (char) (Math.random() * 10 + 48);
        }
        return licenseNumber;
    }

    public String GetLicenseNumber() {
        return this.m_LicenseNumber;
    }

    public List<Wheels> GetWheels() {
        return this.m_Wheels;
    }

    public float GetAvailableEnergyPercentage() {
        return m_AvailableEnergyPercentage;
    }

    public void setAvailableEnergyPercentage(float i_AvailableEnergyPercentage) {
        this.m_AvailableEnergyPercentage = i_AvailableEnergyPercentage;
    }

    public void AddEnergy() {
        this.setAvailableEnergyPercentage(100);
    }

    public void AddWheel(float i_CurrentAirPressure) {
        this.m_Wheels.add(new Wheels(this.m_MaximumTirePressure, i_CurrentAirPressure));
    }

    @Override
    public String toString() {
        String wheels = "[ ";
        for (Wheels wheel : this.m_Wheels) {
            wheels += wheel.toString() + ", ";
        }
        wheels += " ]";
        return "{ " + "\"wheels\": " + wheels + ", \"modelName\": \"" + this.m_ModelName + '"'
                + ", \"licenseNumber\": \"" + this.m_LicenseNumber + '"' + ", \"availableEnergyPercentage\": "
                + this.m_AvailableEnergyPercentage + ", \"energy\": \"" + this.m_eEnergy.toString() + '"' + " }";
    }

}
