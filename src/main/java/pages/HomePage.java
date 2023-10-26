package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage (WebDriver driver){
        this.driver= driver;
    }

    private By agreeButton = By.id("cookie_bar_agree_button");
    private By searchField = By.id("textField11");
    private By searchIcon = By.cssSelector("div[data-testid='text-field-prefix']");

    public void clickAgreeButton(){
            driver.findElement(agreeButton).click();
    }

    public void searchData(String data) {
        driver.findElement(searchField).sendKeys(data);
    }

    public SearchResultsPage clickSearchIcon (){
        driver.findElement(searchIcon).click();
        return new SearchResultsPage(driver);
    }
}
