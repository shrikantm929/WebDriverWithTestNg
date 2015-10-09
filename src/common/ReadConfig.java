package common;

import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
	
	protected InputStream input = null;
	protected Properties prop = null;

	public ReadConfig(){
		try {
			input = ReadConfig.class.getClassLoader().getResourceAsStream("resources/config.properties");
			prop = new Properties();
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}

	public String getUrl(){
		if(prop.getProperty("url")==null)
			return "";
		return prop.getProperty("url");	
	}
	
	public String getBrowser(){
		if(prop.getProperty("browser")==null)
			return "";
		return prop.getProperty("browser");	
	}
	
	public String getUsername(){
		if(prop.getProperty("username")==null)
			return "";
		return prop.getProperty("username");	
	}
	
	public String getPassword(){
		if(prop.getProperty("password")==null)
			return "";
		return prop.getProperty("password");	
	}
	
	public int getTimeOut(){
		int time =0;
		if(prop.getProperty("waitforTimeout")==null)
			return 0;
		else
			time = Integer.parseInt(prop.getProperty("waitforTimeout"));	
		return time;
	}

	public int getPageTimeOut(){
		int time =0;
		if(prop.getProperty("pageTimeout")==null)
			return 0;
		else
			time = Integer.parseInt(prop.getProperty("pageTimeout"));	
		return time;
	}
	
}

	

