package projectlab.pages;

import framework.BasePage;
import framework.elements.Body;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.testng.Assert;


public class BaseSteamPage extends BasePage {
    private static final String installSteamLoc = "//a[@class='header_installsteam_btn_content']";
    protected String title;

    public BaseSteamPage(final By locator, final String pageTitle) {
        title = pageTitle;
        Body pageTarget = new Body(locator, pageTitle);
        Assert.assertTrue(pageTarget.isPresent());
        info(String.format(getLocale("loc.page.opens"), title));
    }

    protected static Button installSteam() {
        return new Button(By.xpath(installSteamLoc), "btnInstallSteamHeader");
    }

    public void clickInstallSteam() {
        installSteam().clickAndWait();
    }
}
