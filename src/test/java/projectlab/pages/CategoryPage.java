package projectlab.pages;

import framework.browser.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CategoryPage extends BaseSteamPage {

    private static final String pagelocator = "//body[@class='v6 tag_page game_bg contenthub_page responsive_page']";
    private static final String recommendedSpecials = "//a/div/div/div[@class='discount_pct']";
    private static final String specialsTopDeals = "//a/div/div/div[@class='discount_pct' and text()='%s']";

    public CategoryPage() {
        super(By.xpath(pagelocator), "CategoryPage");
    }

    public void findBestDeal() {
        List<WebElement> listings = BrowserManager.getInstance().getDriver().findElements(By.xpath(recommendedSpecials));
        List<String> all_elements_text = new ArrayList<>();
        for (WebElement listing : listings) {
            all_elements_text.add(listing.getText());
        }
        String highest = Collections.max(all_elements_text);
        List<WebElement> listings2 = BrowserManager.getInstance().getDriver().findElements(By.xpath(String.format(specialsTopDeals, highest)));
        Random r = new Random();
        int randomValue = r.nextInt(listings2.size());
        info(getLocale("loc.clickrandom"));
        listings2.get(randomValue).click();
    }
}
