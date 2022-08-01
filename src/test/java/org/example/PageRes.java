package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageRes {



        private WebDriver driver; // наш вебдрайвер
        private String[] fullWorld; // Массив для всех найденных слов

        private Resourses res; // класс с ресурсами

        public PageRes(WebDriver driver){                //Конструктор, берем вебдрайвер
            PageFactory.initElements(driver, this);
            this.driver = driver;
        }

        /////////////////////Поиск элементов//////////////////////////////////////////////
        @FindBy(id = "item-1") //Поиск по id элемента для перехода на страницу для теста
        private WebElement secondTest;

        @FindBy(className = "rct-checkbox") //поиск по классу элемента для выбора всего списка (Home)
        private WebElement element;

        @FindBy(className = "text-success") //Лист элементов для сравнения (Здесь берем все элементы одного класса которые отображаются в "You have selected"
        private List<WebElement> succeesElements;

        @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/ol/li/span/button")  // поиск по xpath открывалки списка Home
        private WebElement openHome;

        @FindBy(xpath = "//*[ @id=\"tree-node\"]/ol/li/ol/li[1]/span/label/span[1]") //поиск по xpath чекбокса Desctop
        private WebElement CheckDescktop;

        @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/label/span[1]")//поиск по xpath чекбокса Documents
        private WebElement checkDocuments;

        @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[1]")//поиск по xpath чекбокса Downloads
        private WebElement checkDownloads;

        @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button")//поиск по xpath открывалки списка Desctop
        private WebElement openDesktop;

        @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button")//поиск по xpath открывалки списка Documents
        private WebElement openDocuments;

        @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button")//поиск по xpath открывалки списка Workspase
        private WebElement openWorkSpace;

        @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button")//поиск по xpath открывалки списка Office
        private WebElement openOffice;

        @FindBy(xpath = "//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button")//поиск по xpath открывалки списка Downloads
        private WebElement openDownloads;

        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[1]/span/label/span[1]")//поиск по xpath чекбокса для Notes
        private WebElement notesChck;

        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label/span[1]")//поиск по xpath чекбокса для commands
        private WebElement commandsChck;

        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[1]/span/label/span[1]")//поиск по xpath чекбокса для react
        private WebElement reactChck;

        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[1]")//поиск по xpath чекбокса для angular
        private WebElement angularChck;

        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[3]/span/label/span[1]")//поиск по xpath чекбокса для vue
        private WebElement vueChck;

        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[1]/span/label/span[1]")//поиск по xpath чекбокса для public
        private WebElement publicChck;

        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[2]/span/label/span[1]")//поиск по xpath чекбокса для rrivate
        private WebElement privateChck;

        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/span/label/span[1]")//поиск по xpath чекбокса для glassfield
        private WebElement glassfieldsChck;

        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label/span[1]")//поиск по xpath чекбокса для general
        private WebElement generalChck;

        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[1]/span/label/span[1]")//поиск по xpath чекбокса для world
        private WebElement worldChck;


        @FindBy(xpath ="//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]")//поиск по xpath чекбокса для exel
        private WebElement exelChck;


        //////////Основные методы///////////////////////////
        public String returneString(List<WebElement> succesElements){//функция которая объеденяет все слова с сайта в одно слово и помещает в массив
            fullWorld = new String[succesElements.size()]; //Новый массив
            for (int i = 0; i < succesElements.size(); i ++){//цикл заполнения массива
                fullWorld[i]  = succesElements.get(i).getText();//Присавемаем элементу от i элемент из списка элементов на странице
            }
            String fullWorldString = String.join(" ", fullWorld); // Объединяем в слово
            return fullWorldString; // возвращаем стринговое слово
        }


        public void redirect(){ //переходим на страницу теста
            secondTest.click();
        }

        public String returnFinalString(int j, List<WebElement> succeesElements){// метод для сравнения j это то с какого слова начинаем сравнивать строку из массива ресурсов со строкой элементов на странице теста
            String[] stringArr = new String[succeesElements.size()];// выделяем память
            for (int i = j; i < succeesElements.size() + j; i++){//заполняем массив
                stringArr[i - j] = Resourses.elemsHome[i];//Присваем значение массиву
            }
            String fulString = String.join(" ", stringArr); //соединяем строку
            return fulString;// Возвращаем строку
        }


        public void checkOneElem(WebElement oneElem, int j){ //метод проверки элементов
            oneElem.click();//Тыкаем на нужный нам элемент
            Assertions.assertEquals(returnFinalString(j, succeesElements), returneString(succeesElements));//проверяем строку ответа и строку из массива от j
            oneElem.click();// Тыкаем на тот же элемент что бы его анчекнуть
        }

        public void selectAll(){ //метод проверки всего и вся
            element.click();//выбераем элемент который включает в себя все остальные элементы
            System.out.println(returneString(succeesElements)); //Дебаг
            String elemHomes = String.join(" ", Resourses.elemsHome);//оединяем строку из ресурсов
            Assertions.assertEquals(elemHomes, returneString(succeesElements));//Проверяем весь массив из ресурсов и элементы вернувшиеся на страницу
        }

        public void selectDesctop(){//роверяем что отобразится если тапнем на десктор
            element.click();//Клик
            openHome.click();//Открываем Home
            CheckDescktop.click();//Кликаем на десктоп
            System.out.println(returnFinalString(1, succeesElements));//Дебаг
            Assertions.assertEquals(returnFinalString(1,succeesElements), returneString(succeesElements));//Проверяем массив начиная со второго элемента со строкой на сайте
        }

        public void selectDocuments(){//Проверяем доки
            CheckDescktop.click();//Клик
            checkDocuments.click();//Клик
            System.out.println(returneString(succeesElements));//Дебаг
            Assertions.assertEquals(returnFinalString(4,succeesElements), returneString(succeesElements));//Проверяем массив начиная с 5 элемента со строкой на сайте

        }

        public void selectDownloads(){//Проверяем загрузки
            checkDocuments.click();//Клик
            checkDownloads.click();//Клик
            System.out.println(returneString(succeesElements));//Дебаг
            Assertions.assertEquals(returnFinalString(14,succeesElements), returneString(succeesElements));//Проверяем массив начиная с 15 элемента со строкой на сайте
        }

        public void openAllTree(){//Открываем все дерево с папками
            checkDownloads.click();
            openDownloads.click();
            openDesktop.click();
            openDocuments.click();
            openWorkSpace.click();
            openOffice.click();
        }

        public void checkOneCategory(){// проверяем каждую категорию Как раз функция чек ван элем
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

}
