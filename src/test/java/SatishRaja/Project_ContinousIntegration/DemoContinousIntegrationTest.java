package SatishRaja.Project_ContinousIntegration;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoContinousIntegrationTest 
{
	@Test
	public  void Demo1() throws InterruptedException {
		// TOdO Auto-generated Method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		int numberOfAdultPassengers = 5;
		int numberOfChildPassengers = 2;
		int numberOfInfantPassengers = 1;
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@id,'originStation')]//a[@value='HYD']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@id,'destinationStation')]//a[@value='MAA']")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//a[contains(@class,'highlight')]")).click();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);

		for (int i = 1; i < numberOfAdultPassengers; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		for (int i = 1; i <= numberOfChildPassengers; i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}

		for (int i = 1; i <= numberOfInfantPassengers; i++) {
			driver.findElement(By.id("hrefIncInf")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), numberOfAdultPassengers + " Adult, "
				+ numberOfChildPassengers + " Child, " + numberOfInfantPassengers + " Infant");
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("option[value='AED']")).click();
		driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		driver.close();

	}
}
