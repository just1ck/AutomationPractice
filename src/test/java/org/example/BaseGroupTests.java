package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseGroupTests {
    protected JavascriptExecutor jse;
    protected WebDriver driver = null;//Создаем объект драйвера;

    @BeforeAll
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();//Объявляем драйвер
        jse = (JavascriptExecutor) driver;
        driver.manage().window().maximize();//Браузер на полное окно
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//Тайминги
        driver.get("https://demoqa.com/checkbox");//Открываем наш сайт
    }

    @AfterAll
    public void closeBrowser(){
        driver.close();
    }
}
