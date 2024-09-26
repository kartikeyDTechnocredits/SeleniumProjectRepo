package practiceOfSeleniumFunctions;

import java.io.IOException;

import base.PreDefiendActions;
import utility.ReadPropertyFile;

public class IFramePractice extends PreDefiendActions {
	
	ReadPropertyFile readProp;
	
	void starup(String path) {
		loadPropertyFile(path);
		start("AutomationByKrishna");
	}	
	
	void selectIframes(String path) {
		loadPropertyFile(path);
		waitAndClick("IframeDemoClick");
		selectFrameByElement("SeleniumSiteIframe");
		waitAndClick("SeleniumMenuClick");
		toDefault();
		selectFrameByIndex(2);
		waitAndClick("ApacheLicence");
		toDefault();
		waitAndClick("AutomationByKrishnaLinkOnDemo");
		System.out.println(getElementText("HomePageText"));
	}
	
	void tearDown() {
		stop();
	}
	public static void main(String[] args) {
		IFramePractice iframe= new IFramePractice();
		iframe.starup(".\\resources\\SiteInfo.properties");
		iframe.selectIframes(".\\resources\\AutomationByKrishnaLocators.properties");
		iframe.tearDown();
	}

}
