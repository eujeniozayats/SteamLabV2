package projectlab.pages;

import framework.browser.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CategoryPage extends BaseSteamPage {

    public CategoryPage() {
        super(By.xpath("//body[@class='v6 tag_page game_bg contenthub_page responsive_page']"), "CategoryPage");
    }

    public void findBestDeal() {
        List<WebElement> listings = BrowserManager.getInstance().getDriver().findElements(By.xpath("//div[@class='discount_block  discount_block_inline']/div[@class='discount_pct']"));
        List<String> all_elements_text = new ArrayList<>();
        for (WebElement listing : listings) {
            all_elements_text.add(listing.getText());
        }
        String highest = Collections.max(all_elements_text);
        List<WebElement> listings2 = BrowserManager.getInstance().getDriver().findElements(By.xpath(String.format("//div[@class='discount_block  discount_block_inline']/div[@class='discount_pct' and text()='%s']", highest)));
        Random r = new Random();
        int randomValue = r.nextInt(listings2.size());
        info(getLocale("loc.clickrandom"));
        listings2.get(randomValue).click();
    }
}
