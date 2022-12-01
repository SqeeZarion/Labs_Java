package org.example.Command;

import org.example.Device.Device;

import java.util.List;

public class TurnOn implements Command {
    private List<Device> deviceList;
    private int deviceNum;

    public TurnOn(List<Device> deviceList, int deviceNum) {
        this.deviceList = deviceList;
        this.deviceNum = deviceNum;
    }

    @Override
    public CommandResult<String> execute() {

        deviceList.get(deviceNum).turnON();

        CommandResult<String> result = new CommandResult<String>("NW!", "TurnON works!", true);
        return result;
    }
}
