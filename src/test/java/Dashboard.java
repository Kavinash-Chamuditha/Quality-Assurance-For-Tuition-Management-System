import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dashboard {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/index.php");
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
}
