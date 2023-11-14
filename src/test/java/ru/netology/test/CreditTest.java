package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.CardInfo;
import ru.netology.data.SQLHelper;
import ru.netology.page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;

public class CreditTest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
        SQLHelper.clearBD();
    }

    @Test
    void shouldCreditValidActiveCard() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).creditApprovedForm();
        Assertions.assertEquals("APPROVED", SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditDeclinedCard() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getDeclinedCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).creditDeclinedForm();
        Assertions.assertEquals("DECLINED", SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditZeroNumber() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getZeroNumberCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).cardNumberWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldIncompleteNumber() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getIncompleteNumberCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).cardNumberWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCredit13Month() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getMore12Month(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).monthInvalidCardDate();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditPreviousYear() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getPreviousYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).yearInvalidCardDate();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditCyrillicOwner() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getCyrillicOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).ownerWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditNumeralOwner() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getNumeralOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).ownerWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }


    @Test
    void shouldCreditSymbolOwner() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getSymbolOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).ownerWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditTwoNumeralsCVC() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getTwoNumeralsCVC());
        mainPage.creditButton().creditForm(card).cvcWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditEmptyOwner() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getEmptyOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).ownerEmptyForm();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditEmptyNumber() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getEmptyNumberCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).cardNumberWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }


    @Test
    void shouldCreditEmptyMonth() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getEmptyMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).monthWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditEmptyYear() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getEmptyYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).yearWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditEmptyCVC() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getEmptyCVC());
        mainPage.creditButton().creditForm(card).cvcWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

    @Test
    void shouldCreditZeroMonth() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getZeroMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).monthInvalidCardDate();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }


    @Test
    void shouldCreditZeroYear() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getZeroYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.creditButton().creditForm(card).yearInvalidCardDate();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }


    @Test
    void shouldCreditZeroNumberCVC() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getZeroNumberCVC());
        mainPage.creditButton().creditForm(card).cvcWrongFormat();
        Assertions.assertNull(SQLHelper.getCreditStatus().getCode());
    }

}
