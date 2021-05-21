package projectlab.pages;

import framework.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BaseSteamPage {
    private static final String pagelocator = "//body[@class='v6 infinite_scrolling responsive_page']";
    private static final String genresLocator = "//div[@class='popup_menu_subheader popup_genre_expand_header responsive_hidden']/a[contains(text(), '%s')]";
    private static final String pullDownMenuLocator = "//a[@class='pulldown_desktop' and text()='%s']";
    private static final String langLocator = "language_pulldown";
    private static final String engLang = getLocale("loc.langname");
    String btnLang = changeLang().getText();

    public MainPage() {
        super(By.xpath(pagelocator), "MainPage");
        changeLanguage();
    }

    private static Button changeLang() {
        return new Button(By.id(langLocator), "btnChangeLang");
    }

    private Button setEng() {
        return new Button(By.linkText(engLang), "btnTargetLang");
    }

    public void changeLanguage() {
        if (!btnLang.equals(getLocale("loc.language"))) {
            changeLang().clickAndWait();
            setEng().clickAndWait();
            info(String.format(getLocale("loc.lang.choose"), getLocale("loc.langname")));
        }

    }

    private Button btnGenres(String genre) {
        return new Button(By.xpath(String.format(genresLocator, genre)), "btnGenre");
    }

    private Button menuItems(String menuItem) {
        return new Button(By.xpath(String.format(pullDownMenuLocator, menuItem)), "btnMenuItem");

    }

    public void navigateMenu(String dropDownMenuLoc, String genreTitleLoc) {
        info(String.format(getLocale("loc.menuItem.choose"), getLocale(dropDownMenuLoc)));
        menuItems(getLocale(dropDownMenuLoc)).clickAndWait();
        info(String.format(getLocale("loc.genre.choose"), getLocale(genreTitleLoc)));
        btnGenres(getLocale(genreTitleLoc)).clickAndWait();

    }
}
