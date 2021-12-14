import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class CartPage  extends BasePage {

    By productNameLocator = new By.ByCssSelector("div.rd-cart-item-main-info span.rd-cart-item-title");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductAdded() {
        return getProducts().size() > 0 ;

    }

    public boolean checkProductIncrease() {
        WebElement element = driver.findElement(By.cssSelector("div.rd-cart-item-quantity-area div.item-quantity-editor input.item-quantity-input"));
        return Integer.parseInt(element.getAttribute("value")) > 1 ;
    }
    private List<WebElement> getProducts(){
        return findAll(productNameLocator);
    }
}