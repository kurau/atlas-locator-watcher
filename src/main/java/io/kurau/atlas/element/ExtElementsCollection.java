package io.kurau.atlas.element;

import io.kurau.atlas.annotation.ListElement;
import io.qameta.atlas.webdriver.ElementsCollection;

public interface ExtElementsCollection<E> extends ElementsCollection<E> {

    @ListElement
    E element(int i);

}
