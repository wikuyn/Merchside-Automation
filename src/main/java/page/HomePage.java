package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By buttonNavShop = By.xpath("//*[@id=\"menu-item-2026\"]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ShopPage clickButtonNavShop(){
        driver.findElement(buttonNavShop).click();
        return new ShopPage(driver);
    }
}
