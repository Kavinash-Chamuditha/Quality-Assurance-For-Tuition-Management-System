import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Teachers {

    WebDriver driver;

    @BeforeMethod
    public void OpenTestPage(){
            driver =  new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://localhost:3000/teachers.php");
    }


    @Test
    public void addTeacherTest() throws InterruptedException {

            WebElement fullName = driver.findElement(By.name("full_name"));
            fullName.sendKeys("Kosala Pushpakumara");
            Thread.sleep(3000);

            WebElement email = driver.findElement(By.name("email"));
            email.sendKeys("kosala@gmail.com");
            Thread.sleep(3000);

            WebElement phone = driver.findElement(By.name("phone"));
            phone.sendKeys("0778877123");
            Thread.sleep(3000);

            WebElement dropDown = driver.findElement(By.name("subject"));
            dropDown.click();
            List<WebElement> options = dropDown.findElements(By.tagName("option"));
            for (WebElement element : options) {
                String dropDownValue = element.getText();
                if (dropDownValue.equals("Science")) {
                    element.click();
                    break;
                }
            }
            Thread.sleep(3000);

            WebElement address = driver.findElement(By.name("salary"));
            address.sendKeys("45000.00");
            Thread.sleep(3000);

            WebElement addStudent=driver.findElement(By.name("add_teacher"));
            addStudent.click();

        }

    @Test
    public void buttonTest() throws InterruptedException {

        Thread.sleep(3000);
        WebElement del=driver.findElement(By.xpath("(//a[@class='btn btn-danger btn-sm'][normalize-space()='Del'])[2]"));
        del.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();


    }


    }
