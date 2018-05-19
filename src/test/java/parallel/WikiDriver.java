package parallel;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikiDriver implements WebDriver {

	private WebDriver driver;
	private String browser;
	public String dynamicXpath;
	By dynamicXpathBy;

	public WikiDriver(String browser) {
		this.browser = browser;
		this.driver = createDriver(browser);
	}

	private WebDriver createDriver(String browser) {
		WebDriver drv;
		switch (browser.toUpperCase()) {
		case "FIREFOX":
			drv = new FirefoxDriver();
			break;
		case "CHROME":
			drv = new ChromeDriver();
			break;
		default:
			throw new IllegalArgumentException("invalid browser name");
		}
		return drv;
	}
	public void click(WebDriver driver, By by) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
			driver.findElement(by).click();
		} catch (StaleElementReferenceException sere) {
			driver.findElement(by).click();
		}
	}
	public int getSize(WebDriver driver, String arg1) {
		List<WebElement> ls = driver.findElements(By.xpath(arg1));
		int size = ls.size();
		System.out.println("Language Size: " + size);
		return size;
	}
	
	public By getDynamicXpath(WebDriver driver, String xpathPrt1, int i) {
		dynamicXpath = xpathPrt1 + "[" + i + "]";
		dynamicXpathBy = By.xpath(dynamicXpath);
		return dynamicXpathBy;
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public WebElement findElement(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}	

	@Override
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	@Override
	public void get(String url) {
		driver.get(url);

	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return null;
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void quit() {
		driver.quit();

	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

}
