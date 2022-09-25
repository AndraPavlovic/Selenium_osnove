package d19_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Kreirati BootstrapTableTests klasu koja ima:
//Base url: https://s.bootsnipp.com
//Test #1: Edit Row
//Podaci:
//First Name: ime polaznika
//Last Name: prezime polaznika
//Middle Name: srednje ime polanzika
//Koraci:
//Ucitati stranu /iframe/K5yrx
//Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//Klik na Edit dugme prvog reda
//Sacekati da dijalog za Editovanje bude vidljiv
//Popuniti formu podacima. 
//Bice potrebno da pre unosa tekst pobrisete tekst koji vec postoji, za to se koristi metoda clear. Koristan link
//Klik na Update dugme
//Sacekati da dijalog za Editovanje postane nevidljiv
//Verifikovati da se u First Name celiji prvog reda tabele javlja uneto ime
//Verifikovati da se u Last Name celiji prvog reda tabele javlja uneto prezime
//Verifikovati da se u Middle Name celiji prvog reda tabele javlja uneto srednje ime
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske

public class BootstrapTableTest {
	WebDriver driver;
	WebDriverWait wait;
	private String baseUrl = "https://s.bootsnipp.com";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	 @Test (priority = 10)
		public void EditRow() {
			String firstName = "Andrija";
			String lastName = "Pavlovic";
			String middleName = "Mile";
			driver.get(baseUrl + "/iframe/K5yrx");
			Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
					"ERROR : Title is not valid");
			driver.findElement(By.xpath("//*[@id = 'd1']/td[5]/button")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id = 'up']")));
			driver.findElement(By.xpath("//*[@id = 'fn']")).clear();

			driver.findElement(By.xpath("//*[@id = 'fn']")).sendKeys(firstName);
			driver.findElement(By.xpath("//*[@id = 'ln']")).clear();
			driver.findElement(By.xpath("//*[@id = 'ln']")).sendKeys(lastName);
			driver.findElement(By.xpath("//*[@id = 'mn']")).clear();
			driver.findElement(By.xpath("//*[@id = 'mn']")).sendKeys(middleName);
			driver.findElement(By.xpath("//*[@id = 'up']")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id = 'up']")));
			Assert.assertEquals(driver.findElement(By.id("f1")).getText(), "Andrija", "ERROR: Invalid firstname");
			Assert.assertEquals(driver.findElement(By.id("l1")).getText(), "Pavlovic", "ERROR: Invalid lastname");
			Assert.assertEquals(driver.findElement(By.id("m1")).getText(), "Mile", "ERROR: Invalid middlename");
		}
//	 Test #2: Delete Row
//	 Podaci:
//	 First Name: ime polaznika
//	 Last Name: prezime polaznika
//	 Middle Name: srednje ime polanzika
//	 Koraci:
//	 Ucitati stranu /iframe/K5yrx
//	 Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	 Klik na Delete dugme prvog reda
//	 Sacekati da dijalog za brisanje bude vidljiv
//	 Klik na Delete dugme iz dijaloga 
//	 Sacekati da dijalog za Editovanje postane nevidljiv
//	 Verifikovati da je broj redova u tabeli za jedan manji
//	 Za sve validacije ispisati odgovarajuce poruke u slucaju greske
	 
	 @Test (priority = 20)
		public void DeleteRow() {
			String firstName = "Andrija";
			String lastName = "Pavlovic";
			String middleName = "Mile";
			List<WebElement> lista = driver.findElements(By.xpath("//*[@class = 'row']/table/tbody/tr"));
			driver.get(baseUrl + "/iframe/K5yrx");
			
			
			Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
					"ERROR: Title is not valid");
			
			driver.findElement(By.xpath("//*[@id = 'd1']/td[6]/button")).click();
			

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id = 'del']")));
			
			driver.findElement(By.xpath("//*[@id = 'del']")).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id = 'del']")));

			Assert.assertTrue(lista.size() < 2, "ERROR: Delete is not finished properly");
	}
//	 Test #3: Take a Screenshot
//	 Koraci:
//	 Ucitati stranu  /iframe/K5yrx
//	 Verifikovati naslov stranice Table with Edit and Update Data - Bootsnipp.com
//	 Kreirati screenshot stranice. Koristan link https://www.guru99.com/take-screenshot-selenium-webdriver.html
//	 Fajl cuvajte na putanji gde su vam bile slike od proslog domaceg. Na putanji: src/paket_za_domaci/nazivslike.png

			@Test(priority = 30)
			public void TakeAScreenshot() throws Exception {
				driver.get(baseUrl + "/iframe/K5yrx");
				Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
						"ERROR: Title is not valid");
				TakesScreenshot scrShot = ((TakesScreenshot) driver);
				
			
				File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
				File DestFile = new File("img/Screenshot.png");
					FileHandler.copy(SrcFile, DestFile);
				
			}
			@AfterClass
			public void after() {
			driver.quit();
		}
	}

