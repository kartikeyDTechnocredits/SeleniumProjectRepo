package seleniumStartPractice;

import base.PreDefiendActions;

public class MakeMyTripHomePage extends PreDefiendActions{
	
	void homePageAccess() throws InterruptedException {
		start();	
		Thread.sleep(3000);
		clickAction("//span[@class='commonModal__close']");
		clickAction("//li[@class='menu_Flights']");
		System.out.println("Cliecked on Flights successfull");
		clickAction("//div[@class='flt_fsw_inputBox searchCity inactiveWidget ']");
		Thread.sleep(2000);
		clickAction("//input[@placeholder='From']");
		sendText("//input[@placeholder='From']", "Pune"); //
		clickAction("//p[text()='Pune Airport']");
		clickAction("//div[@class='flt_fsw_inputBox searchToCity inactiveWidget ']");
		Thread.sleep(2000);
		clickAction("//input[@placeholder='To']");
		sendText("//input[@placeholder='To']", "Agra");
		Thread.sleep(500);////input[@class='react-autosuggest__input react-autosuggest__input--open']
		clickAction("//p[text()='Agra Airport']");
		Thread.sleep(500);
		clickAction("//div[@aria-label='Fri Aug 23 2024']");
		clickAction("//span[text()='Travellers & Class']");
		Thread.sleep(500);
		clickAction("//li[@data-cy='adults-4']");
		clickAction("//button[text()='APPLY']");
		System.out.println("Source, Destination, Date, Adult selected");
	}
	void quitHomePage() {
		stop();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		MakeMyTripHomePage mmt= new MakeMyTripHomePage();
		mmt.homePageAccess();
		mmt.quitHomePage();
	}

}
