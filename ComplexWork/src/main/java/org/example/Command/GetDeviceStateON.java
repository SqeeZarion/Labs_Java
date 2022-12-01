package org.example.Command;

import org.example.Device.Device;
import org.example.Device.FillingDeviceList;

import java.util.List;

public class GetDeviceStateON implements Command{
        private List<Device> devicesList;

        public GetDeviceStateON(List<Device> devices){
            devicesList = FillingDeviceList.returnTurnedOnDevices(devices);
        }

        @Override
        public CommandResult<String> execute(){

            Device.printAll(devicesList);
            CommandResult<String> result = new CommandResult<String>("NW!", "GetDeviceStateON works!", true);
            return result;
        }
}
