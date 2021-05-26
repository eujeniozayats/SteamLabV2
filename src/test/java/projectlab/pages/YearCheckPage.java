package projectlab.pages;

import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;

public class YearCheckPage extends BaseSteamPage {

    private static final String yearVal = "1";

    public YearCheckPage() {
        super(By.xpath("//body[@class='v6 app game_bg responsive_page']"), "Year Check");
        passAge();
        info(getLocale("loc.gamename") + gameName.getText());
    }

    private static final Label gameName = new Label(By.xpath("//div[@class='apphub_AppName']"), "Name");

    private static final Button setYear = new Button(By.id("ageYear"), "Set Year Button");

    private static final Button clickViewPage = new Button(By.xpath(String.format("//span[text()='%s']", getLocale("loc.openpage"))), "View Page");

    public void passAge() {
        if (clickViewPage.isPresent()) {
            setYear.clickAndWait();
            setYear.sendKeys(yearVal);
            clickViewPage.clickAndWait();
        }
    }
}
