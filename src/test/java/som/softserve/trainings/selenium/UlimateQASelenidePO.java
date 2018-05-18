package som.softserve.trainings.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UlimateQASelenidePO {

    @Test
    public void test() {
        String email = System.currentTimeMillis() + "@mail123.com";

        MainPage mainPage = new MainPage();
        CoursePage coursePage = mainPage.openLogin()
                .signUn("Homer", "Simpson", email, "P@ssw0rd")
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
