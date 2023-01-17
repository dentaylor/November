package TestDoubles;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class DummyTests extends TestBase {

	@Test
	public void canGetAmount() {
		var logger = new LoggerDummy(); 
		var db = new DatabaseClient();
		var paymentService = new RealPaymentService(logger, db);
		var invoiceNumber = Any.positiveInteger();

		var amount = paymentService.getAmount(invoiceNumber);

		assertTrue(amount > 0);
	}

	public class LoggerDummy implements Logger {

		@Override
		public void append(String text) {
			// Dummies should throw an exception if they are called.
			throw new RuntimeException("should not call dummy!");
		}
	}
}
