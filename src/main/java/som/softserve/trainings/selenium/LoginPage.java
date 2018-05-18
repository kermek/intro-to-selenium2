package som.softserve.trainings.selenium;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public MainPage signIn(String email, String password) {
        $("#user_email").setValue(email);
        $("#user_password").setValue(password);
        $("#btn-signin").click();
        return page(MainPage.class);
    }
}
