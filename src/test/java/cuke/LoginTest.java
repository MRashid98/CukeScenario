package cuke;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {

	public static WebDriver driver;

	public static ChromeOptions chromeCfg() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);
		cOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		return cOptions;
	}

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\azwad\\Documents\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\CukeTableTask\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
	}

	@Given("^We can access the Demo Website$")
	public void we_can_access_the_Demo_Website() throws Throwable {
		driver.get("http://thedemosite.co.uk/");

	}

	@When("^I access the Registration Page$")
	public void i_access_the_Registration_Page() throws Throwable {
		WebElement targ = driver.findElement(
				By.xpath("/html/body/div[1]/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		targ.click();

	}

	@When("^register using \"([^\"]*)\" as the username and \"([^\"]*)\" as the password$")
	public void register_using_as_the_username_and_as_the_password(String arg1, String arg2) throws Throwable {
		WebElement targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		targ.sendKeys(arg1);

		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		targ.sendKeys(arg2);

		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		targ.click();

	}

	@Then("^I access the Login page$")
	public void i_access_the_Login_page() throws Throwable {
		WebElement targ = driver.findElement(
				By.xpath("/html/body/div[1]/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		targ.click();
	}

	@Then("^login with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_and(String arg1, String arg2) throws Throwable {
		WebElement targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		targ.sendKeys(arg1);

		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		targ.sendKeys(arg2);

		targ = driver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		targ.click();

		targ = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("**Successful Login**", targ.getText());

	}

	@After
	public void cleanUp() {
		driver.close();
		driver.quit();

	}
}
