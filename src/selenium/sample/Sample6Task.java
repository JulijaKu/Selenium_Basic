package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Sample6Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text of element with id '//*[@id=\"test1\"]/p[1]' is '" +
                driver.findElement(By.xpath("//*[@id=\"test1\"]/p[1]")).getText() + "'");
//        1-2 ways to find text: "Test Text 2"
        System.out.println("\t text is '//p[@class='twoTest']\"test1\"]/p[2]' check it" +
                driver.findElement(By.xpath("//p[@class='twoTest']\"test1\"]/p[2]")).getText() + "'");
//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t text of element with id '//*[@id=\"test3\"]/p[1]' is '" +
                driver.findElement(By.xpath("//*[@id=\"test3\"]/p[1]")).getText() + "'");
//      1-2 ways to find text: "Test Text 4"
        System.out.println("\t text of element with id '//*[@id=\"test3\"]/p[2]' is '" +
                driver.findElement(By.xpath("//*[@id=\"test3\"]/p[2]")).getText() + "'");
//        1-2 ways to find text: "Test Text 5"
        System.out.println("\t text of element with id '//*[@id=\"test2\"]/p[1]' is '" +
                driver.findElement(By.xpath("//*[@id=\"test2\"]/p[1]")).getText() + "'");
//       1-2 ways to find text: "This is also a button"
        System.out.println("\t text of element with id 'buttonId' is'" +
                driver.findElements(By.xpath("//*[@id=buttonId']")));

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.cssSelector("#header_2")).getText() + "'");
//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text of element with class 'test' is '" +
                driver.findElement(By.cssSelector(".test")).getText() + "'");
        //        1-2 ways to find text: "Test Text 2"
        System.out.println("\t text of element with class 'twoTest' is '" +
                driver.findElement(By.cssSelector(".twoTest")).getText() + "'");
        //        1-2 ways to find text: "Test Text 3"
        //        1-2 ways to find text: "This is also a button"
        System.out.println("\t text of element with id 'buttonID' is '" +
                driver.findElement(By.cssSelector("#buttonId")).getText() + "'");

    }


}



