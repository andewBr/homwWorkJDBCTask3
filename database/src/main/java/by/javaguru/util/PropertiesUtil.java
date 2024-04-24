package by.javaguru.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties PROPERTIES = new Properties();

    static {
        loadProperty();
    }

    public static void loadProperty(){
        try (var inputStream = PropertiesUtil.class.getClassLoader().
                getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    public PropertiesUtil() {
    }
}
