package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LangHomePage extends BaseTest{
	WebDriver driver;
	HomePage homePage;
	LangHomePage langHomePage;

	private String langXpathPrt1 = "//div[@class='central-featured']/child::div";
	private String langTitleXpathPrt1 = "//a[@id='js-link-box-";
	private String langPgLnkPrt1 = "//*[@id='p-navigation']/child::div/ul/li";
	String exptLangTitle;
	String actlLangTitle;
	private String dynamicLngURL;
	private String dynamicXpath;

	public LangHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void launchLangHomePage() {
		for (int i = 1; i <= getSize(langXpathPrt1); i++) {
			WebElement dynamicLngEle = driver.findElement(By.xpath(getDynamicXpath(langXpathPrt1, i)));
		//	exptLangTitle = getLangTitle(dynamicLngEle);
			dynamicLngEle.click();
		//	actlLangTitle = driver.getTitle();
			dynamicLngURL = driver.getCurrentUrl();
			System.out.println("Language URL: "+ dynamicLngURL);
			clkLangLink();	
		}
	}

	public int getSize(String arg1) {
		int size = driver.findElements(By.xpath(arg1)).size();
		System.out.println("Size: "+ size);
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

	public void clkLangLink() {
		for (int j = 1; j <= getSize(langPgLnkPrt1); j++) {
			driver.findElement(By.xpath(getDynamicXpath(langPgLnkPrt1, j))).click();
			driver.get(dynamicLngURL);
		}
		driver.get(URL);
	}

}
