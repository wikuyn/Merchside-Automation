package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CheckOutPage {
    private WebDriver driver;
    private By inputFirstname = By.id("billing_first_name");
    private By inputLastname = By.id("billing_last_name");
    private By inputAddress = By.id("billing_address_1");
    private By dropdownProvince = By.id("billing_state");
    private By dropdownCity = By.id("billing_city");
    private By dropdownDistrict = By.id("billing_address_2");
    private By inputPhoneNumber = By.id("billing_phone");
    private By inputEmail = By.id("billing_email");
    private By checkboxAgree = By.className("woocommerce-terms-and-conditions-checkbox-text");
    private By buttonPlaceOrder = By.id("place_order");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setInputFirstname(String firstName) {
        driver.findElement(inputFirstname).sendKeys(firstName);
    }

    public void setInputLastname(String lastName) {
        driver.findElement(inputLastname).sendKeys(lastName);
    }

    public void setInputAddress(String adress) {
        driver.findElement(inputAddress).sendKeys(adress);
    }

    //Dropdown province
    public void setDropdownProvince(String province) {
        findProvinceDropDown().selectByVisibleText(province);
    }

    private Select findProvinceDropDown(){
        return new Select(driver.findElement(dropdownProvince));
    }

    public List<String> getAllOptionProvince(){
        List<WebElement> province = findProvinceDropDown().getAllSelectedOptions();
        return province.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    //Dropdown city
    public void setDropdownCity(String city) {
        findCityDropdown().selectByVisibleText(city);
    }

    private Select findCityDropdown(){
        return new Select(driver.findElement(dropdownCity));
    }

    public List<String> getAllOptionCity(){
        List<WebElement> listCity = findCityDropdown().getAllSelectedOptions();
        return listCity.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    //Dropdown district
    public void setDropdownDistrict(String district){
        findDistrictDropdown().selectByVisibleText(district);
    }

    private Select findDistrictDropdown(){
        return new Select(driver.findElement(dropdownDistrict));
    }

    public List<String> getAllOptionDistrict(){
        List<WebElement> listDistrict = findDistrictDropdown().getAllSelectedOptions();
        return listDistrict.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public void setInputPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }

    public void setInputEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void clickCheckboxAgree(){
        //Wait until element checkbox is visible and rady to click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkboxAgree));
        driver.findElement(checkboxAgree).click();
    }

    public OrderReceived clickPlacedOrder(){
        driver.findElement(buttonPlaceOrder).click();
        return new OrderReceived(driver);
    }

}
