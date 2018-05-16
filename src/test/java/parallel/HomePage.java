package parallel;


import org.openqa.selenium.WebDriver;


public class HomePage extends BaseTest{	
	LangHomePage langHomePage;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public LangHomePage launchHomePage() {
		if(!driver.getTitle().equals("Wikipedia")) {
            driver.get(URL);
        }  
		if (isOpen() == false) {
			throw new RuntimeException("Home Page is not launched Correctly");
		}
		return new LangHomePage(driver);
	}

	private boolean isOpen() {
		return driver.getCurrentUrl().contains(URL);
	}		
}
