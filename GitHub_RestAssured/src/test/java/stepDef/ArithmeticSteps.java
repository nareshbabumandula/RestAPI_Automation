package stepDef;

import java.util.List;
import java.util.Map;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArithmeticSteps {

	private int a;
	private int b;
	private int number1;
	private int number2;
	private int result;
	private String errorMessage;

	@Given("I launch calculator")
	public void i_launch_calculator() {
		System.out.println("Launched the calculator..!");
	}


	@Given("i enter the value of a as {int}")
	public void i_enter_the_value_of_a_as(Integer int1) {
		System.out.println("a value is : " + int1);
		a=int1;
	}

	@When("i enter the value of b as {int}")
	public void i_enter_the_value_of_b_as(Integer int2) {
		System.out.println("b value is : " + int2);
		b=int2;
	}

	@SuppressWarnings("deprecation")
	@Then("i perform addition to validate the sum as {int}")
	public void verifyAddition(int int3) {
		int c=a+b;
		junit.framework.Assert.assertEquals("Failed to performed addition of a and b and the result is : "+c, int3, c);
	}


	@When("i have entered numbers into the calculator")
	public void i_have_entered_numbers_into_the_calculator(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		number1 = Integer.parseInt(data.get(0).get("number1"));
		number2 = Integer.parseInt(data.get(0).get("number2"));
	}

	@When("I peform addition")
	public void i_peform_addition() {
		result = number1+number2;
	}
	@Then("the result should be {int}")
	public void the_result_should_be(int expected) {
		Assert.assertEquals(expected, result);
	}

	//########################################################################

	
	@When("I have entered {int} into the calculator")
	public void i_have_entered_into_the_calculator(int number) {
		if (number1==0) {
			number1=number;
		} else {
			number2=number;
		}
	}
	
	@When("I perform addition")
	public void i_perform_addition() {
		result=number1+number2;
	}

	@When("I perform subtraction")
	public void i_perform_subtraction() {
		result=number1-number2;
	}

	@When("I perform multiplication")
	public void i_perform_multiplication() {
		result=number1*number2;
	}

	@When("I perform division")
	public void i_perform_division() {
		if (number2!=0) {
			result = number1/number2;
		}else {
			errorMessage="Division by zero is not allowed";
		}
	}

	@When("I perform modulus")
	public void i_perform_modulus() {
		if (number2!=0) {
			result = number1%number2;
		}else {
			errorMessage="Division by zero is not allowed";
		}
	}

	@Then("the result should be {int} on the screen")
	public void the_result_should_be_on_the_screen(int expected) {
		Assert.assertEquals(expected, result);
	}




}
