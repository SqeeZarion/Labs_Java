package org.example.Command;


import org.example.Device.Device;
import org.example.Device.ModeStatusDevice;


public class SetRegime implements Command {

    ModeStatusDevice device;
    int regimeCode;

    public Device getDevice() {
        return device;
    }

    public SetRegime(ModeStatusDevice device, int regimeCode) {
        this.device = device;
        this.regimeCode = regimeCode;
    }

    @Override
    public CommandResult<String> execute() {
        device.setModeStatus(regimeCode);

        CommandResult<String> result = new CommandResult<String>("NW!", "SetRegime works!", true);
        return result;
    }
}