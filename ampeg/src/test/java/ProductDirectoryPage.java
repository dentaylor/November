import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDirectoryPage extends PageObject {

	public ProductDirectoryPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		setUrl("products/");
	}

	public ProductCategoryPage clickClassicBassHeadsAndEnclosuresLink() {
		var productLink = this.driver.findElement(By.cssSelector("img[alt='Classic Series: Bass heads & enclosures']"));
		productLink.click();	

		return new ProductCategoryPage(this.driver, this.baseUrl);
	}
}
