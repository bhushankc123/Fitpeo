package Fitpeopackage;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fitpeoclass {

	public static WebDriver driver;


	/*	TC1 Navigate to the FitPeo Homepage:
		Open the web browser and navigate to FitPeo Homepage.*/

	@BeforeTest
	//@Test (priority=1)
	public void start() throws Throwable {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.fitpeo.com/");
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[@class='satoshi MuiBox-root css-r3xbt7']")).click();
		driver.findElement(By.xpath("//a[.='Revenue Calculator']")).click();
	}

	//TC2		Navigate to the Revenue Calculator Page:
	//From the homepage, navigate to the Revenue Calculator Page. 

	@Test (priority=2)
	public void TC2() throws Throwable {
		driver.findElement(By.xpath("//a[.='Revenue Calculator']")).click();
		//	driver.findElement(By.xpath("//div[@class='satoshi MuiBox-root css-r3xbt7']")).click();

		Thread.sleep(2000);
	}


	//TC3
	//Scroll Down to the Slider section:
	//Scroll down the page until the revenue calculator slider is visible.
	@Test (priority=3)
	public void TC3() throws Throwable {
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
	}

	/*	TC4 
		Adjust the Slider:
		Adjust the slider to set its value to 820. we’ve highlighted the slider in red color,
		Once the slider is moved the bottom text field value should be updated to 820*/
	@Test (priority=4)
	public void TC4() throws Throwable {
		WebElement low= driver.findElement(By.xpath("//span[@data-index='0']"));
		int xwidth=low.getSize().width;
		Actions act= new Actions(driver);
		Thread.sleep(1000);
		act.dragAndDropBy(low,(int) (xwidth*4.7) , 0).perform();
		Thread.sleep(1000);
	}

	//TC5 Update the Text Field:
	//Click on the text field associated with the slider.
	//	Enter the value 560 in the text field. Now the slider also should change accordingly 
	@Test (priority=5)
	public void TC5() throws Throwable {
		driver.findElement(By.xpath("//*[@type='number']")).clear();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@type='number']")).sendKeys("560");
		Thread.sleep(2000);
	}


	//TC6 Validate Slider Value:
	//Ensure that when the value 560 is entered in the text field, the slider's position is updated to reflect the value 560.

	@Test (priority=6)
	public void TC6() throws Throwable {

		WebElement res1=driver.findElement(By.xpath("(//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh'])[1]"));
		Assert.assertTrue(res1.isDisplayed());

	}


	//TC7 Select CPT Codes:
	//Scroll down further and select the checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474.

	@Test (priority=7)
	public void TC7() throws Throwable {

		JavascriptExecutor js= (JavascriptExecutor)driver;
		for (int i=0;i<3; i++)
			js.executeScript("window.scrollBy(0, 200)");

		List <WebElement>fields =driver.findElements(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']"));
		fields.get(0).click();
		Thread.sleep(1000);
		fields.get(1).click();
		Thread.sleep(1000);
		fields.get(2).click();
		Thread.sleep(1000);
		fields.get(7).click();
		Thread.sleep(1000);
	}

	//TC 8 Validate Total Recurring Reimbursement:

	@Test (priority=8)
	public void TC8() throws Throwable {		

		WebElement res2=driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'][normalize-space()='$27000'])[1]"));
		Assert.assertTrue(res2.isDisplayed());	

	}


	//TC 9 Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month: shows the value $110700.

	@Test (priority=9)
	public void TC9() throws Throwable {

		List <WebElement>checkbox =driver.findElements(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']"));
		System.out.println("Total no. of checkbox:"+ checkbox.size());
		for (WebElement chbox:checkbox)
		{
			chbox.click();
		}


		WebElement res=driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'][normalize-space()='$110700']"));
		Assert.assertTrue(res.isDisplayed());
	}


	@AfterTest
	public void stop() {

		driver.quit();
	}
}