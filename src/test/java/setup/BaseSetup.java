package setup;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import page.HomePage;
import page.ProductPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseSetup {
    private final String BASE_URL = "https://merchside.co.id/";
    private WebDriver driver;
    public HomePage homePage;
    public ProductPage setupProductPage;

    @BeforeClass
    public void setup(){
        //inport drive chrome
        System.setProperty("webdriver.chrome.driver", "E:\\Data\\WIKU_YOGA_NDARU\\SELENIUM\\library\\chrome\\chromedriver.exe");

        //create instance driver as chrome driver
        driver = new ChromeDriver();
        //set window to maximize
        driver.manage().window().maximize();
        //set timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //navigate browser to BASE_URL
        driver.navigate().to(BASE_URL);

        homePage = new HomePage(driver);
        setupProductPage = new ProductPage(driver);
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result){
        if (result.getStatus() == ITestResult.SUCCESS){
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshot/"+result.getName()+".jpg"));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
