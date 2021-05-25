package projectlab.pages;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;


public class BaseSteamPage extends BasePage {

    private static Button installSteam() {
        return new Button(By.xpath("//a[@class='header_installsteam_btn_content']"), "btnInstallSteamHeader");
    }

    public BaseSteamPage(By locator, String pageTitle) {
        super(locator, pageTitle);
    }

    public void clickInstallSteam() {
        installSteam().clickAndWait();
    }
}
