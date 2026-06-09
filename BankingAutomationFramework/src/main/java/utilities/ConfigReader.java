package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties =
            new Properties();

    static {

        try {

            FileInputStream fis =
                    new FileInputStream(
                    "src/test/resources/config/config.properties");

            properties.load(fis);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}