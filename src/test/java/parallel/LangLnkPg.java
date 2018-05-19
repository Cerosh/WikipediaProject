package parallel;



public class LangLnkPg {
	WikiDriver wikiDrvr;
	protected String langPgLnkPrt1 = "//*[@id='p-navigation']/child::div/ul/li";
	protected String dynamicLngURL;
	protected String langTitleXpathPrt1 = "//a[@id='js-link-box-";
	
	String URL = "https://www.wikipedia.org/";
	
	public LangLnkPg(WikiDriver wikiDrvr) {
		this.wikiDrvr = wikiDrvr;
		clkLangLink();
	}
	
	
	
	public LangHomePage clkLangLink() {
		int size = wikiDrvr.getSize(wikiDrvr, langPgLnkPrt1);
		for (int j = 4; j <= size; j++) {
			System.out.println("Link Size:"+j);
			dynamicLngURL = wikiDrvr.getCurrentUrl();
			System.out.println("Lang URL: "+dynamicLngURL);
			wikiDrvr.findElement(wikiDrvr.getDynamicXpath(wikiDrvr,langPgLnkPrt1, j));
			wikiDrvr.click(wikiDrvr, wikiDrvr.dynamicXpathBy);
			
			wikiDrvr.get(dynamicLngURL);
		}
		wikiDrvr.get(URL);
		return new LangHomePage(wikiDrvr);
	}
	
}
