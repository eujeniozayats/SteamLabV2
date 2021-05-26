package projectlab.pages;

import framework.elements.Label;
import org.openqa.selenium.By;


public class GamePage extends BaseSteamPage {

    public GamePage() {
        super(By.xpath("//body[@class='v6 app game_bg responsive_page']"), "GamePage");
        YearCheckPage yearCheckPage = new YearCheckPage();
        yearCheckPage.passAge();
        info(getLocale("loc.gamename") + gameName.getText());
    }

    private static final Label gameName = new Label(By.xpath("//div[@class='apphub_AppName']"), "Name");

    public void validateIsGamePresent() {
        gameName.isPresent();
    }
}


