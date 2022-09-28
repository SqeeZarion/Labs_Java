package Train;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 10.Train: Пункт призначення, Номер поїзду, Час відправки, Число місць (загальних, купе, плацкарт, люкс).
 * Скласти масив об'єктів. Вивести:
 * a) список поїздів, які прямують до заданого пункту призначення;
 * b) список поїздів, які прямують до заданого пункту призначення та відправляються після заданої години;
 * c) список поїздів, які відправляються до заданого пункту призначення та мають загальні місця.
 */

public class Train {
    public final UUID id = UUID.randomUUID();
    private final String destination;
    private final LocalDateTime dispatch;
    private final int seats;

    public Train(String destination, LocalDateTime dispatch, int seats) {
        this.destination = destination;
        this.dispatch = dispatch;
        this.seats = seats;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDispatch() {
        return dispatch;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", dispatch=" + dispatch +
                ", seats=" + seats +
                '}';
    }
}
