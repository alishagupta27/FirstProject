package com.Apptimize.Project1;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class TestProject1 {
	WebDriver driver;
	
	//Test to open browser
	@Test (priority=1)
	public void openBrowser() {
		Path path = FileSystems.getDefault().getPath("src/test/resources/geckodriver-v0.21.0-macos/geckodriver");
        System.setProperty("webdriver.gecko.driver",path.toString());
		driver=new FirefoxDriver();
	}
	
	//Test to get the URL open
	@Test (priority=2)
	public void fetchURL() {
		driver.get("https://apptimize.com/");
		driver.manage().window().maximize();
	}
	
	//Test to signup
	@Test (priority=3)
	public void signUp() {
		driver.findElement(By.xpath("//*[@id=\"nav-main\"]/ul[2]/li[2]/a")).click();
		driver.findElement(By.id("fname")).sendKeys("Alisha");
		driver.findElement(By.id("lname")).sendKeys("Gupta");
		driver.findElement(By.id("email")).sendKeys("alisha.apptimizetest@gmail.com");
		driver.findElement(By.id("company")).sendKeys("Apptimize Candidate");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("eula")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)");
		driver.findElement(By.id("submit")).click();
	}
	
	//Test to create app
	@Test (priority=4)
	public void createApp() {
		WebDriverWait d=new WebDriverWait(driver,30);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.id("zet-app-name"))).sendKeys("My First App");
		driver.findElement(By.xpath("/html/body/div[3]/ng-view/div/form/div/div/ul[1]/li[2]/span")).click();
		driver.findElement(By.id("zet-create-app")).click();
	}
	
	//Test to signout
	@Test (priority=5)
	public void signOut() throws InterruptedException {
		driver.findElement(By.id("zet-navbar-caretdown")).click();
		Thread.sleep(500);
		driver.findElement(By.id("zet-navbar-signout")).click();
	}
	
	@Test (priority=6)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(500);
		driver.close();
	}

}
