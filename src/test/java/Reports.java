import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Reports {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/reports.php");
    }

    @Test
    public void buttonTest() throws InterruptedException {

        Thread.sleep(3000);
        WebElement databaseView=driver.findElement(By.xpath("//a[contains(text(),'\uD83D\uDDC2\uFE0F Database Views')]"));
        databaseView.click();
        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        WebElement biQuaries=driver.findElement(By.xpath("//a[contains(text(),'\uD83D\uDCC8 BI Queries')]"));
        biQuaries.click();
        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        WebElement stReport=driver.findElement(By.xpath("//a[contains(text(),'\uD83C\uDF93 Student Report (Cursor)')]"));
        stReport.click();
        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        WebElement revenue=driver.findElement(By.xpath("//a[contains(text(),'\uD83D\uDCB0 Revenue')]"));
        revenue.click();
        Thread.sleep(3000);
        driver.navigate().back();









    }

}
