import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_ResponseBodyTesting {
    /*

    URL : https://jsonplaceholder.typicode.com/posts/44
    get request

    test that
    status code 200
    content type JSon
    in response body, value of "userId" is 5
    value of "title" is "optio dolor molestias sit"


     */

    @Test
    public void test01(){

        // 1) set the url
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2) Response
        Response response = given().when().get(url);
        response.prettyPrint();

        // 3) Assertion

        //    status code 200
        //    content type JSon
        //    in response body, value of "userId" is 5
        //    value of "title" is "optio dolor molestias sit"

 /*
 {
    "userId": 5,
    "id": 44,
    "title": "optio dolor molestias sit",
    "body": "temporibus est consectetur dolore\net libero debitis vel velit laboriosam quia\nipsum quibusdam qui itaque fuga rem aut\nea et iure quam sed maxime ut distinctio quae"
}
  */

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.equalTo(5))
                .body("title", Matchers.equalTo("optio dolor molestias sit"));




    }




}
