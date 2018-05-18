package som.softserve.trainings.selenium;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public MainPage signIn(String email, String password) {
        $("#user_email").setValue(email);
        $("#user_password").setValue(password);
        $("#btn-signin").click();
        return new MainPage();
    }

    public MainPage signUn(String firstName, String  lastName, String email, String password) {
        $(By.linkText("Create a new account")).click();
        $("#user_first_name").setValue(firstName);
        $("#user_last_name").setValue(lastName);
        $("#user_email").setValue(email);
        $("#user_password").setValue(password);
        $("#btn-signup").click();
        return new MainPage();
    }
}
