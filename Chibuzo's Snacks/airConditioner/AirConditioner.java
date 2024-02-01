package airConditioner;

public class AirConditioner {
    private boolean isOn;
    private int temperature = 16;

    public boolean isOn() {
        return isOn;
    }

    public void toggle() {
        isOn = !isOn;
    }

    public int getTemperature() {
        return temperature;
    }

    public void increaseTemperature() {
        boolean temperatureIsWithinRange = temperature >= 16 && temperature < 30;
        if (isOn && temperatureIsWithinRange) temperature++;
    }

    public void decreaseTemperature() {
        boolean temperatureIsWithinRange = temperature > 16 && temperature <= 30;
        if (isOn && temperatureIsWithinRange) temperature--;
    }

}
