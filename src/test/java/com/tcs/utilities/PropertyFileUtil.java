package com.tcs.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {

	static FileInputStream fis;
	static Properties p;
	public static String  getPropertyValue(String key) throws Throwable
	{
		
	   fis= new FileInputStream(System.getProperty("user.dir")+"\\PropertyFiles\\config.properties");
	   p=new Properties();
	   p.load(fis);
	
	   return p.getProperty(key);
		
	}
}
