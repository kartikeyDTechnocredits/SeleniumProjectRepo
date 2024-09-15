package practiceOfSeleniumFunctions;

import base.PreDefiendActions;

public class DropdownPractice extends PreDefiendActions {
	
	void startUp(String url) {
		start(url);
	}
	
	void dropdownSelection() {
//	sendText("//node()[@id='search-input']", "drop");
//	clickAction("//node()[text()='Search']");
	waitAndClick("//a[text()='Dropdown List']");
	selectionByValue("//node()[@id='dropdown']", "1");
	}

	void tearDown() {
		stop();
	}
	
	
	public static void main(String[] args) {
	DropdownPractice ddp= new DropdownPractice();
	ddp.startUp("https://practice.expandtesting.com/");
	ddp.dropdownSelection();
	ddp.tearDown();
	}

}
