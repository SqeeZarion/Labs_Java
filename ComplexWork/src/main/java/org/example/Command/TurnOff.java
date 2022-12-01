package org.example.Command;


import org.example.Device.Device;

public class TurnOff implements Command {
    private Device device;

    public TurnOff(Device device) {
        this.device = device;
    }

    @Override
    public CommandResult<String> execute() {

        device.turnOff();

        CommandResult<String> result = new CommandResult<String>("NW!", "TurnOff works!", true);
        return result;
    }
}
