import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class check_list {
    public static void main(String[] args) throws InterruptedException {

        int x = 0;
        while (x < 3) {

            WebDriver driver = new ChromeDriver();

            driver.manage().window().minimize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://steelfitusa.com/products/abs-of-steel-starter-bundle");

            // String onsale = driver.findElement(By.xpath("(//sale-price[contains(@class, 'on-sale')])[1]")).getText();

            try {
                String stockCheck = driver.findElement(By.xpath("//div[text()='Sold out']")).getText();
                System.out.println("steelfitusa = Sold Out");
                driver.close();
            } catch (NoSuchElementException e) {

                e.printStackTrace();
                driver.manage().window().maximize();
                System.out.println("steelfitusa = IN STOCK");
                driver.get("https://www.youtube.com/watch?v=eaWuML647b8");
                WebElement playbutton = driver.findElement(By.xpath("(// button[@class='ytp-play-button ytp-button'])[1]"));
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.visibilityOf(playbutton));
                playbutton.click();

            }
            Thread.sleep(9000);
            driver.close();

      /*      boolean soldOut = stockCheck.equalsIgnoreCase("Sold out");
            if (soldOut) {
                System.out.println("steelfitusa = Sold Out");
            } else {
                System.out.println("steelfitusa = IN STOCK");
            }
            */


            WebDriver driver2 = new ChromeDriver();

            driver2.manage().window().minimize();
            driver2.get("https://www.puritan.com/joint-support-062/glucosamine-chondroitin-msm-2-per-day-formula-023413");

            WebElement outOfStock = null;
            try {
                outOfStock = driver2.findElement(By.xpath("//p[text()='Currently out of stock']"));
                WebDriverWait wait = new WebDriverWait(driver2, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(outOfStock));
                String stockCheck2 = outOfStock.getText();
                System.out.println("puritan = Sold Out");
                driver2.close();

            } catch (Exception e) {
                driver2.manage().window().maximize();
                System.out.println("steelfitusa = IN STOCK");
                driver2.get("https://www.youtube.com/watch?v=eaWuML647b8");
                WebElement playbutton = driver2.findElement(By.xpath("(// button[@class='ytp-play-button ytp-button'])[1]"));
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait2.until(ExpectedConditions.visibilityOf(playbutton));
                playbutton.click();
            }

            Thread.sleep(9000);
            driver2.close();

          /*  WebElement outOfStock = null;
            outOfStock = driver2.findElement(By.xpath("//p[text()='Currently out of stock']"));
            String stockCheck2 = outOfStock.getText();
            boolean soldOut2 = stockCheck2.equalsIgnoreCase("Sold out");


            WebDriverWait wait = new WebDriverWait(driver2, Duration.ofSeconds(10));
            // wait2.withTimeout(Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(outOfStock));

            if (soldOut2) {
                System.out.println("puritan = Sold Out");
            } else {
                driver2.get("https://www.youtube.com/shorts/iVSNeDiXsgU");
                driver2.findElement(By.xpath("(//button[@class = 'ytp-large-play-button ytp-button'])[1]")).click();
                WebDriverWait wait2 = new WebDriverWait(driver2, Duration.ofSeconds(10));
                // wait2.withTimeout(Duration.ofSeconds(10));
                wait2.until(ExpectedConditions.visibilityOfAllElements());
                System.out.println("puritan = IN STOCK");
            }
*/

            System.out.print("\r" + (x + 1) + ". kontrol tamamlandi");
            x++;
        }
    }
}