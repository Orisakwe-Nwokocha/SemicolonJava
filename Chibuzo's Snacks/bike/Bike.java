package bike;

public class Bike {
    private boolean isOn;
    private int gear;
    private int speedometer;

    public boolean isOn() {
        return isOn;
    }

    public void toggle() {
        isOn = !isOn;
        if (isOn) gear = 1;
    }

    public int getGear() {
        return gear;
    }

    private void changeGear() {
        if (speedometer >= 0 && speedometer <= 20) gear = 1;
        if (speedometer >= 21 && speedometer <= 30) gear = 2;
        if (speedometer >= 31 && speedometer <= 40) gear = 3;
        if (speedometer >= 41) gear = 4;
    }

    public void accelerate() {
        boolean isGearOne = gear == 1;
        boolean isGearTwo = gear == 2;
        boolean isGearThree = gear == 3;
        boolean isGearFour = gear == 4;

        if (isOn && isGearOne) speedometer++;
        if (isOn && isGearTwo) speedometer += 2;
        if (isOn && isGearThree) speedometer += 3;
        if (isOn && isGearFour) speedometer += 4;

        changeGear();
    }

    public int getCurrentSpeed() {
        return speedometer;
    }
}
