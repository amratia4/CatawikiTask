package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    String searchResults;
    private WebDriver driver;
    public SearchResultsPage (WebDriver driver){
        this.driver= driver;
    }

    private By searchTerm = By.tagName("h1");
    private By searchResultsNumber = By.id("lot-list");
    private By secondSearchCard = By.xpath("(//div[@class='c-extended-lot-card'])[2]");

    public String getSearchedItem(){
        String headerSearchTerm = driver.findElement(searchTerm).getText();
        return headerSearchTerm;
    }

    public String getSearchResultsNumber(){
        return driver.findElement(searchResultsNumber).getText();
    }

    public LotPage selecting2ndSearchResult(){
        driver.findElement(secondSearchCard).click();
        return new LotPage(driver);
    }
}
