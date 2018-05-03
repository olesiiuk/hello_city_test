
public class Application {

    public static void main(String[] args) {
        DataReader dataReader = new DataReader();

        City city = dataReader.readCity();

        System.out.println(city.getMessage());

    }


}
