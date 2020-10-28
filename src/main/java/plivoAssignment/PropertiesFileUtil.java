package plivoAssignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileUtil {
	private Properties parseAPITestData() {
		InputStream input = null;
		try {
			input = new FileInputStream("/PlivoAssignment/src/main/resources/test.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public String getAPITestData(String key) {
		Properties prop = parseAPITestData();
		return prop.get(key).toString();
	}
	
}
