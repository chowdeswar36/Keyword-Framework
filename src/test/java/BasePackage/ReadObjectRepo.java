package BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadObjectRepo {
	public static Properties getObjectRepo() throws IOException {
		Properties properties = new Properties();
		FileInputStream fin = new FileInputStream("src\\test\\java\\BasePackage\\ObjectRepository.properties");
		properties.load(fin);
		return properties;
	}
}
