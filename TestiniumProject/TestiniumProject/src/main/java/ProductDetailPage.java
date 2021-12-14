import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductDetailPage extends BasePage{

    By addToCartButtonLocator = By.id("pd_add_to_cart");
    By productSizeLocator = new By.ByCssSelector("a[data-tracking-label='BedenSecenekleri']");
    By productPriceLocator = By.xpath("//*[@id=\"rightInfoBar\"]/div[1]/div/div[2]/div/div/div/span[2]");
    By cartPriceLocator = By.xpath("//*[@id=\"cart-items\"]/div[3]/div/div[2]/p[4]");
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(productSizeLocator);
        click(addToCartButtonLocator);
    }

    public boolean checkPriceProduct(){
        return productPriceLocator != cartPriceLocator;
    }

}