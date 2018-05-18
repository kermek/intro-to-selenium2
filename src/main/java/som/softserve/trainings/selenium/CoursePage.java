package som.softserve.trainings.selenium;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CoursePage {
    public String getTitle() {
        return $("h2").getText();
    }

    public MainPage openDashboard() {
        $(By.linkText("Dashboard")).click();
        return new MainPage();
    }

}
