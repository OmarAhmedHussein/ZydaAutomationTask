package projectHelpers;

import configurations.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DecimalFormat;

public class Helpers {


    public void hoverOnElement(WebElement element)
    {
        SeleniumBase base = new SeleniumBase();
        base.getChromeDriverWait().until(ExpectedConditions.visibilityOf(element));
        base.getChromeDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        Actions action = new Actions(base.getChromeDriver());
        action.moveToElement(element).perform();
    }

    public void clickOnElement(By element) {
        SeleniumBase base = new SeleniumBase();
        base.getChromeDriverWait().until(ExpectedConditions.visibilityOfElementLocated(element));
        base.getChromeDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        WebElement Element = base.getChromeDriver().findElement(element);
        Element.click();
    }

    public String getTextOfElement(By element)
    {
        SeleniumBase base = new SeleniumBase();
        base.getChromeDriverWait().until(ExpectedConditions.visibilityOfElementLocated(element));
        base.getChromeDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        WebElement Element = base.getChromeDriver().findElement(element);
        String Text = Element.getText().substring(1);
        System.out.println(Text);
        return Text;
    }

    public Float getFloatValue(String element)
    {
        Float floatValue = Float.valueOf(element);
        DecimalFormat DF = new DecimalFormat("0.00");
        DF.format(floatValue);
        return floatValue;
    }

}
