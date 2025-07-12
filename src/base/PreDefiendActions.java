package base;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ReadPropertyFile;

public class PreDefiendActions {

	private WebDriver driver;
	private Select oselect;
	private JavascriptExecutor js;
	private ReadPropertyFile readProp;
	private Actions action;
	private	WebDriverWait wait;
	private Alert alert;
	public void start(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		action= new Actions(driver);
		driver.get(getKeyValue(url));
	}

	public void backBrowser() {
		driver.navigate().back();
	}

	public void scrollToTheElement(String path) {
		js.executeScript("arguments[0].scrollIntoView();", getElement(path));
	}

	public void clickByJavaScript(String path) {
		js.executeScript("arguments[0].click();", waitForElement(path));
	}

	public void stop() {
		driver.quit();
	}

	public void selectFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void selectFramByIdName(String value) {
		driver.switchTo().frame(value);
	}

	public void selectFrameByElement(String path) {
		driver.switchTo().frame(waitForElement(getKeyValue(path)));
	}

	public String getElementText(String path) {
		return waitForElement(path).getText();
	}

	public void toDefault() {
		driver.switchTo().defaultContent();
	}

	public void sendText(String path, String text) {
		getElement(path).sendKeys(text);
	}

	public void loadPropertyFile(String path) {
		try {
			readProp = new ReadPropertyFile(path);
		} catch (Exception e) {
			System.out.println("Property file was not loaded properly");
		}
	}

	public String getKeyValue(String key) {
		return readProp.getKeyValue(key);

	}

	private WebElement getElement(String path) {
		return driver.findElement(By.xpath(getKeyValue(path)));
	}

	public void clickAction(String key) {

		getElement(key).click();

	}

	WebElement waitForElement(String path) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getKeyValue(path))));
	}
	
	public Boolean textToBeExtracted(String key, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElement(getElement(key), text));
	}
	
	

	public void waitAndClick(String path) {
		waitForElement(path).click();
	}

	public void waitAndSendText(String path, String text) {
		waitForElement(path).sendKeys(text);
	}

	public void selectionByValue(String path, String value) {
		oselect = new Select(waitForElement(path));
		oselect.selectByValue(value);
	}
	public void selectionByIndex(String path, int  value) {
		oselect = new Select(waitForElement(path));
		oselect.selectByIndex(value);
	}
	
	public void dragAndDropAction(String source, String destination) {
		action.dragAndDrop(waitForElement(source), waitForElement(destination)).build().perform();
	}

	public void alertAccept() {
		alert= driver.switchTo().alert();
		alert.accept();
	}
	
	public void alertDismiss() {
		alert= driver.switchTo().alert();
		alert.dismiss();
	}
	
	public String alertText() {
		alert= driver.switchTo().alert();
		return alert.getText();
	}
	
	

}
