package org.example;

import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSuits extends BaseGroupTests {

    private CheckBoxPageTests checkBoxPageTests;
    private RadioButtonsPageTests radioButtonsPageTests;

    @BeforeAll
    public void setup(){
        super.setup();
        checkBoxPageTests = new CheckBoxPageTests(driver);
        radioButtonsPageTests = new RadioButtonsPageTests(driver, jse);
    }

    @Order(1)
    @Test
    public void checkBoxSuit(){
        CheckBoxPageTests.selectAll();
        CheckBoxPageTests.selectDesctop();
        CheckBoxPageTests.selectDocuments();
        CheckBoxPageTests.selectDownloads();
        CheckBoxPageTests.openAllTree();
        CheckBoxPageTests.checkOneCategory();
    }

    @Order(2)
    @Test
    public void radioButtonSuit(){
        RadioButtonsPageTests.redirect();
        RadioButtonsPageTests.checkYesRadio();
        RadioButtonsPageTests.checkImpresiveRadio();
        RadioButtonsPageTests.checkNoRadio();
    }
}
