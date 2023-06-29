//        **********************SELENIUM WAITS AND WEB TABLES**********************
package org.example;
//Package Imports

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


//Main Class
public class Main {
    public static void main(String[] args) {
        try {

//          Change web driver according to your browser. Here Chrome browser has been used.
            WebDriver driver = new ChromeDriver();

//          Opening the website
            driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

//          Maximizing window size
            driver.manage().window().maximize();

//          Storing rows elements of table in list
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));

//          Storing column elements of table in list
            List<WebElement> cols = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));

//          Printing table elements row-wise
            System.out.println("**********************ROW-WISE**********************\n");
            for (int i = 2; i <= rows.size(); i++) {
                for (int j = 1; j <= cols.size(); j++) {
                    String cellValue = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]/span")).getText();
                    System.out.print(cellValue);
                    if (j != cols.size()) {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
            }

//          Printing table elements column-wise
            System.out.println("\n**********************COLUMN-WISE**********************\n");
            for (int i = 1; i <= cols.size(); i++) {
                for (int j = 2; j <= rows.size(); j++) {
                    String cellValue = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + j + "]/td[" + i + "]/span")).getText();
                    System.out.print(cellValue);
                    if (j != rows.size()) {
                        System.out.print(" - ");
                    }
                }
                System.out.println("\n");
            }

//          Verifying that Roland Mendel works in Microsoft and lives in Austria
            String employeeName = driver.findElement(By.xpath("//*[text()='Roland Mendel']")).getText();
            if (employeeName.equals("Roland Mendel")) {
                String companyName = driver.findElement(By.xpath("//table/tbody/tr[4]/td[1]/span")).getText();
                String country = driver.findElement(By.xpath("//table/tbody/tr[4]/td[3]/span")).getText();
                if (companyName.equals("Microsoft") && country.equals("Austria")) {
                    System.out.println("Successfully Validated!");
                } else {
                    System.out.println("Validation Unsuccessful!");
                }
            }

//          Closing Web driver
            driver.close();

            System.out.println("\nThank You!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//        **********************THANK YOU**********************

/*CREDITS:
    Bhuvan Kohli
    bhuvan.kohli@geminisolutions.com
*/