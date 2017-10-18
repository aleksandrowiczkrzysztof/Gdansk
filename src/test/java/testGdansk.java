import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testGdansk {
	private WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://kartaturysty.visitgdansk.com/");}
@Test 
public void testCeny() {
	Utils.kliniecieOrder(driver);
	Utils.kliknieciePlusa(driver);
	Utils.waitForAjax(driver);
	Utils.ustawComboNa72(driver);
	Utils.waitForAjax(driver);
	assertEquals(Utils.jakaKwota1(driver), Utils.jakaKwota2(driver));
}
}
