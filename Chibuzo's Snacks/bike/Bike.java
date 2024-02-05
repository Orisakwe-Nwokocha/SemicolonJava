package bike;

public class Bike {
    private boolean isOn;
    private int gear;
    private int speed;
    private boolean isCruiseControl;

    public boolean isOn() {
        return isOn;
    }

    public void toggle() {
        isOn = !isOn;
        if (isOn) gear = 1;
    }

    public int getCurrentGear() {
        return gear;
    }

    private void changeGear() {
        if (speed >= 0 && speed <= 20) gear = 1;
        if (speed >= 21 && speed <= 30) gear = 2;
        if (speed >= 31 && speed <= 40) gear = 3;
        if (speed >= 41) gear = 4;
    }

    public void accelerate() {
        boolean isGearOne = gear == 1;
        boolean isGearTwo = gear == 2;
        boolean isGearThree = gear == 3;
        boolean isGearFour = gear == 4;

        if (isOn && !isCruiseControl) {
            if (isGearOne) speed++;
            else if (isGearTwo) speed += 2;
            else if (isGearThree) speed += 3;
            else if (isGearFour) {
                speed += 4;
                if (speed >= 155) speed = 155;
            }
        }

        changeGear();
    }

    public int getCurrentSpeed() {
        return speed;
    }

    public void decelerate() {
        boolean isGearFour = gear == 4;
        boolean isGearThree = gear == 3;
        boolean isGearTwo = gear == 2;
        boolean isGearOne = gear == 1;

        if (isOn) {
            if (isCruiseControl) isCruiseControl = false;

            if (isGearFour) speed -= 4;
            else if (isGearThree) speed -= 3;
            else if (isGearTwo) speed -= 2;
            else if (isGearOne) {
                speed--;
                if (speed <= 0) speed = 0;
            }
        }

        changeGear();
    }

    public boolean isCruiseControl() {
        return isCruiseControl;
    }

    public void activateCruiseControl() {
        if (isOn) isCruiseControl = !isCruiseControl;
        if (speed < 37) isCruiseControl = false;
    }
}
