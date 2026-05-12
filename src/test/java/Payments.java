import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Payments {


    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/payments.php");
    }


    @Test
    public void recordPaymentTest() throws InterruptedException {

        WebElement dropDown1 = driver.findElement(By.name("enroll_id"));
        dropDown1.click();
        List<WebElement> options1 = dropDown1.findElements(By.tagName("option"));
        for (WebElement element : options1) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("Randun Gayantha - ICT Beginners (Rs.3000.00) [PENDING]" )) {
                element.click();
                break;
            }
            Thread.sleep(3000);
        }


        WebElement address = driver.findElement(By.name("amount"));
        address.sendKeys("3000.00");
        Thread.sleep(3000);


        WebElement dropDown2 = driver.findElement(By.name("method"));
        dropDown2.click();
        List<WebElement> options2 = dropDown2.findElements(By.tagName("option"));
        for (WebElement element : options2) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("\uD83D\uDCB5 Cash")){
                element.click();
                break;
            }
        }
        Thread.sleep(3000);



        WebElement pay=driver.findElement(By.name("pay"));
        pay.click();
    }

}
