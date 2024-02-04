package television;

import java.util.ArrayList;

public class Television {
    private boolean isOn;
    private ArrayList<String> channels;
    private int noOfChannels;
    private int volume;
    private int currentChannel;

    public Television() {
        channels = new ArrayList<>();
    }

    public boolean isOn() {
        return isOn;
    }

    public void toggle() {
        isOn = !isOn;
        volume = 25;
    }

    public void addChannel() {
        if (isOn) {
            noOfChannels++;
            channels.add("Channel " + noOfChannels);
        }
    }

    public ArrayList<String> getChannels() {
        if (isOn) return channels;
        else return null;
    }

    public String displayChannel(int channelNo) {
        boolean condition = channelNo <= 0 || channelNo > noOfChannels;

        if (!isOn) return null;
        else if (condition) throw new IllegalArgumentException("Channel number is not valid");

        currentChannel = channelNo;

        return "Displaying " + getChannels().get(channelNo - 1);
    }

    public String displayChannel() {
        if (!isOn) return null;

        return "Displaying " + getChannels().get(currentChannel - 1);
    }

    public void changeChannel(boolean increase) {
        boolean condition =  currentChannel >= 1 && currentChannel < noOfChannels;

        if (isOn && condition) {
            if (increase) currentChannel++;
            else {
                currentChannel--;
                if (currentChannel < 1) currentChannel = 1;
            }
        }
    }

    public void increaseVolume() {
        boolean volumeIsWithinRange = volume >= 0 && volume < 100;
        if (isOn && volumeIsWithinRange) volume++;
    }

    public int getTvVolume() {
        return volume;
    }

    public void decreaseVolume() {
        boolean volumeIsWithinRange = volume > 0 && volume <= 100;
        if (isOn && volumeIsWithinRange) volume--;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }
}
