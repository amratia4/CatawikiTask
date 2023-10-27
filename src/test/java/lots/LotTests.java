package lots;

import base.BaseTests;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.LotPage;
import pages.SearchResultsPage;
import searchdata.TestDataHandler;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LotTests extends BaseTests {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Lots Scenario Test case")
    public void verifyLotPage() {
        List<String> searchItems = TestDataHandler.getSearchItems();

        for (String searchItem : searchItems) {
            homePage.clickAgreeButton();
            homePage.searchData(searchItem);
            SearchResultsPage searchResultsPage = homePage.clickSearchIcon();
            // Assert that we can see the searched item displayed on the search result page
            assertEquals(searchResultsPage.getSearchedItem(), searchItem, "No Search results were found");
            // Assert that we can see the number of search results
            assertNotNull(searchResultsPage.getSearchResultsNumber());
            LotPage lotPage = searchResultsPage.selecting2ndSearchResult();
            // Printing out Lot name, Favorites counter, and current bid
            lotPage.logLotName();
            lotPage.logFavoritesCounter();
            lotPage.logCurrentBid();
        }
    }
}