package som.softserve.trainings.selenium;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    public MainPage signUp(String firstName, String lastName, String email, String password) {
        $("#user_first_name").setValue(firstName);
        $("#user_last_name").setValue(lastName);
        $("#user_email").setValue(email);
        $("#user_password").setValue(password);
        $("#btn-signup").click();
        return page(MainPage.class);
    }
}
