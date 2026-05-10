import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Students {

    WebDriver driver;

   @BeforeMethod
    public void OpenTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/students.php");
    }

    @Test
public void StudentFormTest() throws InterruptedException {
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Randun Gayantha");
        Thread.sleep(3000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("randungayantha@gmail.com");
        Thread.sleep(3000);

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("0778899225");
        Thread.sleep(3000);

        WebElement dropDown = driver.findElement(By.name("grade"));
        dropDown.click();
        List<WebElement> options = dropDown.findElements(By.tagName("option"));
        for (WebElement element : options) {
            String dropDownValue = element.getText();
            if (dropDownValue.equals("Grade 13")) {
                element.click();
                break;
            }
        }
        Thread.sleep(3000);

        WebElement address = driver.findElement(By.name("address"));
        address.sendKeys("Rathnapura,Kalawana");
        Thread.sleep(3000);

        WebElement addStudent=driver.findElement(By.name("add_student"));
        addStudent.click();
    }

    @Test
    public void searchTest() throws InterruptedException {

        WebElement address = driver.findElement(By.name("search"));
        address.sendKeys("Randun");
        Thread.sleep(3000);

        WebElement search=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/form/button"));
        search.click();
        Thread.sleep(3000);

        WebElement clear=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/form/a"));
        clear.click();
    }



}
