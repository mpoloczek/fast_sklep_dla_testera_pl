package pl.akademiaqa.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.SearchResultsPage;

public class TopMenuAndSearchSections {

    private Page page;

    private Locator searchInput;

    public TopMenuAndSearchSections(Page page) {
        this.page = page;
        this.searchInput = page.locator("input[name=s]");
    }

    public SearchResultsPage searchForProducts(String productName) {
        searchInput.fill(productName);
        page.keyboard().press("Enter");

        return new SearchResultsPage(page);

    }
}
