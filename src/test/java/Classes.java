import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


    public class Classes {

        WebDriver driver;

        @BeforeMethod
        public void OpenTestPage(){
            driver =  new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://localhost:3000/classes.php");
        }

        @Test
        public void StudentFormTest() throws InterruptedException {
            WebElement fullName = driver.findElement(By.name("class_name"));
            fullName.sendKeys("Science Grade 8");
            Thread.sleep(3000);

            WebElement dropDown1 = driver.findElement(By.name("subject"));
            dropDown1.click();
            List<WebElement> options1 = dropDown1.findElements(By.tagName("option"));
            for (WebElement element : options1) {
                String dropDownValue = element.getText();
                if (dropDownValue.equals("Science")) {
                    element.click();
                    break;
                }
            }

            WebElement dropDown2 = driver.findElement(By.name("teacher_id"));
            dropDown2.click();

            List<WebElement> options = dropDown2.findElements(By.tagName("option"));
            for (WebElement element : options) {
                String dropDownValue = element.getText();
                if (dropDownValue.equals("Kosala Pushpakumara (Science)")) {
                    element.click();
                    break;
                }
            }

            WebElement email = driver.findElement(By.name("schedule"));
            email.sendKeys("Wed 5pm-4pm");
            Thread.sleep(3000);



            WebElement address = driver.findElement(By.name("fee"));
            address.sendKeys("2500.00");
            Thread.sleep(3000);

            WebElement addStudent=driver.findElement(By.name("add_class"));
            addStudent.click();
        }







    }


