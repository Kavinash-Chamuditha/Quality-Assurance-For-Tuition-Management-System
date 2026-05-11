import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Enrollments {


    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/enrollments.php");


    }

    @Test
    public void addenrollmentTest() throws InterruptedException {

        WebElement dropDown1 = driver.findElement(By.name("student_id"));
        dropDown1.click();
        List<WebElement> options1 = dropDown1.findElements(By.tagName("option"));
        for (WebElement element : options1) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("Randun Gayantha (Grade 13)")) {
                element.click();
                break;
            }
            Thread.sleep(3000);
        }

        WebElement dropDown2 = driver.findElement(By.name("class_id"));
        dropDown2.click();
        List<WebElement> options2 = dropDown2.findElements(By.tagName("option"));
        for (WebElement element : options2) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("ICT Beginners - Rs.3000.00")){
                element.click();
                break;
            }
        }
        Thread.sleep(3000);

        WebElement sub=driver.findElement(By.name("enroll"));
        sub.click();
    }

    @Test
    public void searchTest() throws InterruptedException {


        WebElement dropDown1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/form/select"));
        dropDown1.click();
        List<WebElement> options1 = dropDown1.findElements(By.tagName("option"));
        for (WebElement element : options1) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("Ashan Bandara")) {
                element.click();
                break;
            }
        }

        Thread.sleep(3000);

        WebElement search=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/form/button"));
        search.click();
        Thread.sleep(3000);

        WebElement clear=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/form/a"));
        clear.click();
    }
}
