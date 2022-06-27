package hotelsPROJECT;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;



    public class Orbitz_hotel {
        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "/Users/halildikmen/Desktop/browserDrivers/chromedriver");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");

            WebDriver driver = new ChromeDriver(options);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));

            driver.get("https://www.orbitz.com/");

            driver.findElement(By.xpath("//button[@aria-label = 'Going to']")).click();

            driver.findElement(By.id("location-field-destination")).sendKeys("Orlando" + Keys.ENTER);

            driver.findElement(By.id("d1-btn")).click();

            driver.findElement(By.xpath("//button[@aria-label='Jul 20, 2022']")).click();

            driver.findElement(By.xpath("//button[@aria-label='Jul 24, 2022']")).click();

            driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click();

            driver.findElement(By.xpath(" //button[@data-testid='travelers-field-trigger']")).click();

            Thread.sleep(2000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[@class='uitk-step-input-button']")));

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@id='child-input-0']//following-sibling::button")));

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@id='child-input-0']//following-sibling::button")));

            Select child1 = new Select(driver.findElement(By.xpath("//select[@id='child-age-input-0-0']")));
            child1.selectByValue("4");

            Select child2 = new Select(driver.findElement(By.xpath("//select[@id='child-age-input-0-1']")));
            child2.selectByValue("8");

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(" //button[@data-testid='guests-done-button']")));

            Thread.sleep(2000);

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(" //button[@data-testid='submit-button']")));

            driver.findElement(By.id("popularFilter-0-FREE_BREAKFAST")).click();

            WebElement clickedBreakfast = driver.findElement(By.xpath("//button[@id='playback-filter-pill-mealPlan-FREE_BREAKFAST']"));
            Assert.assertTrue(clickedBreakfast.isDisplayed());

            driver.findElement(By.id("popularFilter-0-FREE_BREAKFAST")).click();

            Thread.sleep(2000);

            Assert.assertFalse(driver.findElement(By.id("popularFilter-0-FREE_BREAKFAST")).isSelected());

            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[@id='playback-filter-pill-mealPlan-FREE_BREAKFAST']")).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("(//input[@aria-valuemax='300'])[2]")).sendKeys(Keys.ARROW_LEFT);

            Thread.sleep(2000);

            WebElement selectedBudget = driver.findElement(By.xpath("//span[@class='uitk-pill-text']"));

            Assert.assertEquals(selectedBudget.getText(), "Less than $270");

            List<WebElement> selectedPrices = driver.findElements(By.xpath("//div[contains(text(), \"The price is\")]"));

            for (WebElement listOfPrices : selectedPrices) {

                System.out.println(listOfPrices.getText().replaceAll("[$, Theprics]", ""));

                Assert.assertTrue((Integer.parseInt(listOfPrices.getText().replaceAll("[$, Theprics]", "")) <= 270));
            }

            Thread.sleep(2000);

            Assert.assertEquals(50, selectedPrices.size());

            driver.findElement(By.id("radio-guestRating-45")).click();

            Thread.sleep(2000);

            List<WebElement> selectedRates = driver.findElements(By.xpath("//span[@class='uitk-text uitk-type-300 uitk-type-bold uitk-text-default-theme']"));

            for (WebElement listOfRates : selectedRates) {

                System.out.println(listOfRates.getText().substring(0, 3).replaceAll("[$, Theprics]", ""));

                Assert.assertTrue((Double.parseDouble(listOfRates.getText().substring(0, 3).replaceAll("[$, Theprics]", "")) >= 4.5));
            }

            Thread.sleep(2000);

            List<WebElement> selectedName = driver.findElements(By.xpath("//h2[@class='uitk-heading-5']"));

            List<WebElement> selectedRate = driver.findElements(By.xpath("(//span[@class='uitk-text uitk-type-300 uitk-type-bold uitk-text-default-theme'])"));

            String textName = driver.findElement(By.xpath("(//h2[@class='uitk-heading-5'])[" + selectedName.size() + "]")).getText();

            String rateRate = driver.findElement(By.xpath("(//span[@class='uitk-text uitk-type-300 uitk-type-bold uitk-text-default-theme'])[" + selectedRate.size() + "]")).getText().substring(0, 3).replaceAll("[$, Theprics]", "");

            System.out.println(" Hotel name:" + textName + " Hotel rate:" + rateRate);

            ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + 0 + "," + 700 + ")");

            List<WebElement> selectedHotel = driver.findElements(By.xpath("(//a[@data-stid='open-hotel-information'])"));

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", (driver.findElement(By.xpath("(//a[@data-stid='open-hotel-information'])[" + selectedHotel.size() + "]"))));

            Set<String> windowHandles = driver.getWindowHandles();

            String windowHandle1 = driver.getWindowHandle();

            for (String windowHandle : windowHandles) {

                driver.switchTo().window(windowHandle);
            }

            Assert.assertEquals(driver.getTitle(), textName);

            Assert.assertEquals(driver.findElement(By.xpath("//div[@data-stid='content-hotel-title']//h1")).getText(), textName);

            String compareRate = driver.findElement(By.xpath("(//h3[contains(@class,'uitk-heading-5 uitk-spacing')])[1]")).getText().substring(0, 3).replaceAll("[$, Theprics]", "");

            Assert.assertEquals(compareRate, rateRate);

            driver.close();

            driver.switchTo().window(windowHandle1);

            driver.getTitle();

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",  driver.findElement(By.xpath("//a//img")));

            WebElement orbitsLogo = driver.findElement(By.xpath("//iframe[starts-with(@src,'https://vac.vap.expedia.com/')]"));

            driver.switchTo().frame(orbitsLogo);

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();",  driver.findElement(By.xpath("//button[@data-test-id='chat-launch-button']")));

            String expectedText = "Hi, I'm your Virtual Agent \uD83D\uDC4B";

            String actualText = driver.findElement(By.xpath("//div[@class='uitk-text uitk-type-300 uitk-type-regular uitk-layout-flex-item uitk-text-default-theme']")).getText();

            Assert.assertEquals(expectedText, actualText);

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.id("vac-close-button")));

            driver.switchTo().defaultContent();

            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[.='More travel']")));

            String[] urlSelected = {"Stays", "Flights", "Packages", "Cars", "Cruises", "Things to do", "Deals", "Groups & meetings", "Travel Blog"};

            Thread.sleep(2000);

            List<WebElement> moreOptions = driver.findElements(By.xpath("(//div[@class='uitk-list'])[1]//a"));

            for (int i = 0; i < moreOptions.size(); i++) {

                Assert.assertEquals(moreOptions.get(i).getText(), urlSelected[i]);

            }
            driver.quit();

        }
    }

