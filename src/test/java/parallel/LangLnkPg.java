package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LangLnkPg extends BaseTest{
	protected String langPgLnkPrt1 = "//*[@id='p-navigation']/child::div/ul/li";
	protected String dynamicLngURL;
	
	public LangLnkPg(WebDriver driver) {
		this.driver = driver;
		clkLangLink();
	}
	
	public LangHomePage clkLangLink() {
		for (int j = 1; j <= getSize(langPgLnkPrt1); j++) {
			System.out.println("Link Size:"+j);
			dynamicLngURL = driver.getCurrentUrl();
			System.out.println("Lang URL: "+dynamicLngURL);
			driver.findElement(By.xpath(getDynamicXpath(langPgLnkPrt1, j))).click();
			driver.get(dynamicLngURL);
		}
		driver.get(URL);
		return new LangHomePage(driver);
	}
	
}
