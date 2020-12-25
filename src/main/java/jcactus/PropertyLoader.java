package jcactus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    Properties property = new Properties();

    public String getProperty(String propertyName) {

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(propertyName);
    }
}
