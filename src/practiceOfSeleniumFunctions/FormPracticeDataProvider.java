package practiceOfSeleniumFunctions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;
import base.PreDefiendActions;

public class FormPracticeDataProvider extends PreDefiendActions {
	
	@BeforeTest
	void startUp()   {		
	loadPropertyFile(".\\resources\\DemoQA.properties");
	start("Site");
	}
	@AfterTest	
	void taeDown() {
		stop();
	}
	
	@BeforeMethod
	void MainMenu() {
		waitAndClick("MainMenu");
		clickByJavaScript("Forms");
		waitAndClick("PracticeForms");
	}
	
	@Test(dataProvider="FormData")
	void formFill(String uname, String lName, String email, String mobNum, String currAdd) {
		waitAndSendText("FormName", uname);
		sendText("FormLastName", lName);
		sendText("FormEmail", email);
		clickByJavaScript("FormGender");
		sendText("FormMobileNumber", mobNum);
		clickAction("FormsDOBCLick");
		System.out.println("DOB CLicked--------");
		selectionByValue("FormDOBMonth", "September");
		clickAction("FormDOBDate");
		scrollToTheElement("FormHobbies");
		clickByJavaScript("FormHobbies");
		sendText("FormCurrntAddress", currAdd);
		sendText("FormStateText", "Har");   // To test Drop Down
		clickAction("//div[@id='state']//div[@class=' css-1hwfws3']/div[1]");
	//	selectionByIndex("FormState", 1);
	//	selectionByIndex("FormCity", 1);
		clickAction("FormSubMitBtn");
		scrollToTheElement("FormClose");
		System.out.println(getElementText("FormDOBText"));
		clickByJavaScript("FormClose");
		
	}
	
	@DataProvider(name="FormData")
	Object[][] formFillData(){
		Object[][] data= new Object[2][5];
		
		data[0][0]="KDDon1";
		data[0][1]="Donn";
		data[0][2]="KDDon@gamil.com";
		data[0][3]="9000000098";
		data[0][4]="India me rahte hai hum";
		
		data[1][0]="KDDon2";
		data[1][1]="Donn";
		data[1][2]="KDDon@gamil.com";
		data[1][3]="9000000098";
		data[1][4]="India me rahte hai hum";
		
		return data;
		
	
	}
	
	
	
}
