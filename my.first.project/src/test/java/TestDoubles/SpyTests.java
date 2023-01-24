package TestDoubles;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class SpyTests extends TestBase {
	@Test
	public void loggerIsCalledTwice() {
		// The Spy can record the internal behavior of the target object.
		var logger = new SpyLogger();
		var db = new DatabaseClient();
		var paymentService = new RealPaymentService(logger, db);

		// We know that zero will trigger the logger.
		var invoiceNumber = 0;

		paymentService.getAmount(invoiceNumber);
		paymentService.getAmount(invoiceNumber);

		assertTrue(logger.calledCount == 2);
	}

	public class SpyLogger implements Logger {

		public int calledCount;

		// The purpose of this Spy is to record calls to to the logger.
		@Override
		public void append(String text) {
			this.calledCount += 1;
		}
	}
}