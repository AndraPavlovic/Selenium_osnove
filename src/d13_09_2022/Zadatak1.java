package d13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
//	Zadatak
//	Maksimizirati prozor
//	Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//	Prijavite se na sistem 
//	Username: Admin
//	Password: admin123
//	Cekanje od 5s
//	U input za pretragu iz navigacije unesite tekst Me
//	Kliknite na prvi rezultat pretrage (to ce biti Time)
//	Cekanje od 1s
//	Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//	Klinkite na logout
//	Cekanje od 5s
//	Zatvorite pretrazivac

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//*[@name = 'username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name = 'password']")).sendKeys("admin123");
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//*[@class = 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"))
				.click();
		driver.findElement(By.xpath("//*[@placeholder = 'Search']")).sendKeys("Me");
		driver.findElement(By.xpath("//*[@class = 'oxd-text oxd-text--span oxd-main-menu-item--name']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class = 'oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//*[@class = 'oxd-dropdown-menu']/li[last()]/a")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
