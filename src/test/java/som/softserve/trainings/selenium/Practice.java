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

public class Practice {
    private WebDriver driver;
    private static final String BASE_URL = "http://automationpractice.com";

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
        driver.findElement(By.cssSelector("a.login")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("user1@mail123.com");
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("P@ssw0rd");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("t-shirt");
        driver.findElement(By.name("submit_search")).click();
        driver.findElement(By.linkText("Faded Short Sleeve T-shirts")).click();
        driver.findElement(By.name("Submit")).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.className("icon-ok"))));
        driver.findElement(By.linkText("Proceed to checkout")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("td.cart_description"))
                .getText()
                .contains("Faded Short Sleeve T-shirts"), "Card item is not correct!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
