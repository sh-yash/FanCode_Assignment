import fancode.BaseSetup;
import fancode.pojo.response.TodosResponse;
import fancode.pojo.response.UserResponse;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.util.LinkedList;
import java.util.List;

public class FanCodeUserTest extends BaseSetup {


    @Test(description = "Verify That ")
    public void validateTodosTaskCompletion(){

        List<UserResponse> apiOutput;
        apiOutput=fanCodeApiClient.usersAPIFanCode();

        Reporter.log("Verify that call is successful for users api and output is produced",true);
        Assert.assertTrue(apiOutput!=null,"Verify that call is successful and output is produced");

        for (UserResponse user: apiOutput) {
            if (user.isFanCodeCity()) {
            double lat=Double.valueOf(user.getAddress().getGeo().getLat());
            double lon=Double.valueOf(user.getAddress().getGeo().getLng());
            softAssert.assertTrue((lat >= -40 && lat <= 5),"Validate the latitude for fan code user");
            softAssert.assertTrue((lon >= 5 && lon <= 100),"Validate the longitude for fan code user");
            int completedTasks = 0;
            int totalTasks = 0;

            List<TodosResponse> todosResponsesForUser=fanCodeApiClient.todosResponsesForUserId(user.getId());
            Assert.assertTrue(todosResponsesForUser!=null,"Verify that call is successful and output is produced");

            for (TodosResponse todo : todosResponsesForUser) {
                    if (todo.getUserId() == user.getId()) {
                        totalTasks++;
                        if (todo.isCompleted()) {
                            completedTasks++;
                        }
                    }
            }
            double completionPercentage = ((double) completedTasks / totalTasks) * 100;
            Reporter.log("Validate that for User : "+user.getName() +" has completed total of % : "+completionPercentage +"\n ================================================",true);
            softAssert.assertTrue(completionPercentage>50,"Validated that for User : "+user.getName() +" has completed total of % : "+completionPercentage);
        }
        softAssert.assertAll();

    }
 }


}
