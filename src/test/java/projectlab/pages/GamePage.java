package projectlab.pages;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;


public class GamePage extends BaseSteamPage {
    private static final String pagelocator = "//body[@class='v6 app game_bg responsive_page']";
    private static final String clickViewLocator = "//span[text()='%s']";
    private static final String gameNameLocator = "//div[@class='apphub_AppName']";
    private static final String setAgeLocator = "ageYear";
    private static final String yearVal = "1";

    public GamePage() {
        super(By.xpath(pagelocator), "GamePage");
        passAge();
        info(getLocale("loc.gamename") + gameName().getText());
    }

    private Label gameName() {
        return new Label(By.xpath(gameNameLocator), "Name");
    }

    private Button setYear() {
        return new Button(By.id(setAgeLocator), "btnSetYear");
    }

    private Button clickViewPage() {
        return new Button(By.xpath(String.format(clickViewLocator, getLocale("loc.openpage"))), "View Page");
    }

    public void passAge() {
        if (clickViewPage().isPresent()) {
            setYear().clickAndWait();
            setYear().sendKeys(yearVal);
            clickViewPage().clickAndWait();
        }
    }

    public void validateIsGamePresent() {
        gameName().isPresent();
    }
}


