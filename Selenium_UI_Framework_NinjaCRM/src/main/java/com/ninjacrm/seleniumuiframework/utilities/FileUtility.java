package com.ninjacrm.seleniumuiframework.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	// read
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fs = new FileInputStream("./src/main/resources/orangehrms.commondata/commondata.properties");
		Properties prop = new Properties();
		prop.load(fs);
		String value = prop.getProperty(key);
		return value;
	}

	// write
	public void setPropertyKeyValue(String key, String value) throws IOException {
		FileOutputStream fos = new FileOutputStream("./src/main/resources/orangehrms.commondata/commondata.properties");
		Properties prop = new Properties();
		prop.setProperty(key, value);
		prop.store(fos, "Updated common data");
		fos.close();
	}
}
