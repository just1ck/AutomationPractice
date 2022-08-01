package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)//Метод сортировки тестов
public class PageTests {

    public static PageRes pageRes;//Создаем переменнуюж класса

    @BeforeAll
    public static void Setup(){//Предустановки
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe"); //Объявляем драйвер
        WebDriver driver = new ChromeDriver();//Создаем объект драйвера
        pageRes = new PageRes(driver);//Создаем объект класса pageRes
        driver.manage().window().maximize();//Браузер на полное окно
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//Тайминги
        driver.get("https://demoqa.com/checkbox");//Открываем наш сайт
    }

    @Order(1)//Номер теста
    @Test
    public void Redirect(){
        pageRes.redirect();//Тапаем на страничку где наш тест
    }

    @Order(2)//Номер теста
    @Test
    public void selectAllElems(){
        pageRes.selectAll(); //Вызываем метод из pageREs
    }

    @Order(3)//Номер теста
    @Test
    public void selectDesctop(){
        pageRes.selectDesctop();//Вызываем метод из pageREs
    }

    @Order(4)//Номер теста
    @Test
    public void selectDocuments(){
        pageRes.selectDocuments();//Вызываем метод из pageREs
    }

    @Order(5)//Номер теста
    @Test
    public void selectDownloads(){
        pageRes.selectDownloads();//Вызываем метод из pageREs
    }

    @Order(6)//Номер теста
    @Test
    public void selectAllTree(){
        pageRes.openAllTree();//Вызываем метод из pageREs
    }

    @Order(7)//Номер теста
    @Test
    public void selectOneCategory(){
        pageRes.checkOneCategory();//Вызываем метод из pageREs
    }


}
