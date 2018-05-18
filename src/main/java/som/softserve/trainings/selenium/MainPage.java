package som.softserve.trainings.selenium;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private static final String BASE_URL = "https://courses.ultimateqa.com";

    public MainPage open() {
        Selenide.open(BASE_URL);
        return this;
    }

    public LoginPage openLogin() {
        $("#notifications").shouldNotBe(visible);
        $(By.linkText("Sign In")).click();
        return new LoginPage();
    }

    public MainPage logOut() {
        $("#notifications").shouldNotBe(visible);
        $("#my_account").click();
        $(By.linkText("Sign Out")).click();
        return this;
    }

    public CoursePage enrol(String courseName) {
        $(byText(courseName)).click();
        $(By.linkText("Enroll for free")).click();
        return new CoursePage();
    }
}
