package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;

public class AutomationProject {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://testautomationpractice.blogspot.com/");//open url
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));//wait implicitly
		driver.findElement(By.id("name")).sendKeys("david");//name
		driver.findElement(By.id("email")).sendKeys("ab@gmail.com");//email
		driver.findElement(By.id("phone")).sendKeys("1234567891");//phone
		driver.findElement(By.xpath("//*[@id=\"textarea\"]")).sendKeys("abc 23");//address
		driver.findElement(By.xpath("//*[@id=\"female\"]")).click();//radio button
		Thread.sleep(2000);

		Select Dropdown = new Select(driver.findElement(By.id("country")));
		Dropdown.selectByVisibleText("Canada");//dropdown
		driver.findElement(By.xpath("//input[@value='male']")).click();// radio button
		Thread.sleep(1000);
		//checkbox
		List <WebElement> checkbox =driver.findElements(By.xpath("//*[@class='form-check-input'and @type='checkbox']"));

		for (WebElement i:checkbox)
		{
			i.click();
		}

		Thread.sleep(2000);

		driver.findElement(By.id("datepicker")).sendKeys("12/25/2023"); //date pick              

		Thread.sleep(2000);

		WebElement draggable = driver.findElement(By.id("draggable"));
		Actions dragAndDrop = new Actions(driver);
		dragAndDrop.dragAndDropBy(draggable, 150, 0).build().perform();
		Thread.sleep(2000);
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		Actions sliderAction = new Actions(driver);
		sliderAction.dragAndDropBy(slider, 50, 0).perform();//slider

		WebElement resizable = driver.findElement(By.id("resizable"));
		Actions resize = new Actions(driver);
		resize.clickAndHold(resizable).moveByOffset(50, 50).release().perform();
		//frames and windows
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.id("frame-one796456169")));   
		driver.findElement(By.id("RESULT_TextField-0")).sendKeys("abcd");
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys("12/25/2023");
		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@class='drop_down']")));
		dropdown1.selectByVisibleText("QA Engineer");
		driver.findElement(By.id("FSsubmit")).click();
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		WebElement alertButton = driver.findElement(By.xpath("//button[text()='Alert']"));
		alertButton.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText()); // Print alert text
		alert.accept();//alter box

	}}
