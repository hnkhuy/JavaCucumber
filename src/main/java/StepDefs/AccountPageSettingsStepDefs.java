package StepDefs;

import Page.AccountPageSettingsWebPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountPageSettingsStepDefs extends AbstractStepDefs {

    private AccountPageSettingsWebPage accountPageSettingsPage;

    @Override
    protected void initPages() {
        accountPageSettingsPage = new AccountPageSettingsWebPage();
    }

    @When("^I navigate to Account Page Settings of: (.*)$")
    public void navigateToAccountPageSettingsOf(String accountName) {
        accountPageSettingsPage.clickAccountNameOnListAccount(accountName);
        accountPageSettingsPage.navigateToAccountPageSettingsOf(accountName);
    }

    @Then("^I add new (.*) plugin$")
    public void selectToAddPlugin(String pluginName) {
        accountPageSettingsPage.deleteAllExistedCollectionPlugin(pluginName);
        accountPageSettingsPage.clickOnAddPluginButton();
        accountPageSettingsPage.selectToAddPlugin(pluginName);
        accountPageSettingsPage.navigatedToCollectionPluginPage();
    }

    @And("^I fill Collection plugin with given title and description$")
    public void fillCollectionPluginWithGivenTitleAndDescription(DataTable itemTable) {
        //just for happy case, no validation for list item quantity-andrew.huynh
        accountPageSettingsPage.fillCollectionItemsWithGivenTitleAndDescription(itemTable);
        accountPageSettingsPage.fillCollectionPluginTitle();
    }

    @And("^I Save plugin$")
    public void savePlugin() {
        accountPageSettingsPage.clickOnSavePluginButton();
    }

    @And("^I Publish plugin$")
    public void publishPlugin() {
        accountPageSettingsPage.activateThisPluginToPublish();
        accountPageSettingsPage.clickOnPublishButton();
    }

    @When("^I fill Text plugin with given title and description$")
    public void fillTextPluginWithGivenTitleAndDescription(DataTable data) {

    }
}