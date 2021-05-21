package framework.elements;

import org.openqa.selenium.By;

public class Body extends BaseElement {

    public Body(By locator, final String name) {
        super(locator, name);
    }

    protected String getElementType() {
        return getLocale("loc.body");
    }


}
