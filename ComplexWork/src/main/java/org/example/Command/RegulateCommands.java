package org.example.Command;


import org.example.Device.Device;
import org.example.Device.FillingDeviceList;
import org.example.Device.ModeStatus;
import org.example.Device.ModeStatusDevice;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegulateCommands {
  private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  static Scanner input = new Scanner(System.in);

  public static void certainty(CommandEnum com, List<Device> allDevices) {

    Invoker doer;
    int deviceChoice;
    int continuing = 3;
    int regime;

    switch (com.getCommandCode()) {
      case (0):
        do {
          LOG.info("User choose 0 code");
          System.out.println(allDevices + "\n\n~~Input sequence number of java.device");
          LOG.info("Printed all devices");
          deviceChoice = input.nextInt();
          LOG.info("user choose " + deviceChoice + " command");
          Command turnOff = new TurnOff(allDevices.get(deviceChoice - 1));
          doer = new Invoker(turnOff);
          doer.doSmth();
          LOG.info("turn OFF device " + allDevices.get(deviceChoice - 1));
          System.out.println("\n***Press 1 to continue");
          continuing = input.nextInt();
          LOG.info("user choose " + continuing + " command");

        } while (continuing == 1);

        break;

      case (1):
        do {
          System.out.println(allDevices + "\n\n~~Input sequence number of java.device");
          deviceChoice = input.nextInt();
          LOG.info("user choose " + deviceChoice + " command");
          Command turnOn = new TurnOn(allDevices, deviceChoice - 1);
          doer = new Invoker(turnOn);
          doer.doSmth();
          LOG.info(allDevices.get(deviceChoice - 1) +" is turn ON");
          System.out.println("\n***Press 1 to continue");
          continuing = input.nextInt();
          LOG.info("user choose " + continuing + " command");
        } while (continuing == 1);
        break;
      case (2):

        List<ModeStatusDevice> regimedDevices = FillingDeviceList.returnModeStatusDevices(allDevices);
        System.out.println(regimedDevices + "\n\n~~Choose java.device");
        deviceChoice = input.nextInt();
        LOG.info("user choose " + allDevices.get(deviceChoice - 1) + " device");
        deviceChoice = allDevices.indexOf(regimedDevices.get(deviceChoice -1));
        System.out.println("\n~~Choose regime (0 - eco, 1 - mid, 2 - max)");
        regime = input.nextInt();
        LOG.info("user choose " + regime + " regime");
        Command setRegime = new SetRegime((ModeStatusDevice) allDevices.get(deviceChoice), regime + 1);
        doer = new Invoker(setRegime);
        doer.doSmth();
        LOG.info( allDevices.get(deviceChoice - 1) + " now is working in " + regime + " regime");

        break;

      case (3):
        Command printAll = new PrintAllDevice(allDevices);
        doer = new Invoker(printAll);
        doer.doSmth();
        LOG.info("user choose print all device");
        break;
      case (4):
        Command printOnDevices = new GetDeviceStateON(allDevices);
        doer = new Invoker(printOnDevices);
        doer.doSmth();
        LOG.info("user choose print turned on devices");
        break;
      case (5):
        Command printNeeded = new SearchByParameters(allDevices);
        doer = new Invoker(printNeeded);
        doer.doSmth();
        LOG.info("user choose search by parameters");
        break;
      default:
        System.out.println("\n\n\t\tOops.. Something went wrong");
        LOG.log(Level.WARNING, "user choose another command");
        break;

    }
  }
}
