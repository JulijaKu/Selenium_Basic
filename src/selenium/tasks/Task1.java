package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import java.io.File;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        String expectedError = "Please enter a number";
        String expectedErrorSelector = "#ch1_error";
        String inputFieldSelector = "#numb";
        String text = "dsd";
        String submitSelector = "w3-btn";

        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        WebElement submit =driver.findElement(By.className("w3-btn"));

        inputField.sendKeys(text);
        submit.click();
        assertEquals("Please enter a number", error.getText());

    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        String expectedError = "Number is too small";
        String expectedErrorSelector = "#ch1_error";
        String inputFieldSelector = "#numb";
        String text = "45";
        String submitSelector = "w3-btn";

        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        WebElement submit =driver.findElement(By.className("w3-btn"));

        inputField.sendKeys(text);
        submit.click();
        assertEquals("Number is too small", error.getText());

    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        String expectedError = "Number is too big";
        String expectedErrorSelector = "#ch1_error";
        String inputFieldSelector = "#numb";
        String text = "150";
        String submitSelector = "w3-btn";

        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        WebElement submit =driver.findElement(By.className("w3-btn"));

        inputField.sendKeys(text);
        submit.click();
        assertEquals("Number is too big", error.getText());

    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly

        int squareRootWithRemainder = 64;
        String expectedAnswer = "Square root of 64 is 8.00";
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-btn"));

        inputField.sendKeys(Integer.toString(squareRootWithRemainder));

        submit.click();
        Alert alert = driver.switchTo().alert();
        assertEquals(expectedAnswer,alert.getText());
        alert.accept();

    }
    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        int squareRootWithRemainder = 70;
        String expectedAnswer = "Square root of 70 is 8.37";
        WebElement inputField = driver.findElement(By.id("numb"));
        WebElement submit = driver.findElement(By.className("w3-btn"));

        inputField.sendKeys(Integer.toString(squareRootWithRemainder));

        submit.click();
        Alert alert = driver.switchTo().alert();
        assertEquals(expectedAnswer,alert.getText());
        alert.accept();
    }
}
