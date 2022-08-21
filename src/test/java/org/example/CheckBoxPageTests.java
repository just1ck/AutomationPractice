package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPageTests {

    private static WebDriver driver;

    private static Resourses res;

    public CheckBoxPageTests(WebDriver driver) {
        PageFactory.initElements(driver, this);
        CheckBoxPageTests.driver = driver;
    }

    //////////Основные методы///////////////////////////

    //Функция которая объеденяет все элементы с сайта  строку
    public static String getActulResult(List<WebElement> elements) {
        var fullWord = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            fullWord[i] = elements.get(i).getText();
        }
        return String.join(" ", fullWord);
    }

    //Возвращает ожидаемый результат начиная с папки с номером start при выделенных amount элементах
    public static String getExpectedString(int start, int amount) {
        String[] stringArr = new String[amount];
        for (int i = 0; i < amount; i++) {
            stringArr[i] = Resourses.elemsHome[i + start];
        }
        return String.join(" ", stringArr);
    }


    public static void redirect() { //Проверка перехода на страницу теста
        secondTest.click();
    }


    //метод проверки одного элемента
    public static void checkOneElem(WebElement oneElem, int j) {
        oneElem.click();
        Assertions.assertEquals(getExpectedString(j, succeesElements.size()), getActulResult(succeesElements));
        oneElem.click();
    }

    //Раскрываем все дерево и проверяем все элементы
    public static void selectAll() {
        element.click();
        String elemHomes = String.join(" ", Resourses.elemsHome);
        Assertions.assertEquals(elemHomes, getActulResult(succeesElements));
    }

    //Проверяем что отобразится если тапнем на десктоп
    public static void selectDesctop() {
        element.click();
        openHome.click();
        CheckDescktop.click();
        Assertions.assertEquals(getExpectedString(1, succeesElements.size()), getActulResult(succeesElements));
    }

    //Проверяем что отобразится если тапнем на документы
    public static void selectDocuments() {
        CheckDescktop.click();
        checkDocuments.click();
        Assertions.assertEquals(getExpectedString(4, succeesElements.size()), getActulResult(succeesElements));

    }

    //Проверяем что отобразится если тапнем на загрузки
    public static void selectDownloads() {
        checkDocuments.click();
        checkDownloads.click();
        Assertions.assertEquals(getExpectedString(14, succeesElements.size()), getActulResult(succeesElements));
    }

    //Открываем все дерево с папками
    public static void openAllTree() {
        checkDownloads.click();
        openDownloads.click();
        openDesktop.click();
        openDocuments.click();
        openWorkSpace.click();
        openOffice.click();
    }

    //Проверяем каждую категорию
    public static void checkOneCategory() {
        checkOneElem(notesChck, 2);
        checkOneElem(commandsChck, 3);
        checkOneElem(reactChck, 6);
        checkOneElem(angularChck, 7);
        checkOneElem(vueChck, 8);
        checkOneElem(publicChck, 10);
        checkOneElem(privateChck, 11);
        checkOneElem(glassfieldsChck, 12);
        checkOneElem(generalChck, 13);
        checkOneElem(worldChck, 15);
        checkOneElem(exelChck, 16);

    }

    /////////////////////Поиск элементов//////////////////////////////////////////////
    @FindBy(id = "item-1") //Поиск по id элемента для перехода на страницу для теста
    private static WebElement secondTest;

    @FindBy(className = "rct-checkbox") //поиск по классу элемента для выбора всего списка (Home)
    private static WebElement element;

    @FindBy(className = "text-success")
    //Лист элементов для сравнения (Здесь берем все элементы одного класса которые отображаются в "You have selected"
    private static List<WebElement> succeesElements;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/ol/li/span/button")
    // поиск по xpath открывалки списка Home
    private static WebElement openHome;

    @FindBy(xpath = "//*[ @id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[1]") //поиск по xpath чекбокса Desctop
    private static WebElement CheckDescktop;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[1]")//поиск по xpath чекбокса Documents
    private static WebElement checkDocuments;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[1]")//поиск по xpath чекбокса Downloads
    private static WebElement checkDownloads;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")//поиск по xpath открывалки списка Desctop
    private static WebElement openDesktop;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")//поиск по xpath открывалки списка Documents
    private static WebElement openDocuments;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button")
    //поиск по xpath открывалки списка Workspase
    private static WebElement openWorkSpace;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button")
    //поиск по xpath открывалки списка Office
    private static WebElement openOffice;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button")//поиск по xpath открывалки списка Downloads
    private static WebElement openDownloads;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]")
    //поиск по xpath чекбокса для Notes
    private static WebElement notesChck;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label/span[1]")
    //поиск по xpath чекбокса для commands
    private static WebElement commandsChck;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[1]/span/label/span[1]")
    //поиск по xpath чекбокса для react
    private static WebElement reactChck;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[1]")
    //поиск по xpath чекбокса для angular
    private static WebElement angularChck;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[3]/span/label/span[1]")
    //поиск по xpath чекбокса для vue
    private static WebElement vueChck;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[1]/span/label/span[1]")
    //поиск по xpath чекбокса для public
    private static WebElement publicChck;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[2]/span/label/span[1]")
    //поиск по xpath чекбокса для rrivate
    private static WebElement privateChck;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/span/label/span[1]")
    //поиск по xpath чекбокса для glassfield
    private static WebElement glassfieldsChck;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label/span[1]")
    //поиск по xpath чекбокса для general
    private static WebElement generalChck;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[1]/span/label/span[1]")
    //поиск по xpath чекбокса для world
    private static WebElement worldChck;

    @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]")
    //поиск по xpath чекбокса для exel
    private static WebElement exelChck;

}
