package som.softserve.trainings.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UlimateQASelenide {
    private static final String BASE_URL = "https://courses.ultimateqa.com";

    @Test
    public void plainTest() {
        String email = System.currentTimeMillis() + "@mail123.com";

        open(BASE_URL);
        $(By.linkText("Sign In")).click();
        $(By.linkText("Create a new account")).click();
        $("#user_first_name").setValue("Homer");
        $("#user_last_name").setValue("Simpson");
        $("#user_email").setValue(email);
        $("#user_password").setValue("P@ssw0rd");
        $("#btn-signup").click();
        $("#notifications").shouldNotBe(visible);
        $("#my_account").click();
        $(By.linkText("Sign Out")).click();
        $("#notifications").shouldNotBe(visible);

        $(By.linkText("Sign In")).click();
        $("#user_email").setValue(email);
        $("#user_password").setValue("P@ssw0rd");
        $("#btn-signin").click();

        $(byText("What are Implicit and Explicit Waits")).click();
        $(By.linkText("Enroll for free")).click();

        Assert.assertEquals($("h2").getText(),
                "What are Implicit and Explicit Waits",
                "Course name is not correct!");

        $(By.linkText("Dashboard")).click();
        $("#notifications").shouldNotBe(visible);

        $("#my_account").click();
        $(By.linkText("Sign Out")).click();
    }
}
