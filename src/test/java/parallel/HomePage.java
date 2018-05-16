package parallel;


import org.openqa.selenium.WebDriver;


public class HomePage {	

	WebDriver driver; 
	HomePage homePage;
	LangHomePage langHomePage;

	String URL = "https://www.wikipedia.org/";
	String exptLangTitle;
	String actlLangTitle;
	
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public LangHomePage launchHomePage() {
		driver.get(URL);
		if (isOpen() == false) {
			throw new RuntimeException("Home Page is not launched Correctly");
		}
		return new LangHomePage(driver);
	}

	private boolean isOpen() {
		return driver.getCurrentUrl().contains(URL);
	}
	
	}
