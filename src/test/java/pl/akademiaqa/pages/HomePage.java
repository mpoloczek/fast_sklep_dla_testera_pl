package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.sections.TopMenuAndSearchSections;
import pl.akademiaqa.pages.sections.TopNavigationSection;


@Getter
public class HomePage {

    private Page page;


    private TopMenuAndSearchSections topMenuAndSearchSections;
    private TopNavigationSection topNavigationSection;

    public HomePage(Page page) {
        this.page = page;
        this.topMenuAndSearchSections = new TopMenuAndSearchSections(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }
}
