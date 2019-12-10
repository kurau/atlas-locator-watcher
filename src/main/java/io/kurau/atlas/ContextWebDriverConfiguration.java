package io.kurau.atlas;

import io.qameta.atlas.core.context.RetryerContext;
import io.qameta.atlas.core.internal.Configuration;
import io.qameta.atlas.core.internal.DefaultMethodExtension;
import io.qameta.atlas.core.internal.EmptyRetryer;
import io.qameta.atlas.webdriver.context.WebDriverContext;
import io.qameta.atlas.webdriver.extension.DriverProviderExtension;
import io.qameta.atlas.webdriver.extension.ExecuteJScriptMethodExtension;
import io.qameta.atlas.webdriver.extension.FilterCollectionExtension;
import io.qameta.atlas.webdriver.extension.PageExtension;
import io.qameta.atlas.webdriver.extension.ShouldMethodExtension;
import io.qameta.atlas.webdriver.extension.ToStringMethodExtension;
import io.qameta.atlas.webdriver.extension.WaitUntilMethodExtension;
import io.qameta.atlas.webdriver.extension.WrappedElementMethodExtension;
import org.openqa.selenium.WebDriver;

public class ContextWebDriverConfiguration extends Configuration {

    public ContextWebDriverConfiguration(final WebDriver webDriver) {
        registerContext(new WebDriverContext(webDriver));
        registerContext(new RetryerContext(new EmptyRetryer()));

        registerExtension(new DriverProviderExtension());
        registerExtension(new DefaultMethodExtension());
        registerExtension(new WaitUntilMethodExtension());
        registerExtension(new ShouldMethodExtension());
        registerExtension(new WrappedElementMethodExtension());
        registerExtension(new ExecuteJScriptMethodExtension());
        registerExtension(new PageExtension());
        registerExtension(new FilterCollectionExtension());
        registerExtension(new ToStringMethodExtension());

        // CONTEXT
        registerContext(new FindByContext());

        registerExtension(new ShouldMethodExtension());
        registerExtension(new FindByWithContextExtension());
        registerExtension(new FindByCollectionWithContextExtension());
        registerExtension(new ListElementExtension());
    }

}
