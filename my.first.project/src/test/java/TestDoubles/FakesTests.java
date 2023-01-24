package TestDoubles;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class FakesTests extends TestBase {

	@Test
	public void canGetAmount() {
		var logger = new RealLogger(); 
		var db = new FakeDatabaseClient();
		var paymentService = new RealPaymentService(logger, db);
		var invoiceNumber = Any.positiveInteger();

		var amount = paymentService.getAmount(invoiceNumber);

		assertTrue(amount > 0);
	}
}
