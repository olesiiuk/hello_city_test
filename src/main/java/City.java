import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;
import java.util.Set;

public class City {
    private static final Logger logger = LogManager.getLogger(City.class);

    private String name;
    private String timeZone;
    private Instant nowTime;

    public City(String name, String timeZone) {
        this.name = name;
        this.timeZone = timeZone;
        nowTime = Instant.now();
    }

    //TODO rename function
    public ZonedDateTime getDateTimeByZone() {
        Set<String> zones = ZoneId.getAvailableZoneIds();
        ZonedDateTime zonedDateTime;

        if (zones.contains(timeZone)) {
            zonedDateTime = ZonedDateTime.now(ZoneId.of(timeZone));
        } else {
            ZoneId zoneId = identifyZoneId();
            zonedDateTime = nowTime.atZone(zoneId);
        }

        return zonedDateTime;
    }

    private ZoneId identifyZoneId() {
        String zoneName = getZoneNameIfAvailable();
        ZoneId zoneId;

        if (zoneName.equals("")) {
            zoneId = ZoneId.of("GMT");
        } else {
            zoneId = ZoneId.of(zoneName);
        }

        return zoneId;
    }

    private String getZoneNameIfAvailable() {
        String cityZoneName = changeCityNameToZoneFormat(name).toLowerCase();
        String zoneName = "";

        for (String existedZone : ZoneId.getAvailableZoneIds()) {
            if (existedZone.toLowerCase().endsWith(cityZoneName)) {
                zoneName = existedZone;
            }
        }
        return zoneName;
    }

    private String changeCityNameToZoneFormat(String name) {
        String trimmedName = name.trim();

        return trimmedName.replace(" ", "_");
    }

    public String getMessage() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

        String dayTime = defineGreeting(getDateTimeByZone().getHour());
        String message = resourceBundle.getString(dayTime) + " " + name;

        logger.info("Message provided: " + message);

        return message;
    }

    protected String defineGreeting(int hour) {
        String greeting = "";

        if (hour < 6) {
            greeting = "night";
        } else if (hour >= 6 && hour < 9) {
            greeting = "morning";
        } else if (hour >= 9 && hour < 19) {
            greeting = "day";
        } else if (hour >= 19 && hour < 23) {
            greeting = "evening";
        } else if (hour >= 23) {
            greeting = "night";
        }
        return greeting;
    }

}
