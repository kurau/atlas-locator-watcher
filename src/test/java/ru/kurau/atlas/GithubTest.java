package ru.kurau.atlas;

import io.kurau.atlas.AllureListener;
import io.kurau.atlas.ContextWebDriverConfiguration;
import io.kurau.atlas.FindByContext;
import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.atlas.core.Atlas;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.kurau.atlas.page.GithubPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class GithubTest {

    private WebDriver webDriver;
    private GithubPage githubPage;
    private List<FindByContext> locators = new ArrayList<>();

    @Rule
    public SaveLocatorsRule saveLocatorsRule = new SaveLocatorsRule();

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        Atlas atlas = new Atlas(new ContextWebDriverConfiguration(webDriver))
                .listener(new AllureListener().setLocatorsList(locators));
        saveLocatorsRule.setLocators(locators);

        webDriver.get("https://github.com/");
        githubPage = atlas.create(webDriver, GithubPage.class);
    }

    @Test
    @DisplayName("Виддим линк «Marketplace»")
    public void shouldSeeMarketplaceLink() {
        githubPage.header().link("Marketplace").should(isDisplayed());
    }

    @Test
    @DisplayName("Видим пункт «Explore GitHub» в навигации")
    public void shouldSeeGithubMenuItem() {
        githubPage.header().link("Explore").click();
        githubPage.details().should(hasSize(greaterThan(0)));
        githubPage.details().element(0).should(hasText("Explore GitHub"));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
