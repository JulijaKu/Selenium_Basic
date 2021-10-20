package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.AgeSamplePage;
import selenium.pages.AgeSubmittedSamplePage;
import selenium.pages.FeedbackPage;


import java.io.File;

public class Task2 {
    WebDriver driver;
    static FeedbackPage feedbackPage;


    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        feedbackPage = PageFactory.initElements(driver, FeedbackPage.class);


    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
        feedbackPage = PageFactory.initElements(driver, FeedbackPage.class);

//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
        feedbackPage.sendKeysName("");
        feedbackPage.sendKeysAge(0);
        feedbackPage.selectLanguageCheckBox("");
        feedbackPage.selectGender("");
        feedbackPage.HowDoYouLikeUs("");
        feedbackPage.commentInput("Good");
        feedbackPage.sendButton();
        feedbackPage.checkSendYesNoButtonColor("rgba(33, 150, 243, 1)");
        feedbackPage.checkSendYesNoButtonColor("rgba(255, 255, 255, 1)");
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
        feedbackPage.sendKeysName("");
        feedbackPage.sendKeysAge(0);
        feedbackPage.selectLanguageCheckBox("");
        feedbackPage.selectGender("");
        feedbackPage.HowDoYouLikeUs("");
        feedbackPage.commentInput("Good");
        feedbackPage.sendButton();
        feedbackPage.checkSendYesNoButtonColor("rgba (76, 175, 80, 1)");
        feedbackPage.checkSendYesNoButtonColor("rgba (255, 255, 255, 1)");
        feedbackPage.checkSendYesNoButtonColor("rgba (244, 67, 54, 1)");
        feedbackPage.checkSendYesNoButtonColor("rgba (255, 255, 255, 1)");
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
        feedbackPage.sendKeysName("Julija");
        feedbackPage.sendKeysAge(35);
        feedbackPage.selectLanguageCheckBox("French");
        feedbackPage.selectGender("Female");
        feedbackPage.HowDoYouLikeUs("Good");
        feedbackPage.commentInput("Message");
        feedbackPage.sendButton();
        feedbackPage.checkSendYesNoButtonColor("rgba (76, 175, 80, 1)");
        feedbackPage.checkSendYesNoButtonColor("rgba (255, 255, 255, 1)");
        feedbackPage.checkSendYesNoButtonColor("rgba (244, 67, 54, 1)");
        feedbackPage.checkSendYesNoButtonColor("rgba (255, 255, 255, 1)");
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
        feedbackPage.sendKeysName("Julija");
        feedbackPage.sendButton();
        feedbackPage.yesButton();
        feedbackPage.checkMsgColor("rgba(255, 255, 255, 1)");
        feedbackPage.checkMsgColor("rgba(76, 175, 80, 1)");


    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        feedbackPage.sendButton();
        feedbackPage.yesButton();
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
        feedbackPage.sendKeysName("Julija");
        feedbackPage.sendKeysAge(35);
        feedbackPage.selectLanguageCheckBox("French");
        feedbackPage.selectGender("Female");
        feedbackPage.HowDoYouLikeUs("Good");
        feedbackPage.commentInput("Message");
        feedbackPage.sendButton();



    }
}
