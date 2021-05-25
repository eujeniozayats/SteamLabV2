package projectlab.test;

import framework.BaseTest;
import framework.PropReader;
import framework.browser.BrowserManager;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import projectlab.pages.CategoryPage;
import projectlab.pages.GamePage;
import projectlab.pages.InstallerPage;
import projectlab.pages.MainPage;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class TC_001_DownloadSteamTest extends BaseTest {

    @Parameters({"siteLanguage"})
    @BeforeClass
    public void before(String siteLanguage) {
        resourceBundle = ResourceBundle.getBundle(resourceBundlePath, Locale.forLanguageTag(siteLanguage));
    }

    public void runTest() throws Exception {
        logger.step(1);
        MainPage mainPage = new MainPage();
        mainPage.navigateMenu("loc.categories", "loc.genre");

        logger.step(2);
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.findBestDeal();

        logger.step(3);
        GamePage gamePage = new GamePage();
        gamePage.validateIsGamePresent();
        gamePage.clickInstallSteam();

        logger.step(4);
        InstallerPage installerPage = new InstallerPage();
        installerPage.downloadSteamAndVerify();
    }
}
