package homeworks.homework06Dop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TV {
    private boolean isOn;
    private List<Channel> channels;
    private int currentChannel;

    public TV() {
        this.isOn = false;
        this.channels = new ArrayList<>();
        this.currentChannel = 0;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println("Телевизор включен.");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("Телевизор выключен.");
    }

    public void switchChannel(int channelNumber) {
        if (!isOn) {
            System.out.println("Телевизор выключен. Включите его, чтобы переключить канал.");
            return;
        }

        for (Channel channel : channels) {
            if (channel.getNumber() == channelNumber) {
                this.currentChannel = channelNumber;
                System.out.println("Переключено на канал: " + channel.getName());
                return;
            }
        }

        System.out.println("Канал с номером " + channelNumber + " не найден.");
    }

    public void addChannel(Channel channel) {
        this.channels.add(channel);
    }

    @Override
    public String toString() {
        return "Телевизор: " + (isOn ? "Включен" : "Выключен") + ", Текущий канал: " + currentChannel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return isOn == tv.isOn && currentChannel == tv.currentChannel && Objects.equals(channels, tv.channels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOn, channels, currentChannel);
    }
}
