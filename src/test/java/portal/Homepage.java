package portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homepage {
	
	public static void main(String[]args) {
	//WebDriverManager.chromedriver().setup();	
	WebDriver driver =new ChromeDriver();	
	
driver.get("https://dsportalapp.herokuapp.com");
driver.findElement(By.linkText("Get Started")).click();
driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("Sri@06");
 driver.findElement(By.xpath("//input[@id='id_password1']")).sendKeys("Medidi@2010");
 driver.findElement(By.xpath("//input[@id='id_password2']")).sendKeys("Medidi@2010");
 driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
 driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("Sri@06");
 driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Medidi@2010");
 driver.findElement(By.xpath("//input[@value='Login']")).click();
 driver.findElement(By.xpath("//a[@href='data-structures-introduction']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Time Complexity']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Try here>>>']")).click();
	driver.findElement(By.xpath("//*[@id=\"answer_form\"]/div/div/div[6]/div[1]/div/div/div/div[5]/div/pre")).sendKeys("print'Datastracture'");
	
 
 
 
 
	}
	
}


	


