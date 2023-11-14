package ru.netology.test;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.CardInfo;
import ru.netology.data.SQLHelper;
import ru.netology.page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;

public class PaymentTest {
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
    void shouldValidActiveCard() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).paymentApprovedForm();
        Assertions.assertEquals("APPROVED", SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldDeclinedCard() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getDeclinedCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).paymentDeclinedForm();
        Assertions.assertEquals("DECLINED", SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldZeroNumber() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getZeroNumberCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).cardNumberWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldIncompleteNumber() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getIncompleteNumberCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).cardNumberWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void should13Month() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getMore12Month(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).monthInvalidCardDate();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldPreviousYear() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getPreviousYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).yearInvalidCardDate();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldCyrillicOwner() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getCyrillicOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).ownerWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldNumeralOwner() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getNumeralOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).ownerWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldSymbolOwner() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getSymbolOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).ownerWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldTwoNumeralsCVC() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getTwoNumeralsCVC());
        mainPage.paymentButton().paymentForm(card).cvcWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldEmptyOwner() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getEmptyOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).ownerEmptyForm();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldEmptyNumber() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getEmptyNumberCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).cardNumberWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldEmptyMonth() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getEmptyMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).monthWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }


    @Test
    void shouldEmptyYear() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getEmptyYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).yearWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }


    @Test
    void shouldEmptyCVC() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getEmptyCVC());
        mainPage.paymentButton().paymentForm(card).cvcWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldZeroNumberCVC() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getCurrentYear(), getCurrentOwner(), getZeroNumberCVC());
        mainPage.paymentButton().paymentForm(card).cvcWrongFormat();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }


    @Test
    void shouldZeroYear() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getCurrentMonth(), getZeroYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).yearInvalidCardDate();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

    @Test
    void shouldZeroMonth() {
        var mainPage = new MainPage();
        CardInfo card = new CardInfo(getActiveCard(), getZeroMonth(), getCurrentYear(), getCurrentOwner(), getCurrentCVC());
        mainPage.paymentButton().paymentForm(card).monthInvalidCardDate();
        Assertions.assertNull(SQLHelper.getPaymentStatus().getCode());
    }

}