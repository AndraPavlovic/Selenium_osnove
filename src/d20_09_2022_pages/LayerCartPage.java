package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//LayerCartPage koja pribavlja:
//continue shopping dugme
//proced to checkout dugme
//element koji vraca atrubute
// proizvoda (sa slike je to desno od devojke)
//element koji cuva quantity
//(takodje desno od devojke)
//element koji cuva total price
//metodu koja ceka da dijalog bude vidljiv
//metodu koja ceka da dijalog bude nevidljiv

public class LayerCartPage {

	WebDriver driver;
	private WebDriverWait wait;

	public LayerCartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getContinueShopingButton() {
		return driver.findElement(By.xpath("//*[contains(@class , 'continue btn')]"));
	}

	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.xpath("//*[contains(text() , 'Proceed to checkout')]"));
	}

	public WebElement getAttributeProduct() {
		return driver.findElement(By.xpath("//*[@class = 'layer_cart_product_info']"));
	}

	public WebElement getQuantityShop() {
		return driver.findElement(By.xpath("//*[@id = 'layer_cart_product_quantity']"));
	}

	public WebElement getTotalPrice() {
		return driver.findElement(By.id("layer_cart_product_price"));
	}

	public void waitForDialogToBeVisible() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@class = 'layer_cart_product col-xs-12 col-md-6']")));
	}

	public void waitForDialogToBeInvisible() {
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class = 'layer_cart_product col-xs-12 col-md-6']")));
	}
}
