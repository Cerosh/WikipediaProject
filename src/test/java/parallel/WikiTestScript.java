package parallel;

import org.testng.annotations.Test;

public class WikiTestScript extends BaseTest{
	 HomePage homePage;
	 LangHomePage langHomePage;

	@Test
	public void testParameterWithXML()  {
		HomePage homePage = new HomePage(driver);
		homePage.launchHomePage();
		homePage.launchLangHomePage();
	}
	
}
