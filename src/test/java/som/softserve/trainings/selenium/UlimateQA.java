package som.softserve.trainings.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UlimateQA {
    private WebDriver driver;
    private static final String BASE_URL = "https://courses.ultimateqa.com";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")
                + "/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void plainTest() {
        String email = System.currentTimeMillis() + "@mail123.com";
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.linkText("Create a new account")).click();
        driver.findElement(By.id("user_first_name")).clear();
        driver.findElement(By.id("user_first_name")).sendKeys("Homer");
        driver.findElement(By.id("user_last_name")).clear();
        driver.findElement(By.id("user_last_name")).sendKeys("Simpson");
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("P@ssw0rd");
        driver.findElement(By.id("btn-signup")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.invisibilityOfElementLocated((By.id("notifications"))));
        driver.findElement(By.id("my_account")).click();
        driver.findElement(By.linkText("Sign Out")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.invisibilityOfElementLocated((By.id("notifications"))));
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("P@ssw0rd");
        driver.findElement(By.id("btn-signin")).click();

        driver.findElement(By.xpath("//h4[contains(text(), " +
                "'What are Implicit and Explicit Waits')]")).click();
        driver.findElement(By.linkText("Enroll for free")).click();

        Assert.assertEquals(driver.findElement(By.tagName("h2"))
                .getText(),
                "What are Implicit and Explicit Waits",
                "Course name is not correct!");

        driver.findElement(By.linkText("Dashboard")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.invisibilityOfElementLocated((By.id("notifications"))));
        driver.findElement(By.id("my_account")).click();
        driver.findElement(By.linkText("Sign Out")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
