package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//TopMenuPage koja pribavlja:
//metodu koja vraca WOMEN link iz glavnom menija
//metodu koja vraca DRESSES link iz glavnom menija
//metodu koja vraca T-SHIRTS link iz glavnom menija
//metodu koja vraca podmeni za WOMEN
//metodu koja vraca podmeni za DRESSES

public class TopMenuPage {
	WebDriver driver;
	WebDriverWait wait;

	public TopMenuPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getWomenLink() {
		return driver.findElement(By.xpath("//*[@id = 'block_top_menu']/ul/li[1]/a"));
	}

	public WebElement getDressesLink() {
		return driver.findElement(By.xpath("//*[@id = 'block_top_menu']/ul/li[2]/a"));
	}

	public WebElement getTShirtLink() {
		return driver.findElement(By.xpath("//*[@id = 'block_top_menu']/ul/li[3]/a"));
	}

	public void getScroolToTShirtElement() {
		new Actions(driver)
				.moveToElement(driver.findElement(
						By.xpath("//*[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]")))
				.perform();
	}

	public void getScroolToWomenElement() {
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@id = 'block_top_menu']/ul/li[1]")))
				.perform();
	}

	public WebElement getWomenSubMenu() {
		return driver.findElement(By.xpath("//*[@id = 'block_top_menu']/ul/li[1]/ul"));
	}

	public void getScroolToDressesElement() {
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@id = 'block_top_menu']/ul/li[2]")))
				.perform();
	}

	public WebElement getDressesSubMenu() {
		return driver.findElement(By.xpath("//*[@id = 'block_top_menu']/ul/li[2]/ul"));
	}

	public void waitForWomenToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]/ul")));
	}

	public void waitForDressesToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/ul")));
	}
}
