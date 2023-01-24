package TestDoubles;

public class RealLogger implements Logger {

	@Override
	public void append(String text) {
		System.out.println(text);
	}
}
