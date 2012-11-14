/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = { new FirefoxDriver() }

environments {
	
	// run as “mvn -Dgeb.env=chrome test”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}

}