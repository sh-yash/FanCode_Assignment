package fancode;

import fancode.apiHelper.FanCodeApi;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;


public class BaseSetup {

    public FanCodeApi fanCodeApiClient;
    public SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        fanCodeApiClient=new FanCodeApi();
        softAssert=new SoftAssert();

    }
}
