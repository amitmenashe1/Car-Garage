package vehicles;

public class Wheels
{
    float m_MaxAirPressure;
    float m_CurrentAirPressure;

    public Wheels(float i_MaxAirPressure, float i_CurrentAirPressure)
    {
        this.m_MaxAirPressure = i_MaxAirPressure;
        this.m_CurrentAirPressure = i_CurrentAirPressure;
    }

    // Inflates vehicle tires
    public void InflateTire(float i_AirPressureToAdd)
    {
        if (i_AirPressureToAdd < 0 || i_AirPressureToAdd > (m_MaxAirPressure - m_CurrentAirPressure))
        {
            System.out.println("Invalid value. Should be between 0 and" + (m_MaxAirPressure - m_CurrentAirPressure));
        }
        m_CurrentAirPressure += i_AirPressureToAdd;
    }

    @Override
    public String toString() {
        return "{ " + "\"maxAirPressure\": " + m_MaxAirPressure + ", \"currentAirPressure\": " + m_CurrentAirPressure + " }";
    }
}
