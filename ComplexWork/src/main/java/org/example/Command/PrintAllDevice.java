package org.example.Command;


import org.example.Device.Device;

import java.util.List;

public class PrintAllDevice implements Command {

    private final List<Device> devices;

    public PrintAllDevice(List<Device> devices){
        this.devices = devices;
    }

    @Override
    public CommandResult<String> execute(){

        Device.printAll(devices);

        CommandResult<String> result = new CommandResult<String>("NW!", "PrintAllDevice works!", true);
        return result;
    }
}
