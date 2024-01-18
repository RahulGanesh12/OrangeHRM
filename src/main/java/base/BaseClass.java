package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static String configurations;
	public static String driverName;
	public static WebDriver driver;
	public Properties properties;

	public BaseClass() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Admin\\OneDrive\\Desktop\\JavaConcepts\\JavaCoding\\OrangeHRM\\src\\main\\java\\config\\config.properties");
		properties = new Properties();
		properties.load(file);
	}

	public void initialization() {
		String url = properties.getProperty("URL");
		String BrowserType = properties.getProperty("Browser");
		if (BrowserType.equalsIgnoreCase("Chrome")) {
			configurations = properties.getProperty("ChromeConfigurations");
			driverName = properties.getProperty("ChromeDriver");
			System.setProperty(configurations, driverName);
			driver = new ChromeDriver();
		} else if (BrowserType.equalsIgnoreCase("Edge")) {
			configurations = properties.getProperty("EdgeConfigurations");
			driverName = properties.getProperty("EdgeDriver");
			System.setProperty(configurations, driverName);
			driver = new EdgeDriver();
		} else {
			configurations = properties.getProperty("FireFoxConfigurations");
			driverName = properties.getProperty("GeckoDriver");
			System.setProperty(configurations, driverName);
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	public void driverQuitMethod() {
		driver.quit();
	}
}
