package projectlab.test;

import framework.BaseTest;
import projectlab.pages.CategoryPage;
import projectlab.pages.GamePage;
import projectlab.pages.InstallerPage;
import projectlab.pages.MainPage;

public class TC_001_DownloadSteamTest extends BaseTest {

    public void runTest() throws Exception {
        logger.step(1);
        MainPage mpage = new MainPage();
        mpage.navigateMenu("loc.categories", "loc.genre");

        logger.step(2);
        CategoryPage actpage = new CategoryPage();
        actpage.findBestDeal();

        logger.step(3);
        GamePage gpage = new GamePage();
        gpage.validateIsGamePresent();
        gpage.clickInstallSteam();

        logger.step(4);
        InstallerPage instpage = new InstallerPage();
        instpage.downloadSteamAndVerify();
    }
}
