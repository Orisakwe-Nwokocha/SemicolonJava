package airConditioner;

public class AirConditioner {
    private boolean isOn;
    private int temperature = 25;

    public boolean isOn() {
        return isOn;
    }

    public void toggleOn() {
        isOn = true;
    }

    public void toggleOff() {
        isOn = false;
    }

    public int getTemperature() {
        return temperature;
    }

    public void increaseTemperature() {
        if (temperature < 16 || temperature > 30) temperature = temperature;
        if (isOn()) temperature++;
    }

    public void decreaseTemperature() {
        if (isOn()) temperature--;
    }

    public void increaseTemperature(int temperature) {
        if (temperature < 16 || temperature > 30) {}
        else if (isOn()) this.temperature = temperature;
    }
}
