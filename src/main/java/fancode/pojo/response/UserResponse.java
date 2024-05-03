package fancode.pojo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.testng.Reporter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserResponse {
    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;
    public boolean isFanCodeCity() {
        double lat = Double.valueOf(address.getGeo().getLat());
        double lng = Double.valueOf(address.getGeo().getLng());
        Reporter.log("Latitude" +lat +" and Longitude : "+lng+" , User is "+username,true);
        return (lat >= -40 && lat <= 5) && (lng >= 5 && lng <= 100);

    }

}
