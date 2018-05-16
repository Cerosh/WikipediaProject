package parallel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class stringValidation {
	@Test

	public void validateTitle() {
	String exptLangTitle= "Wikipedia, the free encyclopedia";
	String actlLangTitle =	"English — Wikipedia — The Free Encyclopedia";
	
	System.out.println(actlLangTitle.substring(getIndex(actlLangTitle)+1));	
	}
	public int getIndex(String arg1) {
		int index = arg1.indexOf(",");
		if (index == -1) {
			index = arg1.indexOf("—");
		}
		return index;	
	}

	
}
