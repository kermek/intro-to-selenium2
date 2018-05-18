package som.softserve.trainings.selenium;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {

    @FindBy(how = How.ID, using = "user_first_name")
    private SelenideElement userFirstName;

    @FindBy(how = How.ID, using = "user_last_name")
    private SelenideElement userLastName;

    @FindBy(how = How.ID, using = "user_email")
    private SelenideElement userEmail;

    @FindBy(how = How.ID, using = "user_password")
    private SelenideElement userPassword;

    @FindBy(how = How.ID, using = "btn-signup")
    private SelenideElement signUn;

    public MainPage signUp(String firstName, String lastName, String email, String password) {
        userFirstName.setValue(firstName);
        userLastName.setValue(lastName);
        userEmail.setValue(email);
        userPassword.setValue(password);
        signUn.click();
        return page(MainPage.class);
    }
}
