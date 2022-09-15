package d13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
//	Napisati program koji vrsi dodavanje 5 reda u tabelu. 
//	Maksimizirati prozor
//	Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//	Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji 
//	Klik na dugme Add New
//	Unesite name,departmant i phone (uvek iste vrednost)
//	Trazenje po name atributu
//	Kliknite na zeleno Add dugme. 
//	PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, delete ali zbog prirode reda neki dugmici se vide a neki ne. 
//	Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
//	Cekanje od 0.5s
//	Na kraju programa ugasite pretrazivac.

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		
		for (int i = 1; i <= 5; i++) {

			driver.findElement(By.xpath("//*[@class = 'btn btn-info add-new']")).click();
			driver.findElement(By.xpath("//*[@name = 'name']")).sendKeys("Andrija");
			driver.findElement(By.xpath("//*[@name = 'department']")).sendKeys("Administracija");
			driver.findElement(By.xpath("//*[@name = 'phone']")).sendKeys("54634z634");
			driver.findElement(By.xpath("//*[@class = 'table table-bordered']/tbody/tr[last()]/td[last()]/a")).click();
		
		Thread.sleep(500);
		}
		driver.quit();

	}

}
