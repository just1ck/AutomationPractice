package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RadioButtonsPageTests {

        public WebDriver driver;

        public static JavascriptExecutor jse;

        public RadioButtonsPageTests(WebDriver driver, JavascriptExecutor jse){
            PageFactory.initElements(driver, this);
            PageFactory.initElements((SearchContext) jse, this);
            this.jse = jse;
            this.driver = driver;
        }

        public static void redirect(){
            redirect.click();
        }
        public static void checkYesRadio(){
            yesRadio.click();
            Assertions.assertEquals(textSuccess.getText(), "Yes");
        }

        public static void checkImpresiveRadio(){
            impressiveRadio.click();
            Assertions.assertEquals(textSuccess.getText(), "Impressive");

        }

        public static void checkNoRadio(){
            jse.executeScript("document.getElementById(\"noRadio\").disabled=0");
            noRadio.click();
            Assertions.assertEquals(textSuccess.getText(), "Impressive");
        }


    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label")
    private static WebElement yesRadio;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label")
    private static WebElement impressiveRadio;

    @FindBy(className = "text-success")
    private static WebElement textSuccess;

    @FindBy(id = "item-2")
    private static WebElement redirect;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[4]/label")
    private static WebElement noRadio;

}
