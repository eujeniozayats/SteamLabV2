package projectlab.pages;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class YearCheckPage extends BaseSteamPage {

    private static final String yearVal = "1";

    public YearCheckPage() {
        super(By.xpath("//body[@class='v6 app game_bg responsive_page']"), "Year Check");
        passAge();
        info(getLocale("loc.gamename") + gameName().getText());
    }

    private Label gameName() {
        return new Label(By.xpath("//div[@class='apphub_AppName']"), "Name");
    }

    private Button setYear() {
        return new Button(By.id("ageYear"), "Set Year Button");
    }

    private Button clickViewPage() {
        return new Button(By.xpath(String.format("//span[text()='%s']", getLocale("loc.openpage"))), "View Page");
    }

    public void passAge() {
        if (clickViewPage().isPresent()) {
            setYear().clickAndWait();
            setYear().sendKeys(yearVal);
            clickViewPage().clickAndWait();
        }
    }
}
