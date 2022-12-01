package org.example.Device;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileDevice extends Device {

    private final static Logger LOG = Logger.getLogger(FileDevice.class.getName());

    public FileDevice(String name, int power) {

        this.name = name;
        this.power = power;

    }

    public static FileDevice[] fillingDevice(String filename) {

        Pattern namePattern = Pattern.compile("(?<=Name:).*?(?=[;\\n])");
        Pattern powerPattern = Pattern.compile("(?<=Power:).*?(?=[;\\n])");


        ArrayList<FileDevice> device = new ArrayList<>();
        FileDevice d;

        try {

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {

                Matcher matcherName = namePattern.matcher(line);
                Matcher matcherPower = powerPattern.matcher(line);

                String name = "";
                while (matcherName.find()) {
                    name = matcherName.group();
                }
                if (Objects.equals(name, ""))
                    throw new Exception("An empty field with a name");

                String consumingPower = "";
                while (matcherPower.find()) {
                    consumingPower = matcherPower.group();
                }

                if (Objects.equals(consumingPower, ""))
                    throw new Exception("An empty field with a Power");

                d = new FileDevice(name, Integer.parseInt(consumingPower));
                device.add(d);
                line = reader.readLine();

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.toString(), e);
        }

        return device.toArray(new FileDevice[0]);

    }
}
