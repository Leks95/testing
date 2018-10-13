package yandex;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Test3 {
    private static WebDriver driver;
    private static StringBuffer stringBuffer;
    private static String fileName;
    private static String findSysem;

    @BeforeClass
    public static void setup() {
        findSysem = "yandex";
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www."+ findSysem +".ru");
    }

    @Test
    public void method3() throws IOException {
        Set<String> oldWindowsSet = driver.getWindowHandles();
        WebElement element = driver.findElement(By.name("text"));
        element.sendKeys("Альфа Банк\n");

        WebElement element1 = driver.findElement(By.linkText("AlfaBank.ru"));
        element1.click();

        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);

        WebElement element2 = driver.findElement(By.linkText("Вакансии"));
        element2.click();

        List<WebElement> element3 = driver.findElements(By.className("nav_item "));
        for (int i =0;i<element3.size();i++){
            if(driver.findElements(By.className("nav_item ")).get(i).getText().equalsIgnoreCase("О работе в банке")){
                driver.findElements(By.className("nav_item ")).get(i).click();
                break;
            }
        }

        stringBuffer = new StringBuffer(driver.findElement(By.className("message")).getText()+"\n");
        stringBuffer.append(driver.findElement(By.className("info")).getText());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        fileName = String.format("%s %s_%s", dateFormat.format( new Date()), driver.getClass().getSimpleName().substring(0,6), findSysem);

        setFile();
    }


    public void setFile() throws IOException {
        String absoluteFilePath = "/Users/aleksejmozzeckov/IdeaProjects/testing/src/test/files/";
        File file = new File(absoluteFilePath + fileName + ".txt");
        file.createNewFile();

        FileOutputStream inputStream = new FileOutputStream(file);
        inputStream.write(stringBuffer.toString().getBytes());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
