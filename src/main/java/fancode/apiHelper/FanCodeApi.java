package fancode.apiHelper;

import com.fasterxml.jackson.databind.ObjectMapper;
import fancode.constants.EndPoints;
import fancode.pojo.response.TodosResponse;
import fancode.pojo.response.UserResponse;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;
import java.util.List;

import static io.restassured.RestAssured.given;

public class FanCodeApi {

    RequestSpecification requestSpecification;
    ObjectMapper mapper;
    public FanCodeApi(){
        RestAssured.baseURI= EndPoints.baseURI;
        mapper=new ObjectMapper();

    }

    public List<UserResponse> usersAPIFanCode()
    {
        List<UserResponse> userData;
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBasePath(EndPoints.users);
        requestSpecBuilder.setContentType(io.restassured.http.ContentType.JSON);

        requestSpecification =requestSpecBuilder.build();
        Response response = given().spec(requestSpecification)
                .when().log().all().get().then().extract().response();
        if(response.getStatusCode()==200){
          userData=  response.jsonPath().getList(".",UserResponse.class);
        }else{
            userData=null;
        }
        return userData;
    }

    public List<TodosResponse> todosResponsesForUserId(int userId){
        List<TodosResponse> todosResponses;
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBasePath(EndPoints.users+"/"+userId+EndPoints.todos);
        requestSpecBuilder.setContentType(io.restassured.http.ContentType.JSON);

        requestSpecification =requestSpecBuilder.build();
        Response response = given().spec(requestSpecification)
                .when().log().all().get().then().extract().response();

        if(response.getStatusCode()==200){
            todosResponses=  response.jsonPath().getList(".",TodosResponse.class);
            Reporter.log(todosResponses.toString(),true);
        }else{
            todosResponses=null;
        }
        return todosResponses;
    }


}
