import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_SendingRequestWithBody {

    @Test
    public void test01(){

        /*
        put request
        URL: https://jsonplaceholder.typicode.com/posts/70
body:
{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}

then test that:

    status code 200
    content type  : application/json; charset=utf-8
    header named Server is cloudflare
    status line is HTTP/1.1 200 OK

         */

        //1 ) url
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        // 2) let's create the body
        JSONObject reqBody = new JSONObject();
/*
{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}
 */
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        // if we are plannig to send a body, we should also mention the content type
        // 3) send the request

        Response response = given()
                .contentType(ContentType.JSON)  // body's content type is JSON
                .when()
                .body(reqBody.toString())   // we are sending the JSON object as string data
                .put(url);


        response.prettyPrint();

        //    status code 200
        //    content type  : application/json; charset=utf-8
        //    header named Server is cloudflare
        //    status line is HTTP/1.1 200 OK

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");

    }
}
