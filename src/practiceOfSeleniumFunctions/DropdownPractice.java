package practiceOfSeleniumFunctions;

import base.PreDefiendActions;
import utility.ReadPropertyFile;

public class DropdownPractice extends PreDefiendActions {
	
	void startUp(String path) {
		String url="";
		try {
			ReadPropertyFile readprop= new ReadPropertyFile(path);
			 url=readprop.getKeyValue("AutoPracticeDemo");
			 System.out.println(url);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("This is to inform that Property file is not loaded");
		}
		start(url);
		
	}
	
	void dropdownSelection() {
		sendText("//node()[@id='search-input']", "drop");
	clickAction("//node()[text()='Search']");
	//scrollToTheElement("//a[contains(text(),'Dropdown List')]");
	clickByJavaScript("//a[contains(text(),'Dropdown List')]");
	backBrowser();
	clickByJavaScript("//a[contains(text(),'Dropdown List')]");
	selectionByValue("//node()[@id='dropdown']", "1");
	}

	void tearDown() {
		stop();
	}
	
	
	public static void main(String[] args) {
	DropdownPractice ddp= new DropdownPractice();
	ddp.startUp("E:\\2024\\Projects\\2024 Workspace\\SeleniumLast\\resources\\SiteInfo.properties"); //https://practice.expandtesting.com/
	ddp.dropdownSelection();
	ddp.tearDown();
	
	}

}
