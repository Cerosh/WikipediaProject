package parallel;

public class HomePage {
	private WikiDriver wikiDrvr;
	private final String URL = "https://www.wikipedia.org/";
	private final String TITLE = "wikipedia";

	public HomePage(WikiDriver wikiDrvr) {
		this.wikiDrvr = wikiDrvr;
	}

	public LangHomePage launchHomePage() {
		wikiDrvr.get(URL);
		String pageTitle = wikiDrvr.getTitle().toLowerCase();
		if (pageTitle.contains(TITLE.toLowerCase()) == false) {
			throw new RuntimeException("Home Page is not displayed!");
		}
		return new LangHomePage(wikiDrvr);
	}

}
