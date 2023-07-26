package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(br);
                br.close();
            } catch(IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load properties file: "+filePath);
            }
        } catch(FileNotFoundException f) {
            f.printStackTrace();
            throw new RuntimeException("properties file not found at: "+filePath);
        }

        return properties;
    }

}
