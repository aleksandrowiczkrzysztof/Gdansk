import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
public static boolean waitForAjax(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {

					return true;
				}
			}
			};
			ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
							.equals("complete");
				}
			};

			return wait.until(jQueryLoad) && wait.until(jsLoad);
		}
	
		
public static void kliniecieOrder(WebDriver driver) {
	WebElement order = driver.findElement(By.xpath("//*[@id=\"responsive-menu\"]/li[9]/span"));
	order.click();
	
}
public static void kliknieciePlusa(WebDriver driver) {
	WebElement klikniecie = driver.findElement(By.xpath("//*[@id=\"fLiczbaOsob\"]/div/div/div[1]/div[2]/div/div/div[1]"));
	klikniecie.click();
}
public static void ustawComboNa72(WebDriver driver) {
	WebElement combo = driver.findElement(By.xpath("//*[@id=\"fFormularzOsob\"]/div[2]/table/tbody/tr/td[2]/div/select"));
	Select listaRozwiajana = new Select (combo);
	listaRozwiajana.selectByValue("135688");
}
public static String jakaKwota1(WebDriver driver) {
	WebElement kwota = driver.findElement(By.xpath("//*[@id=\"podsumowanie\"]/table/tbody/tr[2]/td[2]"));
	String kwota2 = kwota.getText();
	return kwota2;
}
public static String jakaKwota2(WebDriver driver) {
	WebElement kwota = driver.findElement(By.xpath("//*[@id=\"fFormularzOsob\"]/div[2]/table/tbody/tr[1]/td[3]/strong"));
	String kwota2 = kwota.getText();
	return kwota2;
}
}
/*public static void ustawComboNaLowersPrice(WebDriver driver) {
	WebElement combo = driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]"));
	Select listaRozwijana = new Select(combo);
	listaRozwijana.selectByValue("price:asc");*/
