package LibraryCT.userStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class LibrarianLoginCredential {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");

        //TODO Then verify that the title is “Login - Library”

        driver.get("https://library2.cybertekschool.com/login.html");
        String title = driver.getTitle();
        if (title.equals("Login - Library") ){
            System.out.println("Tittle match, actual result is equal expected result: " + title);
            System.out.println("Test passed");
        } else {
            System.out.println("Tittle doesn't match, expected result: Login - Library, actual result: " + title);
            System.out.println("Test failed");
        }
        Thread.sleep(5000);
        // TODO When librarian enters valid email address and password

        WebElement emails = driver.findElement(By.id("inputEmail"));
        emails.sendKeys("librarian52@library");
        WebElement pass = driver.findElement(By.id("inputPassword"));
        pass.sendKeys("Sdet2022*");
        WebElement loginBtn = driver.findElement(By.tagName("button"));
        loginBtn.submit();
        Thread.sleep(5000);


        //TODO Then verify that there are 3 models on the page
        ArrayList<String> expectedModules = new ArrayList<>(Arrays.asList("Dashboard", "Users", "Books"));

            WebElement model1 = driver.findElement(By.xpath("(//span[@class='title'])[1]"));
            WebElement model2 = driver.findElement(By.xpath("(//span[@class='title'])[2]"));
            WebElement model3 = driver.findElement(By.xpath("(//span[@class='title'])[3]"));



        ArrayList<String> actualModules = new ArrayList<>(Arrays.asList(model1.getText(),model2.getText(),model3.getText()));

        if(expectedModules.size()==actualModules.size() && expectedModules.equals(actualModules)){
            System.out.println("Expected and actual result match.");
            System.out.println("Expected result: "+ expectedModules);
            System.out.println("Actual result: "+ actualModules);
            System.out.println("Test passed");
        }else {
            System.out.println("Expected and actual  don't match.");
            System.out.println("Expected result: "+ expectedModules);
            System.out.println("Actual result: "+ actualModules);
            System.out.println("Test failed");
        }













    }
}
