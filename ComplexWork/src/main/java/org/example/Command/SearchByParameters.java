package org.example.Command;

import org.example.Device.Device;
import org.example.Device.ModeStatus;
import org.example.Device.ModeStatusDevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class SearchByParameters implements Command {

    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    List<Device> allDevices;
    Scanner reader = new Scanner(System.in);

    public SearchByParameters(List<Device> allDevices) {
        this.allDevices = allDevices;
    }

    public List<Device> SearchByParameters() {

        System.out.println("\nType of device (Mode Status)");

        Class deviceClass = Device.class;


        deviceClass = ModeStatus.class;
        LOG.info("Search the device by mode status");


        System.out.println("\nPower is larger than...");
        int[] powerRange = new int[2];
        powerRange[0] = reader.nextInt();


        System.out.println("\n... but lower than...");
        powerRange[1] = reader.nextInt();
        LOG.info("User is searching for device with power more than: " + powerRange[0] + " but less than: " + powerRange[1]);

        System.out.println("\nState (0 - OFF; 1 - ON)");
        int stateCode = reader.nextInt();
        boolean state = stateCode == 1;
        LOG.info("User is searching for" + state + " device");


        int regime;
        if (deviceClass == ModeStatusDevice.class) {
            System.out.println("\nRegime ( 1 - ECO; 2 - Regular; 3 - MAX)");
            regime = reader.nextInt();
        }

        List<Device> neededDevices = new ArrayList<>(allDevices.size());
        for (Device allDevice : allDevices) {
            if (Objects.equals(allDevice.getClass(), deviceClass))
                if (allDevice.getPower() > powerRange[0] && allDevice.getPower() < powerRange[1])
                    if (allDevice.isState() == state) {
                        neededDevices.add(allDevice);
                        continue;
                    }
        }
        return neededDevices;
    }

    @Override
    public CommandResult<String> execute() {
        System.out.println("\nRequired devices are :\n");
        System.out.println(SearchByParameters());
        CommandResult<String> result = new CommandResult<String>("NW!", "SearchByParameters works!", true);
        return result;
    }
}
