package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LotPage {
    private WebDriver driver;
    public LotPage (WebDriver driver){
        this.driver= driver;
    }

    By lotName = By.xpath("//div[contains(@class, 'be-lot-details__col-main') ]//h1");
    By favoritesCounter = By.xpath("//div[contains (@class, 'be-lot-details-scrollable-gallery__container') ]//span");
    By currentBidValue = By.xpath("//div[contains(@class, 'be-lot-core-bidding-panel')]//div[contains(@class, 'be-lot-bid-status-section__bid-amount u-typography-h2')]");


    public String logLotName(){
       String  currentLotName = driver.findElement(lotName).getText();
        System.out.println("Lot name is: " + currentLotName);
        return currentLotName;
    }

    public String logFavoritesCounter(){
       String currentFavoritesNumbers =   driver.findElement(favoritesCounter).getText();
        System.out.println("Current favorites number is: " + currentFavoritesNumbers);
       return currentFavoritesNumbers;
    }

    public String logCurrentBid (){
        String currentBid = driver.findElement(currentBidValue).getText();
        System.out.println("Current Bid is: " + currentBid);
        return currentBid;
    }
}
