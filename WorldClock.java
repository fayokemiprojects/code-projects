import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

class City {
    private String name;
    private ZoneId zoneId;

    public City(String name, String zoneId) {
        this.name = name;
        this.zoneId = ZoneId.of(zoneId);
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        ZonedDateTime currentTime = ZonedDateTime.now(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
        return currentTime.format(formatter);
    }
}

public class WorldClock {
    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
            new City("New York", "America/New_York"),
            new City("London", "Europe/London"),
            new City("Tokyo", "Asia/Tokyo"),
            new City("Sydney", "Australia/Sydney"),
            new City("Dubai", "Asia/Dubai"),
            new City("Los Angeles", "America/Los_Angeles"),
            new City("Mumbai", "Asia/Kolkata")
        );

        System.out.println("World Clock:");
        System.out.println("---------------------------");

        for (City city : cities) {
            System.out.printf("%-15s: %s%n", city.getName(), city.getTime());
        }

        System.out.println("---------------------------");
    }
}
