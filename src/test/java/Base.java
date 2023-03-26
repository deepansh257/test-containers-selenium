import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.utility.DockerImageName;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {

    public static String chromeImg = "selenium/standalone-chrome-debug";
    public static String chromeImgVersion = "3.141.59";
    public static BrowserWebDriverContainer<?> chromeContainer = null;  //class to bring up Selenium TestContainer

    //Start the test-container
    @BeforeSuite(alwaysRun = true)
    public static void initialise(){
        System.out.println("Inside before suite");
        DockerImageName dockerImage = DockerImageName.parse(chromeImg).withTag(chromeImgVersion);
        chromeContainer = new BrowserWebDriverContainer<>(dockerImage).withCapabilities(new ChromeOptions());
        chromeContainer.start(); //Start the selenium container
    }

    @AfterSuite(alwaysRun = true)
    public static void tear(){
        System.out.println("Inside after suite");
        chromeContainer.close(); //release all the resource
        chromeContainer.stop(); //shut down the container
    }
}
