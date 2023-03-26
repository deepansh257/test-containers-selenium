import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;

public class SeleniumTests extends Base{

    @Test
    public void openUrl() throws IOException {
        RemoteWebDriver driver = Base.chromeContainer.getWebDriver();
        driver.get("https://www.google.com/");
        System.out.println("Opened url");
        System.out.println("URL : " + driver.getCurrentUrl());
        takeScreenshot(driver);
    }

    public void takeScreenshot(WebDriver driver) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("Screenshots/test.png"));
    }
}
