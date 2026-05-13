import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity {


    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/activity_log.php");
    }

    @Test
    public void activityTableTest(){

        int rowCount = driver.findElements(
                By.xpath("/html/body/div[2]/div[2]/table/tbody/tr")).size();
        System.out.println("Rows count is: " + rowCount);


        int columnCount = driver.findElements(
                By.xpath("/html/body/div[2]/div[2]/table/thead/tr/th")).size();
        System.out.println("Column count is: " + columnCount);


        String value=driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[3]")).getText();
        System.out.println("Specified row/column data" +value);

    }

}
