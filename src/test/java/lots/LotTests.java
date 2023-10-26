package lots;

import base.BaseTests;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LotPage;
import pages.SearchResultsPage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class LotTests extends BaseTests {

    CSVReader reader;
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Lots Scenario Test case")

    public void VerifyLotPage() throws CsvValidationException, IOException {
        //get path for CSV file
        String CSV_file = System.getProperty("user.dir") + "/src/test/java/searchdata/searchItems.csv";
        try {
            reader =new CSVReader(new FileReader(CSV_file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String [] csvCell;
        while((csvCell = reader.readNext()) != null){
            String searchItem = csvCell[0];
            homePage.clickAgreeButton();
            homePage.searchData(searchItem);
            SearchResultsPage searchResultsPage = homePage.clickSearchIcon();
            assertEquals(searchResultsPage.getSearchedItem(), searchItem, "No Search results were found") ;
            Assert.assertNotNull(searchResultsPage.getSearchResultsNumber());
            LotPage lotPage = searchResultsPage.selecting2ndSearchResult();
            lotPage.logLotName();
            lotPage.logFavoritesCounter();
            lotPage.logCurrentBid();
        }
    }
}
