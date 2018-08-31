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
	@Test (priority=1)
	public void openBrowser() {
		Path path = FileSystems.getDefault().getPath("src/test/resources/geckodriver/geckodriver.exe");
        System.setProperty("webdriver.gecko.driver",path.toString());
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\z003wkdw\\Downloads\\geckodriver-v0.21.0-win64\\geckodriver.exe");
	    driver=new FirefoxDriver();
	}
	
	@Test (priority=2)
	public void fetchURL() {
		driver.get("https://apptimize.com/");
		driver.manage().window().maximize();
	}
	
	@Test (priority=3)
	public void signUp() {
		driver.findElement(By.xpath("//*[@id=\"nav-main\"]/ul[2]/li[2]/a")).click();
		driver.findElement(By.id("fname")).sendKeys("Golmu");
		driver.findElement(By.id("lname")).sendKeys("Shopping");
		driver.findElement(By.id("email")).sendKeys("golmush.o.pping@gmail.com");
		driver.findElement(By.id("company")).sendKeys("Test");
		driver.findElement(By.id("password")).sendKeys("maulikalisha");
		driver.findElement(By.id("eula")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		driver.findElement(By.id("submit")).click();
	}
	
	@Test (priority=4)
	public void createApp() {
		WebDriverWait d=new WebDriverWait(driver,30);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.id("zet-app-name"))).sendKeys("My First App");
		driver.findElement(By.xpath("/html/body/div[3]/ng-view/div/form/div/div/ul[1]/li[2]/span")).click();
		driver.findElement(By.id("zet-create-app")).click();
	}
	
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
