package parallel;

import org.testng.annotations.Test;

public class WikiTestScript extends BaseTest{
	 HomePage homePage;
	 LangHomePage langHomePage;

	@Test
	public void testParameterWithXML()  {
		homePage = new HomePage(driver);
		langHomePage= homePage.launchHomePage();
		langHomePage.launchLangHomePage();
	}
	
}
