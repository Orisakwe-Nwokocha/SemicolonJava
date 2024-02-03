package television;

import java.util.ArrayList;

public class Television {
    private boolean isOn;
    private ArrayList<String> channels;
    private int noOfChannels;
    private int volume;

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
        if (!isOn) return null;

        return "Displaying " + getChannels().get(channelNo - 1);
    }

    public void changeChannel(int currentChannel, boolean increase) {
        if (isOn) {
            if (increase) displayChannel(currentChannel + 1);
            else displayChannel(currentChannel - 1);
        }
    }

    public void increaseVolume() {
        if (isOn) volume++;
    }

    public int getTvVolume() {
        return volume;
    }
}
