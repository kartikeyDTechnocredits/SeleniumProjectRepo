package seleniumStartPractice;

import base.PreDefiendActions;

public class MakeMyTripHomePage extends PreDefiendActions{
	
	void homePageAccess() {
		start();	
		clickAction("//span[@class='commonModal__close']");
		clickAction("//li[@class='menu_Flights']");
		System.out.println("Cliecked on Flights successfull");
	}
	void quitHomePage() {
		stop();
	}
	
	
	
	public static void main(String[] args) {
		MakeMyTripHomePage mmt= new MakeMyTripHomePage();
		mmt.homePageAccess();
		mmt.quitHomePage();
	}

}
