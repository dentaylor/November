import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {

	public HomePage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public ProductDirectoryPage clickProductsLink() {
		var menuLink = this.driver.findElement(By.cssSelector("a[title='Products']"));
		menuLink.click();	
		
		return new ProductDirectoryPage(this.driver, this.baseUrl);
	}
}
