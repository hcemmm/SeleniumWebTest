import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    SearchBox searchBox ;
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    By cartContainerLocator = By.cssSelector("a.header-cart");
    By cartdeleteLocator = By.className("cart-square-link");
    By increaseLacator = By.linkText("+");
    By moreLocator = By.className("lazy-load-button");
    By goToLoginLocator = By.linkText("Giriş Yap");
    By accountnLocator = By.linkText("Hesabım");
    By logins = By.id("loginLink");
    By mail = By.id("LoginEmail");
    By password = By.id("Password");


    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);

    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public boolean isOnProductPage() {
        return isDisplayed(accountnLocator);
    }

    public void goToLogin(){

        click(goToLoginLocator);
    }

    public void giris(){
        type(mail,"canopusky@gmail.com");
        type(password,"canopusky58");
        click(logins);
    }

    public void downandmore(){
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        click(moreLocator);
    }

    public void inc_product(){
        click(increaseLacator);
    }

    public void productdelete(){

        WebElement element = driver.findElement(By.cssSelector("div.col-xs-12 a.inverted-modal-button"));
        jse.executeScript("arguments[0].click();", element);
    }

    public void product_del() {
        click(cartdeleteLocator);
    }

    public void goToCart() {
        click(cartContainerLocator);
    }

    public boolean isElementPresent(){
        int i=driver.findElements(goToLoginLocator).size();
        return i == 0;
    }


    public boolean isLoginPage() {
        return isDisplayed(accountnLocator);
    }

}