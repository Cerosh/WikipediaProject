package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LangHomePage {
	private String langXpathPrt1 = "//div[@class='central-featured']/child::div";
	private String langTitleXpathPrt1 = "//a[@id='js-link-box-";
	private String exptLangTitlePrt1;
	private String actlLangTitlePrt1;
	private WikiDriver wikiDrvr;

	public LangHomePage(WikiDriver wikiDrvr) {
		this.wikiDrvr = wikiDrvr;
	}

	public LangHomePage launchLangHomePage() {
		int size = wikiDrvr.getSize(wikiDrvr,langXpathPrt1);
		for (int i = 8; i <= size; i++) {
			System.out.println("Language Element: " + i);
			WebElement dynamicLngEle = wikiDrvr.findElement(wikiDrvr.getDynamicXpath(wikiDrvr,langXpathPrt1, i));
			exptLangTitlePrt1 = getLangTitle(dynamicLngEle);
			wikiDrvr.click(wikiDrvr, wikiDrvr.dynamicXpathBy);
			validateLangTitle();
			new LangLnkPg(wikiDrvr);
		}
		return this;
	}

	private Boolean validateLangTitle() {
		actlLangTitlePrt1 = wikiDrvr.getTitle();
		String actlLangTitle = actlLangTitlePrt1.replaceAll(",", " —");
		int index = exptLangTitlePrt1.indexOf(" — ");
		String exptLangTitle = exptLangTitlePrt1.substring(index + 3);
		return exptLangTitle.equalsIgnoreCase(actlLangTitle);
	}

	public String getLangTitle(WebElement dynamicLngEle) {
		String langCode = dynamicLngEle.getAttribute("lang");
		String langTitleXpath = langTitleXpathPrt1 + langCode + "']";
		return wikiDrvr.findElement(By.xpath(langTitleXpath)).getAttribute("title");
	}

}
