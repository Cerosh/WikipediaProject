package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LangHomePage extends BaseTest{
	LangHomePage langHomePage;
	protected String langXpathPrt1 = "//div[@class='central-featured']/child::div";
	String exptLangTitle;
	String actlLangTitle;

	public LangHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public LangHomePage launchLangHomePage() {
		for (int i = 1; i <= getSize(langXpathPrt1); i++) {
			System.out.println("Lang Size: "+i);
			WebElement dynamicLngEle = driver.findElement(By.xpath(getDynamicXpath(langXpathPrt1, i)));
		//	exptLangTitle = getLangTitle(dynamicLngEle);
			dynamicLngEle.click();
		//	actlLangTitle = driver.getTitle();
			new LangLnkPg(driver);
		}
		return langHomePage;
	}

	public String getLangTitle(WebElement dynamicLngEle) {
		String langCode = dynamicLngEle.getAttribute("lang");
		String langTitleXpath = langTitleXpathPrt1 + langCode + "']";
		return driver.findElement(By.xpath(langTitleXpath)).getAttribute("title");
	}

	

}
