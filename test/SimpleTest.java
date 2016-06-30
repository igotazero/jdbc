import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Andrei_Zanozin on 6/29/2016.
 */
public class SimpleTest {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        String log4jConfPath = "src/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }
}
