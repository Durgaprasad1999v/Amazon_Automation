package com.SeleniumDemo.seleniumDemo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\durga\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("dress");
        driver.findElement(By.id("nav-search-submit-button")).click();
        driver.findElement(By.linkText("Women's Stylish Georgette Print Long Gown Western Dress with Round Neck 3/4 Sleeve Floral Printed Blue Color Pack Of 1.")).click();
        Set s=driver.getWindowHandles();
        ArrayList arr=new ArrayList(s);
        driver.switchTo().window((String)arr.get(1));
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))).click();
        driver.findElement(By.name("proceedToRetailCheckout")).click();
        TakesScreenshot stc=(TakesScreenshot)driver;
        File src=stc.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src,new File("C:\\Users\\durga\\Desktop\\screeshot\\"+src.getName()+".jpg"));
        
    }
}
