import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Reports {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/reports.php");
        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void buttonTest() throws InterruptedException {

        Thread.sleep(3000);
        WebElement databaseView=driver.findElement(By.xpath("//a[contains(text(),'\uD83D\uDDC2\uFE0F Database Views')]"));
        databaseView.click();
        Thread.sleep(3000);
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        jsExecutor.executeScript("window.scrollTo(0,0)");
        Thread.sleep(3000);


        Thread.sleep(3000);
        WebElement biQuaries=driver.findElement(By.xpath("//a[contains(text(),'\uD83D\uDCC8 BI Queries')]"));
        biQuaries.click();
        Thread.sleep(3000);
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        jsExecutor.executeScript("window.scrollTo(0,0)");
        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        WebElement stReport=driver.findElement(By.xpath("//a[contains(text(),'\uD83C\uDF93 Student Report (Cursor)')]"));
        stReport.click();
        Thread.sleep(3000);

        WebElement dropDown1 = driver.findElement(By.name("student_id"));
        dropDown1.click();
        List<WebElement> options1 = dropDown1.findElements(By.tagName("option"));
        for (WebElement element : options1) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("Randun Gayantha (Grade 13)")) {
                element.click();
                break;
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/button")).click();
        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        WebElement revenue=driver.findElement(By.xpath("//a[contains(text(),'\uD83D\uDCB0 Revenue')]"));
        revenue.click();
        Thread.sleep(3000);










    }

}
