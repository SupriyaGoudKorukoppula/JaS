//Test Objective:-This script shows the execution of modification of change password sub module in the personal page
//with invalid details.


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class changingPassword_invalidPassword {
	WebDriver driver;
  @Test
  public void invalidPassword() {
	  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@value='1']")).click();
	  driver.findElement(By.xpath("//input[@value='2']")).click();
	  driver.findElement(By.xpath("//input[@value='3']")).click();
	  driver.findElement(By.xpath("//input[@value='4']")).click();
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  driver.findElement(By.xpath("//span[text()='Personal']")).click();
	  
	 driver.findElement(By.xpath("//span[text()='Change Password']")).click();
	  driver.findElement(By.name("oldPassword")).sendKeys("1234");
	  driver.findElement(By.name("newPassword")).sendKeys("1305supriya");
	  driver.findElement(By.name("newPasswordConfirmation")).sendKeys("135supriya");
	  driver.findElement(By.className("button")).click();
	  Alert alert = driver.switchTo().alert();
	String expresult = "Passwords are not Equal";
	String actresult = alert.getText();
	
	Assert.assertTrue(actresult.contains(expresult));
	
System.out.println(actresult);
  }


  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://localhost:8585/do/login");
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
