package ru.kurau.atlas.page;

import io.kurau.atlas.element.ExtElementsCollection;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;

public interface GithubPage extends WebPage {

    @Name("Шапка")
    @FindBy("//header")
    Header header();

    @Name("Детали")
    @FindBy("//details[@open]//li")
    ExtElementsCollection<AtlasWebElement> details();
}
