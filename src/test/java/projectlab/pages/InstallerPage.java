package projectlab.pages;

import framework.FileDownloader;
import framework.elements.Button;
import org.openqa.selenium.By;

import java.io.IOException;

public class InstallerPage extends BaseSteamPage {

    private static final String expectedFileName = "SteamSetup.exe";
    private static final int downloadTimeout = 5000;

    public InstallerPage() {
        super(By.xpath("//body[@class='v6 promoannounce responsive_page']"), "Installer Page");
    }

    private Button installSteam = new Button(By.xpath("//div[@id='about_greeting']/div[@class='about_install_wrapper']/div[@class='about_install win ']/a"), "Install Steam Button");


    public void downloadSteamAndVerify() throws IOException {
        installSteam.clickAndWait();
        info(getLocale("loc.download"));
        FileDownloader fd = new FileDownloader();
        fd.waitForFileDownload(downloadTimeout, expectedFileName);
        fd.verifyFileDownloaded();
        fd.deleteFileDownloaded();
    }
}
