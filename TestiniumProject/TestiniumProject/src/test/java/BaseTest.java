import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestLogger.class)
public class BaseTest {

    WebDriver driver;

    @BeforeAll
    public void start(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();
    }

    @AfterAll
    public void fnish(){
    }

}
