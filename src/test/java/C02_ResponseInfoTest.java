import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_ResponseInfoTest {

    @Test
    public void test01(){


        /*
        https://restful-booker.herokuapp.com/booking/10
        get req
        test that:
        status code is 200
        content type is  application/json; charset=utf-8
        server named header is Covboy
        status Line is HTTP/1.1 200 OK

         */

        // 1) URL
        String url = "https://restful-booker.herokuapp.com/booking/10";


        // 2) Send request
        Response response = given().when().get(url);

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");




    }


}
