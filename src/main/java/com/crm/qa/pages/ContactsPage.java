package com.crm.qa.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement companyName;
	
	@FindBy(xpath = "//body/table/tbody/tr/td/table/tbody/tr/td/fieldset[@class='fieldset']/form[@id='contactForm']/table/tbody/tr/td/input[2]")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
    
    public boolean verifyContactsLabel() {
    	return contactsLabel.isDisplayed();
    }
    
    public void selectContactsByName(String name) {
//    	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
//    			+ "+//preceding-sibling::td[@class'datalistrow]//input[@name='contact-id']")).click();
    	
    	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click(); 
		
	}
    
    public void createNewContact(String title, String ftName, String ltName, String comp) {
    	Select select = new Select(driver.findElement(By.name("title")));
    	select.selectByVisibleText(title);
    	
    	firstName.sendKeys(ftName);
    	lastName.sendKeys(ltName);
    	companyName.sendKeys(comp);
    	saveBtn.click();
		
	}
    
    
}
