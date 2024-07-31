package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.Pdashboard;
import PageObject.Plogin;

public class Scripts extends common {

    
         
    

    @Test 
    public void run() {
    	
    	setup();
    	
        Plogin obj = new Plogin(driver);     
        obj.applicationLogin("Admin", "admin123");
    
        Pdashboard obj1 = new Pdashboard(driver);    
        obj1.ClickMyInfo();
        
        teardown();
        
    }
 
}
