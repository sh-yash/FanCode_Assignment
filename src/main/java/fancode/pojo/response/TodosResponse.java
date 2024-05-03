package fancode.pojo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TodosResponse {
    public int userId;
    public int id;
    public String title;
    public boolean completed;
}
