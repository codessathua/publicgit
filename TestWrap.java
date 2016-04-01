import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/**
 * Created by ssathua on 3/31/2016.
 */
public class TestWrap {

    WebDriver driver;
    WrapLogin  login;

    @BeforeTest
    public void setup(){
        //Give  your path to chrome driver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ssathua\\myjar\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://authoring-perf-aws.wrapdev.net/#/");
    }
    @Test(priority=0)
    public void TestLogin(){
            login = new WrapLogin(driver);
            login.clickonLogin();
            login.loginWrap("s.sathua@gmail.com","A484760a");
            login.logintoPage();
            System.out.println(login.getPageTitle());
            Assert.assertEquals(login.getPageTitle(),"Wrap Authoring");
    }
    @Test
    public void publishWrap()  {
        driver.findElement(By.cssSelector(" #wrap-theme > div.authoring-container > div:nth-child(1) > div > div > div.wraps > div.row > a")).click();
        driver.findElement(By.cssSelector("#wrap-theme > div.modal.fade.ng-isolate-scope.wrap_create-modal.in > div > div > div.modal-body.ng-scope > wm-template-selector > div.wrap_create-templates > div:nth-child(1) > div > button:nth-child(2)")).click();
        //WebElement element = driver.findElement(By.cssSelector("#wrap-theme > div.authoring-container > div:nth-child(1) > div > div > div > card-header > div > div.card_header-top.clearfix > div.card_header-actions.card_header-actions--right.pull-right > button.btn.btn-success"));
        WebElement myElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#wrap-theme > div.authoring-container > div:nth-child(1) > div > div > div > card-header > div > div.card_header-top.clearfix > div.card_header-actions.card_header-actions--right.pull-right > button.btn.btn-success")));
       // Thread.sleep(40000);
        System.out.println(driver.getTitle());
        driver.findElement(By.cssSelector("#wrap-theme > div.authoring-container > div:nth-child(1) > div > div > div > card-header > div > div.card_header-top.clearfix > div.card_header-actions.card_header-actions--right.pull-right > button.btn.btn-success")).click();
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void doCleanup(){
        driver.quit();
    }
}
