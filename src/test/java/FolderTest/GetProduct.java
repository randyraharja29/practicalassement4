package FolderTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;

public class GetProduct extends BaseTest{
    @Test
    public void addProduct (){
        WebElement laptopLink = driver.get().findElement(By.xpath("//a[.='Laptops']"));
        laptopLink.click();

        WebElement firstItem = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Sony vaio i5']")));
        firstItem.click();

        WebElement addToCartButton = explicitWait.get().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[.='Add to cart']")
                )
        );
        addToCartButton.click();

        explicitWait.get().until(ExpectedConditions.alertIsPresent());

        driver.get().switchTo().alert().accept();

        driver.get().findElement(By.id("cartur")).click();

        WebElement productName = explicitWait.get().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//td[.='Sony vaio i5']")
                )
        );

        Assert.assertTrue(productName.getText().contains("Sony vaio i5"), "Product does not found");


    }
}

