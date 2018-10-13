package yandex;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test2 {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.yandex.ru");
        WebElement element = driver.findElement(By.linkText("Маркет"));
        element.click();
        Thread.sleep(1000);
    }


    @Test
    public void method1() throws InterruptedException {
        WebElement element1 = driver.findElement(By.linkText("Электроника"));
        element1.click();

        WebElement element2 = driver.findElement(By.linkText("Мобильные телефоны"));
        element2.click();
        Thread.sleep(1000);

        List<WebElement> element3 = driver.findElements(By.className("NVoaOvqe58"));
        for (int i =0;i<element3.size();i++)
            if(driver.findElements(By.className("NVoaOvqe58")).get(i).getText().equals("Samsung"))
                driver.findElements(By.className("NVoaOvqe58")).get(i).click();
        Thread.sleep(1000);

        WebElement element4 = driver.findElement(By.name("Цена от"));
        element4.sendKeys("40000");
        Thread.sleep(1000);

        WebElement element5 = driver.findElements(By.className("n-snippet-cell2__title")).get(0);
        String s = element5.getText();

        List<WebElement> element6 = driver.findElements(By.tagName("a"));
        for (int i =0;i<element6.size();i++)
            if(driver.findElements(By.tagName("a")).get(i).getText().equals(s)){
                driver.findElements(By.tagName("a")).get(i).click();
                break;
            }
        Thread.sleep(1000);
        if(driver.findElement(By.className("n-title__text")).getText().equals(s))
            System.out.println("Совпадает название");
        else
            System.out.println("Не совпадает название");
    }

    @Test
    public void method2() throws InterruptedException {
        List<WebElement> element1 = driver.findElements(By.className("n-region-notification__actions-cell"));
        for (int i =0;i<element1.size();i++){
            if(driver.findElements(By.className("n-region-notification__actions-cell")).get(i).getText().equals("Да, спасибо"));{
                driver.findElements(By.className("n-region-notification__actions-cell")).get(i).click();
                break;
            }
        }
        Thread.sleep(2000);


        WebElement element = driver.findElement(By.partialLinkText("Электроника"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        Thread.sleep(2000);

        WebElement element2 = driver.findElements(By.tagName("svg")).get(6);
        element2.click();
        Thread.sleep(2000);

        List<WebElement> element3 = driver.findElements(By.className("NVoaOvqe58"));
        for (int i =0;i<element3.size();i++)
            if(driver.findElements(By.className("NVoaOvqe58")).get(i).getText().equalsIgnoreCase("beats"))
                driver.findElements(By.className("NVoaOvqe58")).get(i).click();
        Thread.sleep(2000);

        WebElement element4 = driver.findElement(By.name("Цена от"));
        element4.sendKeys("17000");
        Thread.sleep(2000);

        WebElement element5 = driver.findElement(By.name("Цена до"));
        element5.sendKeys("25000");
        Thread.sleep(2000);

        WebElement element6 = driver.findElements(By.className("n-snippet-cell2__title")).get(0);
        String s = element6.getText();

        List<WebElement> element7 = driver.findElements(By.tagName("a"));
        for (int i =0;i<element7.size();i++)
            if(driver.findElements(By.tagName("a")).get(i).getText().equals(s)){
                driver.findElements(By.tagName("a")).get(i).click();
                break;
            }
        Thread.sleep(1000);
        if(driver.findElement(By.className("n-title__text")).getText().equals(s))
            System.out.println("Совпадает название");
        else
            System.out.println("Не совпадает название");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
