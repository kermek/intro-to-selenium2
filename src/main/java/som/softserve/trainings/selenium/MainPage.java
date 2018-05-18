package som.softserve.trainings.selenium;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(how = How.ID, using = "notifications")
    private SelenideElement notifications;

    @FindBy(how = How.LINK_TEXT, using = "Sign In")
    private SelenideElement signIn;

    @FindBy(how = How.ID, using = "my_account")
    private SelenideElement myAccount;

    @FindBy(how = How.LINK_TEXT, using = "Create a new account")
    private SelenideElement createANewAccount;

    @FindBy(how = How.LINK_TEXT, using = "Sign Out")
    private SelenideElement signOut;

    @FindBy(how = How.LINK_TEXT, using = "Enroll for free")
    private SelenideElement enrollForFree;

    public LoginPage openLogin() {
        notifications.shouldNotBe(visible);
        signIn.click();
        return page(LoginPage.class);
    }

    public RegistrationPage openRegistration() {
        notifications.shouldNotBe(visible);
        signIn.click();
        createANewAccount.click();
        return page(RegistrationPage.class);
    }

    public MainPage logOut() {
        notifications.shouldNotBe(visible);
        myAccount.click();
        signOut.click();
        return this;
    }

    public CoursePage enrol(String courseName) {
        $(byText(courseName)).click();
        enrollForFree.click();
        return page(CoursePage.class);
    }
}
