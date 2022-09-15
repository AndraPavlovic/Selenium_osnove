package d13_09_2022;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
//	Maksimizirati prozor
//	Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
//	Dohvatite dugmice za rejting kao listu. XPath za trazenje treba da bude preko id atributa i za ovo trebace vam contains u xpath-u
//	Od korisnika ucitati broj (preko scannera) na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
//	I izvrsite akciju klik na odgovarajuci element preko indeksa
//	Na kraju programa ugasite pretrazivac.

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://s.bootsnipp.com/iframe/WaXlr");
		List<WebElement> elementi = driver.findElements(By.xpath("//*[contains(@id , 'rating-star')]"));
		Scanner s = new Scanner(System.in);
		System.out.println("Unesite broj: ");
		int broj = s.nextInt();
		if (broj < 1) {
			broj = 1;
		}
		elementi.get(broj - 1).click();

		Thread.sleep(5000);
		driver.quit();
	}

}
