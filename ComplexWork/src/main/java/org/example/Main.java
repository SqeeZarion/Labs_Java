package org.example;

import org.example.Device.Device;
import org.example.Device.FillingDeviceList;
import org.example.DistributionPanelCommand.DistributionPanel;
import org.example.Logger.LoggerC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);


    public static void mainMenu(){

        ArrayList<Device> allDevices = new ArrayList<>(FillingDeviceList.fillingDevice());
        int choice = 0;
        do{
            DistributionPanel.mainMenuText();
            choice = input.nextInt();
            DistributionPanel.menuManaging(choice, allDevices);

        }while(choice != 5);
    }

    public static void main(String[] args){
        try {
            LoggerC.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        mainMenu();
    }
}