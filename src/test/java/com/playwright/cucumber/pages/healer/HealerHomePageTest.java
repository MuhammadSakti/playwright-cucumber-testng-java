package com.playwright.cucumber.pages.healer;

import org.testng.annotations.Test;

/**
 * Healer test for HomePage — navigates once, heals all locators in one batch AI call.
 * Run separately after test failures to fix broken selectors.
 * <p>
 * Run with: mvn test -DsuiteXmlFile=testng-healersakti.xml
 */
public class HealerHomePageTest extends HealerBaseTest {

    private HealerHomePage homePage;

    @Override
    protected String reportName() {
        return "HomePage";
    }

    @Override
    protected void navigateToPage() {
        homePage = new HealerHomePage(page, healer);
        homePage.open();
    }

    // --- Header / Navigation ---

    @Test
    public void healHeader() {
        homePage.healHeader();
    }

    @Test
    public void healFooter() {
        homePage.healFooter();
    }

    @Test
    public void healLogoLink() {
        homePage.healLogoLink();
    }

    @Test
    public void healNavHome() {
        homePage.healNavHome();
    }

    @Test
    public void healNavInventory() {
        homePage.healNavInventory();
    }

    @Test
    public void healNavAbout() {
        homePage.healNavAbout();
    }

    @Test
    public void healCartBadge() {
        homePage.healCartBadge();
    }

    // --- Hero ---

    @Test
    public void healPageTitle() {
        homePage.healPageTitle();
    }

    @Test
    public void healPageSubtitle() {
        homePage.healPageSubtitle();
    }

    // --- Search ---

    @Test
    public void healSearchInput() {
        homePage.healSearchInput();
    }

    // --- Stats Bar ---

    @Test
    public void healStatsBar() {
        homePage.healStatsBar();
    }

    @Test
    public void healTotalCount() {
        homePage.healTotalCount();
    }

    @Test
    public void healShowingCount() {
        homePage.healShowingCount();
    }

    // --- Filter Panel ---

    @Test
    public void healFilterPanel() {
        homePage.healFilterPanel();
    }

    @Test
    public void healSortSelect() {
        homePage.healSortSelect();
    }

    @Test
    public void healResetFiltersButton() {
        homePage.healResetFiltersButton();
    }

    @Test
    public void healMinLevelInput() {
        homePage.healMinLevelInput();
    }

    @Test
    public void healMaxLevelInput() {
        homePage.healMaxLevelInput();
    }

    // --- Items Grid ---

    @Test
    public void healItemsGrid() {
        homePage.healItemsGrid();
    }
}