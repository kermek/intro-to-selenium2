package som.softserve.trainings.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class UlimateQASelenidePO {
    private static final String BASE_URL = "https://courses.ultimateqa.com";

    @Test
    public void test() {
        String email = System.currentTimeMillis() + "@mail123.com";

        MainPage mainPage = open(BASE_URL, MainPage.class);
        CoursePage coursePage = mainPage.openRegistration()
                .signUp("Homer", "Simpson", email, "P@ssw0rd")
                .logOut()
                .openLogin()
                .signIn(email, "P@ssw0rd")
                .enrol("What are Implicit and Explicit Waits");

        Assert.assertEquals(coursePage.getTitle(),
                "What are Implicit and Explicit Waits",
                "Course name is not correct!");

        coursePage.openDashboard()
                .logOut();
    }
}
