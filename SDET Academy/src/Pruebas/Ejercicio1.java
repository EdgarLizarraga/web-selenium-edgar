package Pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio1 {


    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/elizarraga/IdeaProjects/SDET Academy/src/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://computer-database.gatling.io/computers");
        driver.manage().window().maximize();



        WebElement buttonsearch = driver.findElement(By.xpath("//a[@id='add']"));
        buttonsearch.click();
        WebElement textname = driver.findElement(By.xpath("//input[@id='name']"));
        textname.sendKeys("Prueba 05052022");

        WebElement textintroducedate = driver.findElement(By.xpath("//input[@id='introduced']"));
        textintroducedate.sendKeys("2022-10-05");

        WebElement discontinueddate = driver.findElement(By.xpath("//input[@id='discontinued']"));
        discontinueddate.sendKeys("2100-10-05");

        Select country = new Select(driver.findElement(By.xpath("//select[@id='company']"))) ;
        country.selectByIndex(3);

        WebElement buttoncreate = driver.findElement(By.xpath("//input[@value='Create this computer']"));
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