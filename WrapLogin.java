import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ssathua on 3/31/2016.
 */
public class WrapLogin {
    WebDriver driver;
    By clickonlogin=By.xpath("//*[@id=\"wrap-theme\"]/wm-global-nav/header/div/div[3]/div/div/nav/a[1]/span");
    By userName = By.cssSelector("#wrap-theme > wm-global-nav > header > div > div.global-nav_section.global-nav_section--right > div > div > div > wm-auth-popup > div > wm-auth > div > div.auth_form > wm-login > div > form > input:nth-child(3)");
    By passWord = By.cssSelector("#wrap-theme > wm-global-nav > header > div > div.global-nav_section.global-nav_section--right > div > div > div > wm-auth-popup > div > wm-auth > div > div.auth_form > wm-login > div > form > input:nth-child(4)");
    By login = By.cssSelector("#wrap-theme > wm-global-nav > header > div > div.global-nav_section.global-nav_section--right > div > div > div > wm-auth-popup > div > wm-auth > div > div.auth_form > wm-login > div > form > button");

    public WrapLogin(WebDriver driver){
        this.driver = driver;
    }

    public void clickonLogin(){
        driver.findElement(clickonlogin).click();
    }

    public void setUserName(String inputuserName){
        driver.findElement(userName).sendKeys(inputuserName);
    }

    public void setPassword(String inputpassword){
        driver.findElement(passWord).sendKeys(inputpassword);
    }

    public void logintoPage(){
        driver.findElement(login).click();
    }
    public String getPageTitle(){
       return  driver.getTitle();
    }
    public void loginWrap(String Username,String Password){
        this.setUserName(Username);
        this.setPassword(Password);
    }
}
