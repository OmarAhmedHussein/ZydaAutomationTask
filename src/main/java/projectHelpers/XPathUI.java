package projectHelpers;

import org.openqa.selenium.By;

public class XPathUI
{
    public By firstItem = By.xpath("//*[@alt ='Faded Short Sleeve T-shirts']");
    public By clickOnFirstItem = By.xpath("(//*[@data-id-product='1'])[1]/span");
    public By clickOnContinueShopping = By.xpath("//*[@title='Continue shopping']");
    public By secondItem = By.xpath("(//*[@alt ='Blouse'])[1]");
    public By clickOnSecondItem = By.xpath("(//*[@data-id-product='2'])[1]/span");
    public By clickOnProceedToCheckout = By.xpath("//*[@title='Proceed to checkout']");

    //For assertions :
    public By checkOnTotalPrice = By.xpath("//*[@id = 'total_price_container']");
    public By priceOfFirstItem = By.xpath("//*[@id='product_price_1_1_0']");
    public By priceOfSecondItem = By.xpath("//*[@id='product_price_2_7_0']");
    public By priceOfShipping = By.xpath("//*[@id='total_shipping']");
    public By getNumberOfItems = By.xpath("//*[contains(@type,'sub')]");
}
