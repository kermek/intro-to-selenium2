package som.softserve.trainings.selenium;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    @FindBy(how = How.ID, using = "user_email")
    private SelenideElement userEmail;

    @FindBy(how = How.ID, using = "user_password")
    private SelenideElement userPassword;

    @FindBy(how = How.ID, using = "btn-signin")
    private SelenideElement signIn;

    public MainPage signIn(String email, String password) {
        userEmail.setValue(email);
        userPassword.setValue(password);
        signIn.click();
        return page(MainPage.class);
    }
}
