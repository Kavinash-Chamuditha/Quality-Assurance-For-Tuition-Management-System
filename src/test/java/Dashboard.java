import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dashboard {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/index.php");
        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void buttonTest() throws InterruptedException {

        Thread.sleep(3000);
        WebElement view=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/a"));
        view.click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);

        WebElement manage=driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/a"));
        manage.click();
        Thread.sleep(3000);
        driver.navigate().back();


    }

    @Test
    public void scrollTest() throws InterruptedException {

        Thread.sleep(3000);
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        jsExecutor.executeScript("window.scrollTo(0,0)");
        Thread.sleep(3000);


    }
}
