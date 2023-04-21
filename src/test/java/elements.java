import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elements {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        String actualTitle=driver.getTitle();
        String expectedTitle= "DEMOQA";

        if(actualTitle.equals(expectedTitle))
            System.out.println("The title of the website is correct");
        else
            System.out.println("The title of the website is incorrect");


        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/elements";

        if(expectedUrl.equals(actualUrl))
            System.out.println("Moved to the right url");
        else
            System.out.println("moved to the wrong url");



        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")).click();
        driver.findElement(By.id("userName")).sendKeys("Bertina");
        driver.findElement(By.id("userEmail")).sendKeys("bertina@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Anaji");
        driver.findElement(By.id("permanentAddress")).sendKeys("Canada");

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
//        element.click();

        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.id("submit"));
        actions.moveToElement(button).click().perform();



        //driver.findElement(By.xpath("//button[@id='submit']")).click();
        String textBoxExpectedUrl= "https://demoqa.com/checkbox";
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]")).click();
        String textBoxActualUrl= driver.getCurrentUrl();

        if(textBoxActualUrl.equals(textBoxExpectedUrl))
            System.out.println("The Urls match");
        else
            System.out.println("The url does not match");

      driver.findElement(By.xpath( "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/span[1]/label[1]/span[1]/*[1]")).click();
//        Boolean isSelectedCheckBox=checkBox.isSelected();
//        System.out.println(isSelectedCheckBox);

        driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Yes')]")).click();

       boolean successMessageEl= driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/p[1]")).isDisplayed();
        System.out.println(successMessageEl);











    }

}

