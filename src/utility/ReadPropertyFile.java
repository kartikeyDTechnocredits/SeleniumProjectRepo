package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	private Properties prop;

	public ReadPropertyFile(String path) throws IOException {
		File file = new File(path);
		FileInputStream inputStrm = new FileInputStream(file);
		prop = new Properties();
		prop.load(inputStrm);
	}

	 public String getKeyValue(String key) {
		return prop.getProperty(key);
	}

}
