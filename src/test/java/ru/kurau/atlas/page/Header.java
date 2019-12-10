package ru.kurau.atlas.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import io.qameta.atlas.webdriver.extension.Param;

public interface Header extends AtlasWebElement {

    @Name("Ссылка «{{ value }}»")
    @FindBy(".//li[contains(. , '{{ value }}')]")
    AtlasWebElement link(@Param("value") String value);

}
