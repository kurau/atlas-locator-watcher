package ru.kurau.atlas;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
public class Locator {

    private String fullPath;
    private String urls;
    private String tests;
    private int count;

}
