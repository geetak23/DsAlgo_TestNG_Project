package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver createBrowserInstance(String browserName) {

		WebDriver driver = null;

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}

		return driver;
	}

}
