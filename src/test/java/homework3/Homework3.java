package homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework3 {
    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeMethod
    public void setup()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();



    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Registration Form")).click();
        driver.manage().window().maximize();


        driver.findElement(By.name("birthday")).sendKeys("55555555555");
        String expectedWarningMsg="The date of birth is not valid";
        WebElement actualWarningMsg = driver.findElement(By.xpath("//small[@class='help-block' and contains(text(),'The date of birth is not valid')]"));
        Assert.assertEquals(expectedWarningMsg,actualWarningMsg.getText());
        System.out.println(expectedWarningMsg);
        System.out.println(actualWarningMsg.getText());

    }
    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com");
       BrowserUtils.pause(3);
        driver.findElement(By.linkText("Registration Form")).click();
        driver.manage().window().maximize();
        String cActual ="C++";
        String jActual="Java";
        String jsActual ="JavaScript";
        WebElement cPlusPlus = driver.findElement(By.xpath("//*[contains(text(),'C++')]"));
        WebElement java = driver.findElement(By.xpath("//*[@id='inlineCheckbox2']//following-sibling::label"));
        WebElement javaScript = driver.findElement(By.xpath("//input[@id='inlineCheckbox3']//following-sibling::label" ));
        Assert.assertEquals(cPlusPlus.getText(),cActual);
        Assert.assertEquals(jsActual,javaScript.getText());
        Assert.assertEquals(jsActual,javaScript.getText());
    }
    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com");
        BrowserUtils.pause(3);
        driver.findElement(By.linkText("Registration Form")).click();
        driver.manage().window().maximize();
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("f", Keys.ENTER);
        String expectedWarning = "first name must be more than 2 and less than 64 characters long";
        WebElement actualWarning = driver.findElement(By.xpath("//small[@class='help-block' and contains(text(),'first name must be more than 2 and less than 64 characters long')]"));
        Assert.assertEquals(expectedWarning,actualWarning.getText());


    }

    @Test
    public void test4(){
        driver.get("http://practice.cybertekschool.com");
        BrowserUtils.pause(3);
        driver.findElement(By.linkText("Registration Form")).click();
        driver.manage().window().maximize();
        driver.findElement(By.name("lastname")).sendKeys("3",Keys.ENTER);
        String actualWarning = "The last name must be more than 2 and less than 64 characters long";
        WebElement expectedWarning = driver.findElement(By.xpath("//*[@class='help-block' and contains(text(),'The last name must be more than 2 and less than 64 characters long')]"));
        Assert.assertEquals(expectedWarning.getText(),actualWarning);
    }

    @Test
    public void test5(){
        driver.get("http://practice.cybertekschool.com");
        BrowserUtils.pause(3);
        driver.findElement(By.linkText("Registration Form")).click();
        driver.manage().window().maximize();
        driver.findElement(By.name("firstname")).sendKeys("Juma");
        driver.findElement(By.name("lastname")).sendKeys("Gul");
        driver.findElement(By.name("username")).sendKeys("Jumagul");
        driver.findElement(By.name("email")).sendKeys("juma@yahoo.com");
        driver.findElement(By.name("password")).sendKeys("*()case#255");
        driver.findElement(By.name("phone")).sendKeys("518-858-0090");
        driver.findElement(By.name("gender")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/10/1988");
        Select DeptDropdown = new Select(driver.findElement(By.name("department")));
        DeptDropdown.selectByVisibleText("Department of Engineering");
        Select jobTitleDropdown = new Select(driver.findElement(By.name("job_title")));
        jobTitleDropdown.selectByVisibleText("SDET");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
        String actualLoginSuccess ="You've successfully completed registration!";
        WebElement expectedLoginSuccess = driver.findElement(By.xpath("//div[@id='content']//following-sibling::div//div/h4//following-sibling::p"));
        Assert.assertEquals(actualLoginSuccess,expectedLoginSuccess.getText());


    }

    @AfterMethod
    public void teardown() throws InterruptedException {
     BrowserUtils.pause(3);
        driver.quit();


    }



}
