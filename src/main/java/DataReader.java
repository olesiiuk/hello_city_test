
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataReader {

    private final static Logger logger = LogManager.getLogger(DataReader.class);

    public City readCity() {
        String name = "";
        String timeZone = "";

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            name = reader.readLine();
            timeZone = reader.readLine();

            logger.info("Got city with name= " + name + " and zone= " + timeZone);
        } catch (IOException e) {
            logger.info(e);
        }

        return new City(name, timeZone);
    }


}
