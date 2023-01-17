package TestDoubles;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class StubTests extends TestBase {
	
	// Stubbing out PaymentService so we can finish writing the tests.
	// PaymentService should be replaced at a later time.
	@Test
	public void canDoStuff() {
		var paymentService = new PaymentServiceResponderStub();
		var invoiceNumber = Any.positiveInteger();

		var amount = paymentService.getAmount(invoiceNumber);

		assertTrue(amount > 0);
	}
	
	@Test
	public void doStuffNotAllowed() {
		var paymentService = new PaymentServiceSaboteurStub();
		var invoiceNumber = Any.positiveInteger();

		var amount = paymentService.getAmount(invoiceNumber);

		assertFalse(amount > 0);
	}
	
	@Test
	public void doStuffThrows() {
		var paymentService = new PaymentServiceSaboteurExceptionStub();
		var invoiceNumber = Any.positiveInteger();

		assertThrows(() -> paymentService.getAmount(invoiceNumber));
	}

	// For positive path scenarios 
	public class PaymentServiceResponderStub implements PaymentService {
		public double getAmount(int invoiceNumber) {
			return Any.positiveInteger();
		}
	}
	
	// For negative path scenarios
	public class PaymentServiceSaboteurStub implements PaymentService {
		public double getAmount(int invoiceNumber) {
			return Any.negativeInteger();
		}
	}
	
	// For thrown exception scenarios
	public class PaymentServiceSaboteurExceptionStub implements PaymentService {
		public double getAmount(int invoiceNumber) {
			throw new RuntimeException("foo");
		}
	}
}
