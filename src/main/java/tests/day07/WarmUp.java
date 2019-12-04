package tests.day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //how to find all links
        // every link as a tagname <a>
        // size of the the list= number of links
        //if no element found nosuchElementexeption
        //if list is empty that means that element is not there
        //in this way we can assure that that element does not present
        //   //a.[.='Home'] or   //a[text()='Home'] find link with text name
        List<WebElement>  list= driver.findElements(By.tagName("a"));
        System.out.println("number of links: "+list.size());
        //what if I want to print text of all links, one by one
        //loop through the collection of links
        for(WebElement webElement: list){
            //print text of every link
            if(!webElement.getText().isEmpty())
            System.out.println(webElement.getText());
        }


        driver.close();
    }

}
