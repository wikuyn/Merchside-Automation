package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderReceived {
    private WebDriver driver;
    private By textNotice = By.className("woocommerce-notice");

    public OrderReceived(WebDriver driver) {
        this.driver = driver;
    }

    public String notificationMassage(){
        return driver.findElement(textNotice).getText();
    }
}
