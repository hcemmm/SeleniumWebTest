import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Random;


public class Lcw_Test extends BaseTest {


    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    Random random = new Random();

    @Test
    @Order(1)
    public void entery_login() {
        homePage = new HomePage(driver);
        homePage.goToLogin();
        homePage.giris();
        Assertions.assertTrue(homePage.isLoginPage() ,
                "Giris Yapilmadi!");
    }

   @Test
    @Order(2)
    public void search_a_product(){
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.searchBox().search("pantolan");
        homePage.downandmore();
        Assertions.assertTrue(productsPage.isOnProductPage() ,
                "Urunler Sayfasi Degil!");
    }

    @Test
    @Order(3)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(random.nextInt(100));
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Urun Detay sayfasi Degil!");
        productDetailPage.addToCart();
    }

    @Test
    @Order(4)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded() ,
                "Ürün eklenmedi!");
    }
      @Test
        @Order(5)
        public void check_price() {
            Assertions.assertTrue(productDetailPage.checkPriceProduct() ,
                    "Fiyatlar aynı değil!");
        }

    @Test
    @Order(6)
    public void increase_produc(){
        homePage.inc_product();
        driver.navigate().refresh();
            Assertions.assertTrue(cartPage.checkProductIncrease(),
                "Adet sayısı artmadı!");
    }

    @Test
    @Order(7)
    public void delete_produc(){
    homePage.product_del();
    homePage.productdelete();
        Assertions.assertTrue(homePage.isElementPresent(),
                "Sepet boş değil!");

    }

}
