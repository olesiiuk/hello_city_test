import org.junit.Test;

import static org.junit.Assert.*;

public class CityMessageTest {
    private City city = new City("Dnipro", "");

    @Test
    public void defineGreetingBeforeSix() {
        String message = city.defineGreeting(4);

        assertEquals("Good night", message);
    }

    @Test
    public void defineGreetingMorning() {
        String message = city.defineGreeting(7);

        assertEquals("Good morning", message);
    }

    @Test
    public void defineGreetingDay() {
        String message = city.defineGreeting(12);

        assertEquals("Good day", message);
    }

    @Test
    public void defineGreetingEvening() {
        String message = city.defineGreeting(20);

        assertEquals("Good evening", message);
    }

    @Test
    public void borderSix() {
        String message = city.defineGreeting(6);

        assertEquals("Good morning", message);
    }

    @Test
    public void borderNine() {
        String message = city.defineGreeting(9);

        assertEquals("Good day", message);
    }

    @Test
    public void borderNineteen() {
        String message = city.defineGreeting(19);

        assertEquals("Good evening", message);
    }

    @Test
    public void borderTwentyThree() {
        String message = city.defineGreeting(23);

        assertEquals("Good night", message);
    }
}