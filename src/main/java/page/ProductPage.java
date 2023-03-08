package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage {

    private WebDriver driver;
    private By buttonAddToChart = By.className("single_add_to_cart_button");
    private By dropDownSize = By.id("pa_size");
    private By productInTopLeft = By.linkText("Anjing Tanah – Tamagochi");
    private By buttonCheckOut = By.cssSelector("a[class='button checkout wc-forward wp-element-button']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage clickProduct(){
        driver.findElement(productInTopLeft).click();
        return new ProductPage(driver);
    }

    public void selectSizeDropDown(String size){
        findDropDownElement().selectByVisibleText(size);
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropDownSize));
    }

    public List<String> getAllOption(){
        List<WebElement> elementsOption = findDropDownElement().getAllSelectedOptions();
        return elementsOption.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public void clickAddToChart(){
        //Scroll until view show
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(buttonAddToChart));
        driver.findElement(buttonAddToChart).click();
    }

    public CheckOutPage clickCheckOut(){
        driver.findElement(buttonCheckOut).click();
        return new CheckOutPage(driver);
    }
}
