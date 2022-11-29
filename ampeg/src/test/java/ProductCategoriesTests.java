import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ProductCategoriesTests extends AmpegTests {
	@Test
	public void canDirectlyNavigateToProductCategoryPage() {
		var baseUrl = "https://ampeg.com/";
		var expectedUrl = baseUrl + "products/classic/";

		new ProductCategoryPage(this.driver, baseUrl).navigateDirect();

		var url = this.driver.getCurrentUrl();

		assertEquals(url, expectedUrl, "should navigate directly to the page.");
	}

	@Test
	public void verifyProductLinkUrl() {
		var baseUrl = "https://ampeg.com/";
		var expectedUrl = baseUrl + "products/classic/svt410hlf/";

		var url = new ProductCategoryPage(this.driver, baseUrl)
				.navigateDirect()
				.getSvt410HlfHref();

		assertEquals(url, expectedUrl, "the link should match as expected.");
	}
}
