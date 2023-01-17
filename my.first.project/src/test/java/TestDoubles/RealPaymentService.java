package TestDoubles;

public class RealPaymentService implements PaymentService {

	private Logger logger;
	private DatabaseUtility db;

	public RealPaymentService(Logger logger, DatabaseUtility db) {
		this.logger = logger;
		this.db = db;
	}

	public double getAmount(int invoiceNumber) {
		if(invoiceNumber == 0) {
			logger.append("Sale value was too high!");			
		}

		return db.execute("SELECT AMOUNT FROM INVOICE WHERE ID = {0}", invoiceNumber);
	}
}
