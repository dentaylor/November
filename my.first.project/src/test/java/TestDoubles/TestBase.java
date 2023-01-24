package TestDoubles;

public class TestBase {
	protected TestBase() {
		this.Any = new AnonymousValueFixture();
	}
	
	protected AnonymousValueFixture Any;
}
