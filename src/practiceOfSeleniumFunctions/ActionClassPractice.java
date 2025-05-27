package practiceOfSeleniumFunctions;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.*;

import base.PreDefiendActions;

public class ActionClassPractice extends PreDefiendActions{
	
	@BeforeTest
	void startUp()   {		
	loadPropertyFile(".\\resources\\DemoQA.properties");
	start("Site");
	}
	
	@BeforeMethod
	void droppable() {
		waitAndClick("MainMenu");
		clickByJavaScript("Interactions");
		scrollToTheElement("Droppable");
		//clickByJavaScript("Droppable");
		waitAndClick("Droppable");
		
	}
		
	@Test
	void simpleDragAndDrop()	{
		scrollToTheElement("Simple_DragMe");
		dragAndDropAction("Simple_DragMe", "Simple_DropHere");
		System.out.println("KD is Here");
		System.out.println(getElementText("Simple_Dropped"));
		Assert.assertEquals("Dropped!", getElementText("Simple_Dropped"));	
	}
	
	@Test(priority=1)
	void acceptDragAndDrop() {
//		droppable();
		scrollToTheElement("Accept");
		clickAction("Accept");
		dragAndDropAction("Acceptable", "Accept_DropHere");
		Assert.assertEquals("Dropped!", getElementText("Accept_Dropped"));
	}
	
	@AfterTest	
	void taeDown() {
		stop();
	}
	
	
//	public  void actionPractice() {
//		ActionClassPractice ap= new ActionClassPractice();
//		ap.startUp(".\\resources\\DemoQA.properties");
//		ap.acceptDragAndDrop();
//		ap.taeDown();
//	}

}
