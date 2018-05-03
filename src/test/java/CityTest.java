import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class CityTest {


    @Test
    public void cityWithoutDefinedTimeZone() {
        City city = new City("Dnipro", "");

        ZonedDateTime expected = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime actual = city.getDateTimeByZone();

        assertEquals(expected.withNano(0), actual.withNano(0));
    }

    @Test
    public void cityWithDefinedTimeZoneByCityName() {
        City city = new City("new york", "");

        ZonedDateTime expected = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime actual = city.getDateTimeByZone();

        assertEquals(expected.withNano(0), actual.withNano(0));
    }

    @Test
    public void testNewYorkWithTimeZone() {
        City city = new City("New York", "America/New_York");

        ZonedDateTime expected = ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime actual = city.getDateTimeByZone();

        assertEquals(expected.withNano(0), actual.withNano(0));
    }



}