package pl.akademiaqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.SearchResultsPage;
import pl.akademiaqa.utils.Properties;

import java.util.stream.Stream;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.assertj.core.api.Assertions.*;

class SearchTest extends BaseTest{

    private HomePage homePage;

    @BeforeEach
    void beforeEach(){
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEn();
    }

/*
    @Test
    void should_return_products_by_search_name_mug(){
        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSections().searchForProducts("mug");
        Assertions.assertThat(searchResultsPage.getSearchResultsSection().getProducts().size()).isEqualTo(5);

    }

    @Test
    void should_return_products_by_search_name_frame(){
        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSections().searchForProducts("frame");
        Assertions.assertThat(searchResultsPage.getSearchResultsSection().getProducts().size()).isEqualTo(4);

    }

    @Test
    void should_return_products_by_search_name_tshirt(){
        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSections().searchForProducts("t-shirt");
        Assertions.assertThat(searchResultsPage.getSearchResultsSection().getProducts().size()).isEqualTo(1);

    }
*/
    //@ParameterizedTest
    //@ValueSource(strings = {"mug", "t-shirt", "frame"})
    //void should_return_products_by_product_name(String productName){
        //SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSections().searchForProducts(productName);
        //Assertions.assertThat(searchResultsPage.getSearchResultsSection().getProducts().size()).isGreaterThan(0);

    //}

    @DisplayName("Search for products")
    @ParameterizedTest(name = "Search for {0} should return {1} product(s)")
    @MethodSource("searchData")
    void should_return_products_by_products_name(String productName, int productCounter){
        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSections().searchForProducts(productName);
        Assertions.assertThat(searchResultsPage.getSearchResultsSection().getProducts().size()).isEqualTo(productCounter);

    }

    private static Stream<Arguments> searchData() {
        return Stream.of(
             Arguments.of("t-shirt", 1),
             Arguments.of("mug", 5),
             Arguments.of("frame", 4),
             Arguments.of("notebook",3),
             Arguments.of("graphics", 3)
        );

    }

}
