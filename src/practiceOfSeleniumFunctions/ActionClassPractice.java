package practiceOfSeleniumFunctions;

import org.testng.annotations.Test;

import base.PreDefiendActions;

public class ActionClassPractice extends PreDefiendActions{
	
	void startUp(String propertyFileplath)   {
	loadPropertyFile(propertyFileplath);
	start("Site");
	}
	
	
	void droppable() {
	//	loadPropertyFile(propfilePath);
		clickByJavaScript("Interactions");
		scrollToTheElement("Droppable");
		//clickByJavaScript("Droppable");
		waitAndClick("Droppable");
		
	}
		
	void simpleDragAndDrop()	{
		droppable();
		scrollToTheElement("Simple_DragMe");
		dragAndDropAction("Simple_DragMe", "Simple_DropHere");
		System.out.println("KD is Here");
		System.out.println(getElementText("Simple_Dropped"));
		textToBeExtracted("Simple_Dropped","Dropped!" );
		
		
//		if(getElementText("Simple_Dropped").equals("Dropped!"))
//			System.out.println("Simple Darg and Drop Succssfull!!");
//		else
//			System.out.println("We are not able to perform Simple Drag and Drop");		
	}
	
	
	void acceptDragAndDrop() {
		droppable();
		scrollToTheElement("Accept");
		clickAction("Accept");
		dragAndDropAction("Acceptable", "Accept_DropHere");
		textToBeExtracted("Accept_Dropped", "Dropped!");
		
	}
	
	void taeDown() {
		stop();
	}
	
	@Test
	public  void actionPractice() {
		ActionClassPractice ap= new ActionClassPractice();
		ap.startUp(".\\resources\\DemoQA.properties");
		ap.acceptDragAndDrop();
		ap.taeDown();
	}

}
