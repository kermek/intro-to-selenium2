package som.softserve.trainings.selenium;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public LoginPage openLogin() {
        $("#notifications").shouldNotBe(visible);
        $(By.linkText("Sign In")).click();
        return page(LoginPage.class);
    }

    public RegistrationPage openRegistration() {
        $("#notifications").shouldNotBe(visible);
        $(By.linkText("Sign In")).click();
        $(By.linkText("Create a new account")).click();
        return page(RegistrationPage.class);
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
        return page(CoursePage.class);
    }
}
