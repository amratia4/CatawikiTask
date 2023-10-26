# CatawikiTask

This is the Task For Catawiki Interview:

used selenuim with TestNG with Page object Model
used openCSV dependency to read the test data "search item" from a CSV file
Scenario steps that is automated in this task as follow:
1. Open https://www.catawiki.com/en/
2. At the top of the page there is a search field. Search for the keyword "train".
3. Verify that the search results page is opened. ( verified the search result page by making sure that the search item is displayed and we can see the objects number "which I believe is the search results number" )
4. Click on the second lot in search results.
5. Lot’s page should be opened.
6. On the lot page, you'll see:
○ lot's name
○ “favorites” counter
○ current bid
7. Get the values of these items and print those values to console.


Steps to run: 
1- clone the repo
2- open "LotTests.java" which under"src/test/java/lots/"
3- after running the test case open the terminal and use the following command "allure serve" to view the allure report 

