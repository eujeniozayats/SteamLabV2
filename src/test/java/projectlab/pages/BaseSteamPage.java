package projectlab.pages;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;


public class BaseSteamPage extends BasePage {

    public BaseSteamPage(By locator, String pageTitle) {
        super(locator, pageTitle);
    }

    private Button installSteam = new Button(By.xpath("//a[@class='header_installsteam_btn_content']"), "Header Install Steam Button");


    public void clickInstallSteam() {
        installSteam.clickAndWait();
    }
}
