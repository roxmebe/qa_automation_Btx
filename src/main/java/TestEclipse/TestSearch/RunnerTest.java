package TestEclipse.TestSearch;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunnerTest {

		public WebDriver driver;
		@Test
		public void test() throws InterruptedException {
			driver.get("https://www.ebay.com/");
			driver.findElement(By.id("gh-ac")).sendKeys("shoes");
			driver.findElement(By.id("gh-btn")).click();
			waitForPageLoaded();
			driver.findElement(By.id("w3-w0-w2-w2-0[0]")).sendKeys("puma");
			
			//JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			//jsExec.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.className("x-searchable-list__fieldset x-refine__main__value")));
			//jsExec.executeScript("document.getElementsByClassName('x-searchable-list__fieldset x-refine__main__value').scrollTop = 100");
			//driver.findElement(By.id(""))
			driver.findElement(By.xpath("//*[@aria-label='PUMA' and @type='checkbox']")).click();
			waitForPageLoaded();
			//getVisibility(By.xpath("//*[@aria-label='New' and @type='checkbox']"),10);
			clickElementWhenClickable(By.xpath("//*[@aria-label='Nuevo' and @type='checkbox']"),40);
			//driver.findElement(By.xpath("//*[@aria-label='New' and @type='checkbox']")).click();
			waitForPageLoaded();
			System.out.println(driver.findElement(By.xpath("//*[@class='srp-controls__count-heading']")).getText());
			WebElement web_Element_Hovered = driver.findElement(By.xpath("//*[@class='srp-controls__control--legacy']"));
			Actions builder = new Actions(driver);
			builder.moveToElement(web_Element_Hovered).build().perform();
			//driver.findElement(By.xpath("//*[(//li[@class='btn'])[2]]")).click();
					
		}
		
		public void getVisibility(By locator, int timeout) {
		    WebDriverWait wait = new WebDriverWait(driver, timeout);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		    
		    }
		public void clickElementWhenClickable(By locator, int timeout) {
		    WebElement element = null;
		    WebDriverWait wait = new WebDriverWait(driver, timeout);
		    element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		    element.click();
		}
		
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", "C:\\Rox\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		@AfterClass
		public void afterClass() {
			driver.quit();
		}
		
		public void waitForPageLoaded() {
	        ExpectedCondition<Boolean> expectation = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	                    }
	                };
	        try {
	            Thread.sleep(1000);
	            WebDriverWait wait = new WebDriverWait(driver, 30);
	           wait.until(expectation);
	        } catch (Throwable error) {
	            AssertJUnit.fail("Timeout waiting for Page Load Request to complete.");
	        }
	    }
}
