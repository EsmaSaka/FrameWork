package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class Vasyl {


    public class CalendarEventsTests {
        private WebDriver driver;
        private WebDriverWait wait;
        @BeforeMethod
        public void setup(){
            driver = BrowserFactory.getDriver("chrome");
            //explicit wait
            wait = new WebDriverWait(driver, 10);
            //implicit wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //maximize browser
            driver.manage().window().maximize();
            driver.get("https://qa1.vytrack.com/");
            driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
            driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
            WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
            wait.until(ExpectedConditions.visibilityOf(activitiesElement));
            wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
            activitiesElement.click();
            WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
            wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
            wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
            calendarEventsElement.click();
            WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }
        @Test(description = "Verify page subtitle")
        public void test1(){
            String expectedSubtitle = "All Calendar Events";
            String actualSubtitle = driver.findElement(By.className("oro-subtitle")).getText();
            Assert.assertEquals(actualSubtitle, expectedSubtitle, "Subtitle is wrong!");
        }
        @Test(description = "Verify that 'Create Calendar event' button is displayed")
        public void test2(){
            Assert.assertTrue(driver.findElement(By.cssSelector("[title='Create Calendar event']")).isDisplayed());
        }
        @AfterMethod
        public void teardown(){
            driver.quit();
        }
    }

}
/*
  Today is 11/22/2019
    Agenda:
    finish git practice, that we started yesterday
    automation practice with vytrack application
#########################################
    git is a version control tool
    it keeps track of changes that were made
    git remember who did changes, when and what kind of changes
    it helps to collaborate, so multiple developers can easily work together on the same project
    Also, git is a distributed version control system (DVCS).
    Main version of the project will be in the cloud (for example github)
    github it's a google driver for git projects/repositories
            for project we create a git repository.
    we have local repository (on your computer)
    and we have remote repository (on github)
    git know about changes in your project
    github works as cloud storage for your project
    The process of getting a copy of project call cloning
    git clone - stands for getting a copy of project from remote repository (github)
    PLease comeback at 3:15
    git init - initialize local repository for project
    git add . - prepare files for commit
    git commit -m "commit message" - commit code (take a snapshot)
    git push - send updated project to github
    Don't forget to connect local repo with remote!
    First create repo on github and then github will show instruction.
    Invite only for Elvira, sorry
    //command that will connect local and remote repo
//CybertekSchool it's my github username, instead you should see yours
    git remote add origin https://github.com/CybertekSchool/Summer2019GitPractice.git
    git remote set-url origin <YOUR GITHUB LINK>
    last command, it runs only once, then just git push:
    git push -u origin master
=====
    git log - to see history of commits. :q - to exit from the log
9a0efc024577ed2cc458aa6b4af6c062df732d5d - always different, it calls commit id
    commit 9a0efc024577ed2cc458aa6b4af6c062df732d5d (HEAD -> master, origin/master)
    Author: Vasyl Fomiuk <vasyl@cybertekschool.com>
    Date:   Fri Nov 22 15:57:07 2019 -0500
    added student class
    What you need to know:
    When you will get a laptop, at work, you need to clone project (get a copy)
    Then, pull (to get updates)
    and push to send your updates
    Usually I pull in a morning, and at the the day before commit.
    I push code at the end of the day. If I didn't finish something, I will push once I will be done with script/task. No need to push every 30 minutes.
            ############################################
    Test data
    url: https://qa1.vytrack.com/
    username: storemanager85
    password: UserUser123
###Test case #1
    Go to https://qa1.vytrack.com/
    Login as a store manager
    Navigate to Activities -> Calendar Events
    Verify that page subtitle "All Calendar Events" is displayed
 */
