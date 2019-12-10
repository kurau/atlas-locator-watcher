package ru.kurau.atlas;

import com.google.gson.Gson;
import io.kurau.atlas.FindByContext;
import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.DisplayName;
import lombok.Setter;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveLocatorsRule extends TestWatcher {

    @Setter
    private List<FindByContext> locators;

    @Override
    protected void finished(Description description) {
        List<Locator> results = new ArrayList<>();

        Map<String, FindByContext> map = new HashMap<>();
        locators.forEach(s -> map.put(s.locator(), s));

        String testName = testName(description);

        map.forEach((k, v) -> results
                .add(new Locator().setFullPath(k)
                        .setTests(testName)
                        .setUrls(v.getUrl())));

        locators(new Gson().toJson(results));
    }

    @Attachment(value = "locators", fileExtension = ".locators")
    private String locators(String attach) {
        return attach;
    }

    private String testName(Description description) {
        String param = "";
        String regex = ".*\\[(.*)\\].*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(description.getMethodName());
        if (matcher.find()) {
            param = String.format("[%s]", matcher.group(1));
        }
        return Optional.of(description.getAnnotation(DisplayName.class).value() + param)
                .orElse(description.getMethodName());
    }
}
