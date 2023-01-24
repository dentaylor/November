import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductCategoryPage extends PageObject {

	public final String URL = "products/classic/";

	@FindBy(how=How.LINK_TEXT, using="SVT-410HLF")
	private WebElement productDetailLink;

	public ProductCategoryPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		setUrl(URL);
	}

	public ProductDetailPage clickProductDetailLink() {
		productDetailLink.click();		

		return new ProductDetailPage(this.driver, this.baseUrl);
	}

	public ProductCategoryPage navigateDirect() {
		navigateDirectUrl();

		return this;
	}

	public String getSvt410HlfHref() {
		return productDetailLink.getAttribute("href");
	}
}
