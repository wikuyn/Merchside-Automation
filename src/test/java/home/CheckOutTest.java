package home;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CheckOutPage;
import setup.BaseSetup;

public class CheckOutTest extends BaseSetup {
    private CheckOutPage checkOutPage;

    @Test(priority = 1)
    public void openShop(){
        homePage.clickButtonNavShop();
    }

    @Test(priority = 2)
    public void selectProduct(){
        setupProductPage.clickProduct();
    }

    @Test(priority = 3)
    public void selectSizeProduct(){
        setupProductPage.selectSizeDropDown("Medium");
        System.out.println(setupProductPage.getAllOption());
    }

    @Test(priority = 4)
    public void clickAddToChart(){
        setupProductPage.clickAddToChart();
    }

    @Test(priority = 5)
    public void clikCheckOut(){
        checkOutPage = setupProductPage.clickCheckOut();
    }

    @Test(priority = 6)
    public void inputFormCheckout(){
        checkOutPage.setInputFirstname("Percobaan");
        checkOutPage.setInputLastname("Coba doang");
        checkOutPage.setInputAddress("Jl. Jalan ke tanjung lesung");
        checkOutPage.setDropdownProvince("DKI Jakarta");
        checkOutPage.setDropdownCity("Kota Jakarta Selatan");
        checkOutPage.setDropdownDistrict("Jagakarsa");
        checkOutPage.setInputPhoneNumber("085877463824");
        checkOutPage.setInputEmail("cobadoang@gmail.com");
    }

    @Test(priority = 7)
    public void clickCheckboxAgree(){
        checkOutPage.clickCheckboxAgree();
    }

    @Test(priority = 8)
    public void clickButtonPlaceOrder(){
        Assert.assertEquals(checkOutPage.clickPlacedOrder().notificationMassage(), "Thank you. Your order has been received.");
    }

}
