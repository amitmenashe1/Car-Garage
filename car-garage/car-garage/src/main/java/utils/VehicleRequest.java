package utils;

public class VehicleRequest {
  private String type;
  private String energy;
  private String modelName;
  private float currentEnergyLevel;
  private float[] currentWheelsPressure;

  public VehicleRequest(String type, String energy) {
    this.type = type;
    this.energy = energy;
  }

  public String getType() {
    return type;
  }

  public String getEnergy() {
    return energy;
  }

  public String getModelName() {
    return modelName;
  }

  public float getCurrentEnergyLevel() {
    return currentEnergyLevel;
  }

  public float[] getCurrentWheelsPressure() {
    return currentWheelsPressure;
  }
}
