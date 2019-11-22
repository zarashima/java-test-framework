package core.driver;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import listeners.EventsListener;
import org.openqa.selenium.WebDriver;

public class DriverModule extends AbstractModule {

  @Override
  protected void configure() {

  }

  @Provides
  public WebDriver getDriver() {
    return DriverFactory.getInstance().getDriver();
  }

  @Provides
  public WebDriverWrapper getDriverWrapper() {
    return (WebDriverWrapper) new WebDriverWrapper(DriverFactory.getInstance()
            .getDriver())
            .register(new EventsListener());
  }

}