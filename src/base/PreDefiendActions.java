package base;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PreDefiendActions {
	
	private WebDriver driver;	
	private Select oselect;
	public void start(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		
		driver.get(url);
		}
	
	public void stop() {
		driver.quit();
	}
	
	 public void sendText(String path, String text) {
		getElement(path).sendKeys(text);
	}
	
	private WebElement getElement(String path) {
		 return driver.findElement(By.xpath(path));
	}
	
	public void clickAction(String path) {
		getElement(path).click();
		
	}
	
	WebElement waitForElement(String path) {		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	return	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
	}
	
	public void waitAndClick(String path) {
		waitForElement(path).click();
	}
	
	 public void waitAndSendText(String path, String text) {
		waitForElement(path).sendKeys(text);
	}
	 public void selectionByValue(String path, String value) {
		 oselect= new Select(waitForElement(path));
		 oselect.selectByValue(value);
	 }
	

}
