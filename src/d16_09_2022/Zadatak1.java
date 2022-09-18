package d16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {
//	Napisati program koji ima:
//		Podesava:
//		implicitno cekanje za trazenje elemenata od 10s
//		implicitno cekanje za ucitavanje stranice od 10s
//		eksplicitno cekanje podeseno na 10s
//		Podaci:
//		Potrebno je u projektu ukljuciti 4 slike.
//		Imenovanje slika neka bude po pravilu pozicija_ime_prezime_polaznika.ekstenzija
//		Npr: front_milan_jovanovic.jpg, left_milan_jovanovic.jpg …
//		Koraci:
//		Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//		Maksimizuje prozor
//		Selektuje Image - Front klikom na tu karticu u dnu ekrana
//		Klik na add photo iz levog navigacionog menia
//		Upload slike. Upload preko File objekta koristeci getAbsolutePath
//		Sacekati da broj prikazanih slika u donjem uglu navigacije bude za 1 veca
//		Kliknuti na poslednje dodatu sliku kako bi bila izabrana za postavljanje
//		Ceka da dijalog bude vidljiv
//		Klik na Use One Side Only dugme
//		Ceka da se pojavi dijalog sa slikom
//		Klik na Done
//		Ponoviti proces za Left, Right i Back
//		Zatim iz desnog gornjeg ugla izabrati random jedan od ponudjenih konfeta
//		Kliknuti na Add To Cart dugme
//		Verifikovati postojanje greske Oops! It looks like you`ve not added an text to this field, please add one before continuing.
//		Xpath: //*[@action='error']
//		Zatvorite pretrazivac

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Random r = new Random();

		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");

		List<WebElement> pozicija = driver.findElements(By.xpath("//*[contains(@class, 'iltlXU')]/div"));
		ArrayList<String> slike = new ArrayList<String>();
		slike.add("img/front_andrija_pavlovic.jpg");
		slike.add("img/back_andrij_pavlovic.jpg");
		slike.add("imgs/right_andrija_pavlovic.jpg");
		slike.add("imgs/left_andrija_pavlovic.jpg");

		for (int i = 1; i < 5; i++) {
			pozicija.get(i - 1).click();
			driver.findElement(By.xpath("//*[text()='+ Add photo']")).click();
			driver.findElement(By.id("imageUpload")).sendKeys(new File(slike.get(i - 1)).getAbsolutePath());

			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[contains(@class, 'fqhTDx')]/div[" + i + "]")));

			driver.findElement(By.xpath("//*[contains(@class, 'fqhTDx')]/div[" + i + "]//img")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gMENHs")));

			driver.findElement(By.xpath("//*[text()='Use One Side Only']")).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'reactEasyCrop_Container')]")));

			driver.findElement(By.xpath("//*[text()='Done']")).click();
		}
		List<WebElement> konfete = driver.findElements(By.xpath("//*[contains(@class, 'kFlYLE')]/div"));

		konfete.get(r.nextInt(konfete.size())).click();

		driver.findElement(By.className("gNSlAh")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@action='error']")));
		System.out.println("Greska!");
		Thread.sleep(5000);
		driver.quit();

	}

}
