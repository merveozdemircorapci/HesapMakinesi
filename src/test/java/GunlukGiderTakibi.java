import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GunlukGiderTakibi {
    //Günlük giderlerin girilerek toplama işleminin başarıyla yapılabildiği ve sonucun doğru olduğu görülmeli.
    //20+10+5=35

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://catchylabs-webclient.testinium.com/"); //bu adrese git
        driver.manage().window().maximize();

        WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        Username.click(); // kutucuğuan tıkla.
        Username.sendKeys("merve.ozdemir");  //senkeys alana girelecek değer bilgisi

        WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        Password.click();
        Password.sendKeys("Ozdemir3!");

        WebElement Login = driver.findElement(By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93']"));
        Login.click();
        Thread.sleep(1000);

        WebElement OpenCalculator = driver.findElement(By.xpath("//div[@class='css-175oi2r r-1i6wzkk r-lrvibr r-1loqt21 r-1otgn73 r-1awozwy r-169ebfh r-z2wwpe r-h3s6tt r-1777fci r-tsynxw r-11c0sde r-13qz1uu']"));   //css ile yazdırma
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", (OpenCalculator));

        WebElement sifir = driver.findElement(By.xpath("//div[17]"));
        WebElement bir = driver.findElement(By.xpath("//div[contains(text(),'1')]"));
        WebElement iki = driver.findElement(By.xpath("//div[14]"));
        WebElement bes = driver.findElement(By.xpath("//div[10]"));
        WebElement sekiz = driver.findElement(By.xpath("//div[contains(text(),'8')]"));
        WebElement esittir = driver.findElement(By.cssSelector("div:nth-child(20) div:nth-child(1) div:nth-child(1)"));
        WebElement cikarma = driver.findElement(By.cssSelector("div:nth-child(12)"));
        WebElement arti = driver.findElement(By.cssSelector("div:nth-child(16) div:nth-child(1) div:nth-child(1)"));


        iki.click();
        sifir.click();
        arti.click();
        bir.click();
        sifir.click();
        arti.click();
        bes.click();
        esittir.click();

        Thread.sleep (1000);

        WebElement sonuc1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div/span"));

        System.out.println("Hesaplama işlemi tamamlandı.");
        String sonuc1text = sonuc1.getText();
        System.out.println("Beklenen Sonuç: 35, Gerçekleşen Sonuç: " + sonuc1text);
        try {
            Assert.assertEquals(sonuc1text, "= 35","Sonuç hatalı olarak hesaplanmıştır.");
        }
        catch (Exception e)
        {
            throw e;
        }
        finally {
            driver.quit();
        }
    }
}