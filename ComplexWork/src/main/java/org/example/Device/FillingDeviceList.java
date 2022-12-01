package org.example.Device;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class FillingDeviceList {


    private final static Logger LOG = Logger.getLogger(Device.class.getName());

    public static List<Device> fillingDevice() { // коректувати певне доведеться ^(

        ArrayList<Device> devices = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Select a room: (1) - Kitchen, (2) - Room, (3) - bath, (4) - baseDevices ");
            String enterRoom = reader.readLine();

            if (enterRoom.equals("1")) {

                Device[] deviceInfo = FileDevice.fillingDevice("C:\\Users\\yrape\\OneDrive\\Документи\\Прикладне програмування\\Program\\Room1.txt");

                devices.addAll(Arrays.asList(deviceInfo));
            }

            if (enterRoom.equals("2")) {

                Device[] deviceInfo = FileDevice.fillingDevice("C:\\Users\\yrape\\OneDrive\\Документи\\Прикладне програмування\\Program\\Room2.txt");

                devices.addAll(Arrays.asList(deviceInfo));
            }

            if (enterRoom.equals("3")) {

                Device[] deviceInfo = FileDevice.fillingDevice("C:\\Users\\yrape\\OneDrive\\Документи\\Прикладне програмування\\Program\\Room3.txt");

                devices.addAll(Arrays.asList(deviceInfo));
            }

            if (enterRoom.equals("4")) {

                devices.add(new Device("pc", 500));
                devices.add(new Device("freezer", 250));
                devices.add(new Device("tv", 100));
                devices.add(new Device("ps5", 220));
                devices.add(new Device("speakers", 40));
                devices.add(new Device("toaster", 800));
                devices.add(new Device("vacuum cleaner", 700));
                devices.add(new Device("hairdryer", 1500));
                devices.add(new Device("dishwasher", 850));
                devices.add(new Device("iron", 2000));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return devices;
    }

    public static List<Device> returnAllDevices(List<Device> devices){
        ArrayList<Device> electronicDevices = new ArrayList<>();
        for (Device device : devices) {
            if (device.getClass() == Device.class) {
                electronicDevices.add(device);
            }
        }
        LOG.info("returned all Electronic Devices");
        return electronicDevices;
    }

    public static List<ModeStatusDevice> returnModeStatusDevices(List<Device> devices){
        List<ModeStatusDevice> ModeStatusDevices = new ArrayList<>();
        for (Device device : devices) {
            if (device.getClass() == ModeStatusDevice.class) {
                ModeStatusDevices.add((ModeStatusDevice) device);
            }
        }
        LOG.info("returned Mode Status Devices");
        return ModeStatusDevices;
    }

    public static List<Device> returnTurnedOnDevices(List<Device> devices){
        List<Device> onDevices = new ArrayList<>();
        for (Device device : devices) {
            if (device.isState()) {
                onDevices.add(device);
            }
        }
        LOG.info("returned all devices turned on");
        return onDevices;
    }

    public static void addDevice(Device device, List<Device> allDevices){
        allDevices.add(device);
        LOG.info("added new device to the list");
    }
}
