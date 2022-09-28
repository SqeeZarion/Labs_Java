import Train.Train;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Train[] loadTrains(String filename) { // зробити перевірки на Null
        Pattern destinationPattern = Pattern.compile("(?<=DESTINATION:).*?(?=[.\\n])");
        Pattern dispatchPattern = Pattern.compile("(?<=DISPATCH:).*?(?=[.\\n])");
        Pattern seatsPattern = Pattern.compile("(?<=SEATS:).*?(?=[.\\n])");

        ArrayList<Train> trains = new ArrayList<>(); //  Train[] x = new Train[100];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String line = reader.readLine();
            while (line != null) {
                Matcher matcherDestination = destinationPattern.matcher(line);
                Matcher matcherDispatch = dispatchPattern.matcher(line);
                Matcher matcherSeats = seatsPattern.matcher(line);

                String destination = "";
                while (matcherDestination.find()) {
                    destination = matcherDestination.group();
                }
                if (Objects.equals(destination, ""))
                    destination = "NULL";

                String dispatch = "";
                while (matcherDispatch.find()) {
                    dispatch = matcherDispatch.group();
                }

                if (Objects.equals(dispatch, ""))
                    dispatch = null;

                String seats = "";
                while (matcherSeats.find()) {
                    seats = matcherSeats.group();
                }
                if (Objects.equals(seats, ""))
                    seats = "0";

                Train t;
                if (dispatch == null || Objects.equals(dispatch, "")) {
                    t = new Train(destination, null, Integer.parseInt(seats));
                } else {
                    t = new Train(destination, LocalDateTime.parse(dispatch), Integer.parseInt(seats));
                }

                trains.add(t);
                line = reader.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trains.toArray(new Train[0]);
    }

    static void searchDestination(Train[] trains) {

        for (Train t : trains) {

            if (!Objects.equals(t.getDestination(), "NULL"))
                System.out.println(t);
        }
    }

    static void searchDispatch(Train[] trains) {
        for (Train t : trains) {
            if (!Objects.equals(t.getDestination(), "NULL")) {
                if (!Objects.equals(t.getDispatch(), null))
                    System.out.println(t);
            }
        }
    }

    static void searchSeats(Train[] trains) {

        for (Train t : trains) {
            if (!Objects.equals(t.getDestination(), "NULL")) {
                if (!Objects.equals(t.getSeats(), 0))
                    System.out.println(t);

            }
        }
    }

    static void searchempty(Train[] trains) {

        for (Train t : trains) {

            if (Objects.equals(t.getDestination(), "NULL"))
                        System.out.println(t);

        }
    }

    public static void main(String[] args) {

        Train[] trains = loadTrains("C:\\Users\\yrape\\OneDrive\\Документи\\Прикладне програмування\\ЛБ-2\\Data_Lr_2.txt");
        for (Train t : trains) {
            System.out.println(t);

        }

        System.out.println("A list of trains heading to a given destination;");
        searchDestination(trains);

        System.out.println("a list of trains that go to a given destination and depart after a given time");
        searchDispatch(trains);

        System.out.println("a list of trains that go to a given destination and have shared seats");
        searchSeats(trains);

        System.out.println("Do not fit the given points");
        searchempty(trains);

        // DESTINATION:Lviv. DISPATCH:2022-12-05T10:30. SEATS:100.
//        Train train = new Train("Lviv", LocalDateTime.of(2022, 12, 5, 10, 30), 1000);
//        System.out.println(train);
    }
}