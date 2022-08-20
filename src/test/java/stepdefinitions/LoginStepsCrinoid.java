package stepdefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.TestContext;
import pageobjects.LoginPage;

import java.util.List;
import java.util.Map;


public class LoginStepsCrinoid {
    TestContext testContext;
    LoginPage loginPage;

    public LoginStepsCrinoid(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Then("Crinoid Login page is displayed")
    public void loginPageIsDisplayed() {
        Assert.assertTrue(loginPage.emailLoginPageIsDisplayed());

        String actualLoginHeaderTitle = loginPage.getLoginHeaderTitle();
        Assert.assertEquals("Mausuk", actualLoginHeaderTitle);

        String actualRegisterQuestionText = loginPage.getQuestionRegisterText();
        Assert.assertEquals("Belum punya akun Crinoid? Daftar Sekarang", actualRegisterQuestionText);
    }

    @When("input username and password")
    public void inputUsernameandPassword(DataTable dataTable) {
        List<String> dataRow = dataTable.row(0);
        String email = dataRow.get(0);

        System.out.println("row index 0 --- " + email);
        loginPage.fillEmailData(email);
        System.out.println("row index 1 --- " + dataRow.get(1));
        System.out.println("row index 2 --- " + dataRow.get(2));
    }


    @When("Click continue button")
    public void clickContinueButton() {
        loginPage.clickSelanjutnyaButton();
    }
}
