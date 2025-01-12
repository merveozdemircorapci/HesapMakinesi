import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class YatirimHesaplamasi {
//100TL lik yatırımın %5 Faiz oranı ile 1 yıl sonraki değeri hesaplandığında "105" olarak geldiği görülmeli.
//Formül: A=100×(1+(0.05×1))=100×1.05=105
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://catchylabs-webclient.testinium.com/"); //bu adrese git
        driver.manage().window().maximize();

        WebElement Username = driver.findElement(By.xpath("//input[@placeholder='Username']"));   //elamanın id bilgisi yazılacak. Tarayıcıda ilgili anlanın sağ tik incele yapıldıüındaki İd bilgisi
        Username.click(); // kutucuğuan tıkla.
        Username.sendKeys("merve.ozdemir");  //senkeys alana girelecek değer bilgisi

        WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        Password.click();
        Password.sendKeys("Ozdemir3!");

        WebElement Login = driver.findElement(By.xpath("//div[@class='css-146c3p1 r-jwli3a r-1b43r93']"));   //css ile yazdırma
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
        WebElement carpi = driver.findElement(By.cssSelector("div:nth-child(8)"));
        WebElement arti = driver.findElement(By.cssSelector("div:nth-child(16) div:nth-child(1) div:nth-child(1)"));
        WebElement virgul = driver.findElement(By.xpath("//div[19]"));

        sifir.click();
        virgul.click();
        sifir.click();
        bes.click();
        carpi.click();
        bir.click();
        esittir.click();
        arti.click();
        bir.click();
        carpi.click();
        bir.click();
        sifir.click();
        sifir.click();

        Thread.sleep (1000);
        WebElement sonuc1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div[1]/div/span"));

        System.out.println("Hesaplama işlemi tamamlandı.");
        String sonuc1text = sonuc1.getText();
        System.out.println("Beklenen Sonuç: 105, Gerçekleşen Sonuç: " + sonuc1text);
        try {
            Assert.assertEquals(sonuc1text, "= 105","Sonuç hatalı olarak hesaplanmıştır.");
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