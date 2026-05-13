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

    @Test
    public void Test_Recent_Payment_History_Table(){
        int rowCount = driver.findElements(
                By.xpath("/html/body/div[2]/div[2]/div[2]/table/tbody/tr")).size();
        System.out.println("Rows count is: " + rowCount);


        int columnCount = driver.findElements(
                By.xpath("/html/body/div[2]/div[2]/div[2]/table/thead/tr/th")).size();
        System.out.println("Column count is: " + columnCount);


        String value=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/table/tbody/tr[3]/td[3]")).getText();
        System.out.println("Specified row/column data" +value);

        for(int i=1; i<=rowCount; i++){
            for(int j=1; j<columnCount; j++){
                String tdata=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/table/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(tdata + " ");
            }
            System.out.println();
        }
    }

}
