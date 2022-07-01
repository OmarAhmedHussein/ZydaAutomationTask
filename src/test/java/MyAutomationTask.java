import configurations.SeleniumBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import projectHelpers.Helpers;
import projectHelpers.XPathUI;

import java.text.DecimalFormat;

public class MyAutomationTask {

    SeleniumBase base = new SeleniumBase();

    @BeforeTest
    public void openBrowser()
    {
        base.openBrowser("http://automationpractice.com/index.php");
        JavascriptExecutor Js1 = (JavascriptExecutor) base.getChromeDriver();
        Js1.executeScript("window.scrollBy(0,900)");
    }

    @Test
    public void selectItems() {
        XPathUI path = new XPathUI();
        Helpers help = new Helpers();

        //Hover on the first item
        WebElement FirstItem = base.getChromeDriver().findElement(path.firstItem);
        help.hoverOnElement(FirstItem);

        //Click on "Add to Cart" of the first item
        help.clickOnElement(path.clickOnFirstItem);

        //Click on "Continue Shopping"
        help.clickOnElement(path.clickOnContinueShopping);

        //Hover on the second item
        WebElement SecondItem = base.getChromeDriver().findElement(path.secondItem);
        help.hoverOnElement(SecondItem);

        //Click on "Add to Cart" of the second item
        help.clickOnElement(path.clickOnSecondItem);

        //Click on "Proceed to Checkout"
        help.clickOnElement(path.clickOnProceedToCheckout);

        
        //ASSERTIONS!!

        //Get the price of the first item
        String PriceOfFirstItem = help.getTextOfElement(path.priceOfFirstItem);
        //Get the price of the second item
        String PriceOfSecondItem = help.getTextOfElement(path.priceOfSecondItem);
        //Get the price of shipping
        String PriceOfShipping = help.getTextOfElement(path.priceOfShipping);

        //Convert String to Float
        float firstItem =    help.getFloatValue(PriceOfFirstItem);
        float secondItem =  help.getFloatValue(PriceOfSecondItem);
        float shippingPrice = help.getFloatValue(PriceOfShipping);

        //Get the expected Total amount
        DecimalFormat DF = new DecimalFormat("0.00");
        float expectedTotal = Float.parseFloat(DF.format(firstItem + secondItem + shippingPrice));

        //Get the actual total price
        String actTotal =  help.getTextOfElement(path.checkOnTotalPrice);
        float actualTotal = help.getFloatValue(actTotal);
        DF.format(actualTotal);

        //Compare between the actual & expected total price
        Assert.assertEquals(actualTotal,expectedTotal);

        //Check that the number of selected items is correct
        Integer numberOfSelectedElements = base.getChromeDriver().findElements(path.getNumberOfItems).size();
        Assert.assertEquals(2, numberOfSelectedElements);
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        base.closeBrowser();
    }

}
