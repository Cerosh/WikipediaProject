package parallel;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class WikiTestScript {
	 private WikiDriver wikiDrvr;
	 
	 @Parameters({"browser"})
	 @BeforeClass
		public void setUp(String browser) {
		 wikiDrvr = new WikiDriver(browser);
		}
 
	@Test(description="Validates the dynamic identification and navigation of Wikipedia pages")
	public void testParameterWithXML()  {
		HomePage homePage = new HomePage(wikiDrvr);
		LangHomePage langHomePage= homePage.launchHomePage();
		langHomePage.launchLangHomePage();
		
	}
	
	@AfterClass
	public void tearDown() {
	  wikiDrvr.quit();
	}
}
