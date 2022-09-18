package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
//	Napisati program koji:
//		Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//		Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//		POMOC: Brisite elemente odozdo.
//		(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		boolean x = true;
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//*[@class='close']")).click();
		}
		try {
			driver.findElement(By.xpath("//*[@class='close']"));
		} catch (Exception e) {
			x = false;
		}
		if (x == true) {
			System.out.println("Polja su uklonjena");
		} else {
			System.out.println("Polja nisu uklonjena");

		}

		Thread.sleep(5000);
		driver.quit();
	}

}
