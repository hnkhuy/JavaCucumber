package StepDefs;

import Page.EngagementListPage;
import cucumber.api.java.en.Then;

/**
 * Created by huy.huynh on 13/09/2018.
 */
public class EngagementListStepDefs extends AbstractStepDefs {

    private EngagementListPage engagementListPage;

    @Override
    protected void initPages() {
        engagementListPage = new EngagementListPage();
    }

    @Then("^I can see Engagement List page$")
    public void seeEngagementListPage() throws Throwable {
        engagementListPage.seeEngagementListPage();
    }

    @Then("^I click on Engagement named: \"([^\"]*)\"$")
    public void clickOnEngagementNamed(String engagementName) throws Throwable {
        engagementListPage.clickOnEngagementNamed(engagementName);
    }
}
