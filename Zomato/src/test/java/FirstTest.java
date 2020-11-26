
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;



public class FirstTest {

    @Test
    public void TestCase1() throws InterruptedException {
        RestAssured.baseURI ="https://developers.zomato.com/api/v2.1";
        RequestSpecification request = RestAssured.given();
        request.header("user-key","7b8c2002a92c21109f1dfd2808ea50e1");
        request.header("Accept","application/json");

        Response response = request.get("/categories");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200);


        //JsonPath ob=new Jsonpath(response):
        JsonPath jsonPathEvaluator = response.jsonPath();

        String category_1 = jsonPathEvaluator.get("categories[0].categories.name").toString();
        Assert.assertEquals(category_1,"Delivery");

    }

}
