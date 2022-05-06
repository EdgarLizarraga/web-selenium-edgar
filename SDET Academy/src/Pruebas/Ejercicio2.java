package Pruebas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio2 {

	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\elizarraga\\Documents\\GeckoDrivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.get("https://computer-database.gatling.io/computers");
        driver.manage().window().maximize();

        WebElement textname = driver.findElement(By.xpath("//input[@id='searchbox']"));
        textname.sendKeys("ASCI Thors Hammer");

        WebElement filterbutton = driver.findElement(By.xpath("//input[@id='searchsubmit']"));
        filterbutton.click();

        WebElement computer = driver.findElement(By.xpath("//a[contains(text(),'ASCI Thors Hammer')]"));
        actions.moveToElement(computer)
                .pause(4000)
                .click()
                .build()
                .perform();

        Select country = new Select(driver.findElement(By.xpath("//select[@id='company']"))) ;
        country.selectByIndex(1);
        WebElement buttoncreate = driver.findElement(By.xpath("//input[@value='Save this computer']"));
        buttoncreate.click();

        WebElement messagewarning = driver.findElement(By.xpath("//div[@class='alert-message warning']"));

        if (messagewarning.isDisplayed()){
            System.out.println("Correct");
        }
        else {
            System.out.println("Incorrect");
        }

    }

}
