package tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static org.testng.FileAssert.fail;

public class OrangehrmLoginTest extends BaseClass {
    @Test
    public void loginTest() throws InterruptedException {
        ExtentTest test1 = extent.createTest("Test One", "Sample test case for demo");

        test1.log(Status.INFO, "Test One started");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        test1.log(Status.PASS, "Navigate to https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='LOGIN Panel'])[1]/following::span[1]")).click();
        test1.log(Status.PASS, "Go to Orange Hrm Login Page");
        driver.findElement(By.id("txtUsername")).clear();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        test1.log(Status.PASS, "Enter The UserName");
        driver.findElement(By.id("txtPassword")).click();
        test1.log(Status.PASS, "Click Username");
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        test1.log(Status.PASS, "Enter Pass");

        driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
        test1.log(Status.PASS, " Click Enter ");



        //driver.findElement(By.id("btnLogin")).click();


        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();

    }


}

