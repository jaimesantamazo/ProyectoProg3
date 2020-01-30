package test;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.junit.Test;

import ficherosproperties.properties;

public class testproperties {

	@Test
	public void test() {
		String property = null;
		String value = null;;
		properties properties = new properties();
		properties.setPropertyValue(property, value);
	}

}
