
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

@Test
public class systemproperty {

	String c;

	public String getdetails(String param) throws FileNotFoundException, IOException {

		Properties sysProperty = new Properties();
		sysProperty.load(new FileInputStream(new File("./configs/SystemConfig.properties")));
		return c = sysProperty.getProperty(param);

	};

};