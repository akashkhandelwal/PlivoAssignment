package plivoAssignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class CommonActions {
	static HashMap<String, String> testInputData = new HashMap<String, String>();
	private static Properties parseAPITestData() {
		InputStream input = null;
		try {
			String root = System.getProperty("user.dir");
			input = new FileInputStream(root+"/src/main/resources/test.properties");
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
	
	public static HashMap<String, String> getAPITestData() {
		Properties prop = parseAPITestData();
		for (String key : parseAPITestData().stringPropertyNames()) {
			testInputData.put(key, prop.getProperty(key));
		}
		return  testInputData;
	}
}
