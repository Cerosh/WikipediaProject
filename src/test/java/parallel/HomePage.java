package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {	

	private WebDriver driver; 
	HomePage homePage;
	private final String URL = "https://www.wikipedia.org/";
	private String langXpathPrt1 = "//div[@class='central-featured']/child::div";
	private String langTitleXpathPrt1 = "//a[@id='js-link-box-";
	private String langPgLnkPrt1 = "//*[@id='p-navigation']/child::div/ul/li";
	String exptLangTitle;
	String actlLangTitle;
	private String dynamicLngURL;
	private String dynamicXpath;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage launchHomePage() {
		driver.get(URL);
		if (isOpen() == false) {
			throw new RuntimeException("Home Page is not launched Correctly");
		}
		return homePage;
	}

	private boolean isOpen() {
		return driver.getCurrentUrl().contains(URL);
	}
	
	public void launchLangHomePage()  {
		for (int i = 1; i <= getSize(langXpathPrt1); i++) {
			WebElement dynamicLngEle = driver.findElement(By.xpath(getDynamicXpath(langXpathPrt1,i)));
			exptLangTitle = getLangTitle(dynamicLngEle);
			dynamicLngEle.click();
			actlLangTitle = driver.getTitle();
		//	validateTitle(exptLangTitle,actlLangTitle );
			dynamicLngURL = driver.getCurrentUrl();
			clkLangLink();
			launchHomePage();
		}
	}

	public int getSize(String arg1) {
		return driver.findElements(By.xpath(arg1)).size();	
	}

	public String getDynamicXpath(String xpathPrt1, int i) {
		dynamicXpath = xpathPrt1 + "["+i+"]";
		return dynamicXpath;
	}
	
	public String getLangTitle(WebElement dynamicLngEle) {	
		String langCode = dynamicLngEle.getAttribute("lang");
		String langTitleXpath = langTitleXpathPrt1 + langCode + "']";
		return driver.findElement(By.xpath(langTitleXpath)).getAttribute("title");
		 
	}
	
	private void validateTitle(String exptLangTitle2, String actlLangTitle2) {
		// TODO Auto-generated method stub	
	}
	
	public void clkLangLink() {
		for (int j = 1; j <= getSize(langPgLnkPrt1); j++) {
			driver.findElement(By.xpath(getDynamicXpath(langPgLnkPrt1,j))).click();
			driver.get(dynamicLngURL);
		}
	}	
}
