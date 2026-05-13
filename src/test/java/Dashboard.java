import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Dashboard {

    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void OpenTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/index.php");
        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test
    public void buttonTest() throws InterruptedException {

        Thread.sleep(3000);
        WebElement view = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/a"));
        view.click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);

        WebElement manage = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/a"));
        manage.click();
        Thread.sleep(3000);
        driver.navigate().back();


    }

    @Test
    public void scrollTest() throws InterruptedException {

        Thread.sleep(3000);
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        jsExecutor.executeScript("window.scrollTo(0,0)");
        Thread.sleep(3000);


    }

    @Test
    public void recent_enrollmentTableTest() {

        int rowCount = driver.findElements(
                By.xpath("/html/body/div[2]/div[3]/div[1]/table/tbody/tr")).size();
        System.out.println("Rows count is: " + rowCount);


        int columnCount = driver.findElements(
                By.xpath("/html/body/div[2]/div[3]/div[1]/table/thead/tr/th")).size();
        System.out.println("Column count is: " + columnCount);


        String value = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/table/tbody/tr[3]")).getText();
        System.out.println("Specified row/column data" + value);

    }


    @Test
    public void Classes_OverviewTableTest() {

        int rowCount = driver.findElements(
                By.xpath("/html/body/div[2]/div[4]/table/tbody/tr")).size();
        System.out.println("Rows count is: " + rowCount);


        int columnCount = driver.findElements(
                By.xpath("/html/body/div[2]/div[4]/table/thead/tr/th")).size();
        System.out.println("Column count is: " + columnCount);


        String value = driver.findElement(By.xpath("/html/body/div[2]/div[4]/table/tbody/tr[3]")).getText();
        System.out.println("Specified row/column data" + value);

    }

    @Test
    public void screenshot() throws IOException {

        WebElement section = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]"));
        File sourceFile = section.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("C:\\Users\\oshan\\IdeaProjects\\QA-Testing\\Screenshots\\Section_" + System.currentTimeMillis() + ".png");
        Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
    }
}