import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import foundation.TestBase;

public class RadioButtonTests extends TestBase {

	@Test
	public void canSelectValueFromRadioGroup() {
		var radioButtonSelection = "Yes";

		var selectedValue = visit()
				.radioButtonPage()
				.selectRadioButton(radioButtonSelection)
				.getSelectedRadioButtonValue();

		assertEquals(selectedValue, radioButtonSelection, "The selected value does not match what is selected.");
	}
}
