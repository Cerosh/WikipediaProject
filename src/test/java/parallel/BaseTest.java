package parallel;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
  WebDriver driver;
   String URL = "https://www.wikipedia.org/";

  @BeforeClass
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("safari")){
					 driver = new SafariDriver();
				}
		else{
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
  public void launchHomePage() {
		driver.get(URL);
		

	}

  @AfterClass
	public void tearDown() {
		driver.quit();
	}

}