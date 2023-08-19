import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_ApiUS002 {
/*
As an administrator, I want to access the Visitor Purpose information of a user with a given ID through API connection.
 */

    // When a valid authorization information and
    // correct data (ID) are sent in the POST body to the api/visitorsPurposeId endpoint,
    // the expected status code is 200, and the message in the response body should be "Success."


    static RequestSpecification spec;

    @Test
    public void test01(){

        String token = "clExEkJvB6kKYFUBguQ8dpgXJXujJ2";

        //  1 ) String token = "T6123sIlh8BC3REvY8NX4s0ne1vPrr"; // It has 30 mins limit
        //  2 )  we will create the link
        //      i) home page link
        //      ii ) setting  the parameters
        // 3 ) sending the request and storing the response
        // 4 ) Testing

//  i) home page link
        spec = new RequestSpecBuilder().setBaseUri("https://qa.wonderworldcollege.com").build();

//  ii ) setting  the parameters
        spec.pathParams("pp1","api","pp2","visitorsPurposeId");
        String fullPath = "/{pp1}/{pp2}";  //   /api/visitorsPurposeId

        /*
        ******* critical
        *
        * we need to add a body to this request
        * we will create a json OBject and we will add all info in it. And we will send the request with this body
         */

        JSONObject reqBody = new JSONObject(); // we created an empty body
        reqBody.put("id",2);                    // we added the info to our reqBody


        //3 ) sending the request and storing the response
        Response response = given()
                .contentType(ContentType.JSON)  // We are using JSON format
                .spec(spec)                     // creating a stage for link and parameters
                .headers(
                        "Authorization","Bearer "+ token,  // entered token in our request
                        "Content-Type",ContentType.JSON, // we are sending data by using JSON format
                        "Accept",ContentType.JSON               // We will only accept JSON format
                )

                .when()
                .body(reqBody.toString())  // if a body required in the request we need to write it here/
                .log().all()   // this will print what we are sending to API
                .post(fullPath);


        response.prettyPrint();

        // 4 ) Testing

        //// To validate that the status code is 200
        //// and the response message is "Success"

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("message", Matchers.equalTo("Success"))
        ;





    }

}
