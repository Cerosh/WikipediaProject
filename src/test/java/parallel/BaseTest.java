package parallel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
  WebDriver driver;
	protected String langTitleXpathPrt1 = "//a[@id='js-link-box-";
	protected String dynamicXpath;
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
  
  public int getSize(String arg1) {
		int size = driver.findElements(By.xpath(arg1)).size();
		return size;			
	}

	public String getDynamicXpath(String xpathPrt1, int i) {
		dynamicXpath = xpathPrt1 + "[" + i + "]";
		return dynamicXpath;
	}

	public String getLangTitle(WebElement dynamicLngEle) {
		String langCode = dynamicLngEle.getAttribute("lang");
		String langTitleXpath = langTitleXpathPrt1 + langCode + "']";
		return driver.findElement(By.xpath(langTitleXpath)).getAttribute("title");
	}

  @AfterClass
	public void tearDown() {
		driver.quit();
	}

}