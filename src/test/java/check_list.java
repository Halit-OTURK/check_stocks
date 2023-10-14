import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class check_list {
    public static void main(String[] args) {

int x=0;
        while (x < 3) {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://steelfitusa.com/products/abs-of-steel-starter-bundle");
            String stockCheck = driver.findElement(By.xpath("//div[text()='Sold out']")).getText();

            boolean soldOut = stockCheck.equalsIgnoreCase("Sold out");
            if (soldOut) {
                System.out.println("steelfitusa = Sold Out");
            } else {
                System.out.println("steelfitusa = IN STOCK");
            }
            driver.close();

            WebDriver driver2 = new ChromeDriver();
            driver2.manage().window().maximize();
            // driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver2.get("https://www.puritan.com/joint-support-062/glucosamine-chondroitin-msm-2-per-day-formula-023413");

            WebElement outOfStock = driver2.findElement(By.xpath("//p[text()='Currently out of stock']"));
            String stockCheck2 = outOfStock.getText();
            boolean soldOut2 = stockCheck.equalsIgnoreCase("Sold out");

            WebDriverWait wait = new WebDriverWait(driver2,Duration.ofSeconds(10));
            // wait2.withTimeout(Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(outOfStock));

            if (soldOut) {
                System.out.println("puritan = Sold Out");
                            }
            else {
                driver2.get("https://www.youtube.com/shorts/iVSNeDiXsgU");
                driver2.findElement(By.xpath("(//button[@class = 'ytp-large-play-button ytp-button'])[1]")).click();
                WebDriverWait wait2 = new WebDriverWait(driver2,Duration.ofSeconds(10));
               // wait2.withTimeout(Duration.ofSeconds(10));
                wait2.until(ExpectedConditions.visibilityOfAllElements());
                System.out.println("puritan = IN STOCK");
            }

            driver2.close();

        /*    int minutes = 1;

            for (int i = minutes; i > 0; i--) {
                for (int z = 59; z >= 0; z--) {
                    System.out.print("\r" + (x + 1) + ". kontrol tamamlandi");

                }
            }
          */

            System.out.print("\r" + (x + 1) + ". kontrol tamamlandi");
            x++;
        }
    }
}