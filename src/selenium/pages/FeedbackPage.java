package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import static  org.junit.Assert.*;

import java.util.List;

public class FeedbackPage extends GenericSamplePage {
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageInput;
    @FindBy(how = How.CLASS_NAME, using = "w3-check")
    private List<WebElement> selectLanguage;
    private WebElement checkBoxChinese;
    @FindBy(how = How.CSS, using = "[type='radio'][name='gender']")
    private List<WebElement> radioButtonGender;
    @FindBy(how = How.CLASS_NAME, using = "w3-select")
    private List<WebElement> howDoYouLikeUs;
    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentInput;
    @FindBy(how = How.CSS, using = "[type= 'submit']")
    private WebElement sendButton;
    @FindBy(how = How.CLASS_NAME, using = "w3-green")
    private WebElement yesButton;
    @FindBy(how = How.CLASS_NAME, using = "w3-red")
    private WebElement noButton;

    public void sendKeysName(String value) {
        nameInput.clear();
        nameInput.sendKeys();
    }

    public void sendKeysAge(int value) {
        ageInput.clear();
        ageInput.sendKeys();
    }

    public void selectLanguageCheckBox(String option) {
        switch (option) {
            case "English":
                getSelectLanguage().get(0).click();
                break;
            case "French":
                getSelectLanguage().get(1).click();
                break;
            case "Spanish":
                getSelectLanguage().get(2).click();
                break;
            case "Chinese":
                getSelectLanguage().get(3).click();
                break;
        }
    }

    public void selectGender(String value) {
        switch (value) {
            case "Male":
                getRadioButtonGender().get(0).click();
                break;

            case "Female":
                getRadioButtonGender().get(1).click();
                break;


        }
    }

    public void HowDoYouLikeUs(String value) {
        switch (value) {
            case "Good":
                getHowDoYouLikeUs().get(1).click();
                break;

            case "Ok,I guess":
                getHowDoYouLikeUs().get(2).click();
                break;

            case "Bad":
                getHowDoYouLikeUs().get(3).click();
                break;

            case "Why me":
                getHowDoYouLikeUs().get(4).click();
                break;
        }
    }

    public void commentInput(String value) {
        commentInput.clear();
        commentInput.sendKeys(value);
    }

    public void sendButton() {
        sendButton.click();
    }
    public void yesButton(){
        yesButton.click();
    }
    public void noButton(){
        noButton.click();
    }

    public void checkSendYesNoButtonColor() {
        assertEquals("", sendButton.getCssValue("color"));
        assertEquals("", sendButton.getCssValue("background-color"));
    }
    public void checkMsgColor() {
        assertEquals("", sendButton.getCssValue("color"));
        assertEquals("", sendButton.getCssValue("background-color"));

    }

    public void initialFeedbackPageTest() {
        assertEquals("", getNameInput().getText());
        assertEquals("", getAgeInput().getText());
        assertFalse(selectLanguage.get(0).isSelected());
        assertFalse(selectLanguage.get(1).isSelected());
        assertFalse(selectLanguage.get(2).isSelected());
        assertFalse(selectLanguage.get(3).isSelected());
        assertFalse(radioButtonGender.get(0).isSelected());
        assertFalse(radioButtonGender.get(1).isSelected());
        assertTrue(radioButtonGender.get(2).isSelected());
        assertEquals("Choose your option", getHowDoYouLikeUs().get(0).getText());

    }

    public void checkIsSelected(WebElement e) {
        assertTrue(e.isSelected());
    }

    public void checkFormAfterNoButton() {
        System.out.println("nameInput.getText() =" + nameInput.getText());
    }

    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getAgeInput() {
        return ageInput;
    }

    public List<WebElement> getSelectLanguage() {
        return selectLanguage;
    }

    public List<WebElement> getHowDoYouLikeUs() {
        return howDoYouLikeUs;
    }

    public List<WebElement> getRadioButtonGender() {
        return radioButtonGender;
    }

    public WebElement getCommentInput() {
        return commentInput;
    }

    public WebElement getSendButton() {
        return sendButton;
    }
    public WebElement getYesButton(){
        return yesButton;
    }
    public WebElement getNoButton(){
        return noButton;
    }
}


