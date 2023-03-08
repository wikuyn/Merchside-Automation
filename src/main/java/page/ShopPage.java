package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage {
    private WebDriver driver;
    private By inputSearch = By.name("s");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }


}
