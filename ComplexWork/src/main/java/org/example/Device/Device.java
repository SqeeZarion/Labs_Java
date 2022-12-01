package org.example.Device;

import java.util.List;
import java.util.logging.Logger;

public class Device {

    private final static Logger LOG = Logger.getLogger(Device.class.getName());

    protected String name;
    protected int power;
    protected boolean state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    Device() {
        name = "empty";
        power = 0;
        state = false;
    }

    public Device(String name, int power) {
        this.name = name;
        this.power = power;
        state = false;
    }

    public void turnON() {
        if (state) {
            System.out.println("Device(" + name + ") is already ON");
            LOG.info("device is already ON");
            return;
        }
        System.out.println("Device(" + name + ") is ON");
        LOG.info("device is turned ON");
        this.state = true;
    }

    public void turnOff() {
        if (!state) {
            System.out.println("Device(" + name + ") is already OFF");
            LOG.info("device is already OFF");
            return;
        }
        System.out.println("Device(" + name + ") is OFF");
        LOG.info("device is turned OFF");
        this.state = false;
    }

    public static void printAll(List<Device> deviceArrayList) {
        int sumPower = 0;
        for (Device electronicDevice : deviceArrayList) {
            System.out.println(electronicDevice.toString());
            sumPower += electronicDevice.getPower();
            LOG.info("printed all devices and found general power");
        }
        System.out.println("\n\nGeneral power is --- " + sumPower + "\n");
    }

    @Override
    public String toString() {
        return "\nName='" + name + '\'' +
                ", power=" + power +
                ", state=" + state;
    }
}
