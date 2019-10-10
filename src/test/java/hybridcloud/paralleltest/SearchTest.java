package hybridcloud.paralleltest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import hybridcloud.pageobjects.SearchPage;

public class SearchTest extends BaseTest {

	@Test
	public void searchNokia1() throws InterruptedException {

		SearchPage searchPage = new SearchPage(driver);
		goToUrl("https://www.google.com");

		searchPage.searchFor("Nokia");

		assertTrue(searchPage.getResults().size() >= 1);
	}
}
