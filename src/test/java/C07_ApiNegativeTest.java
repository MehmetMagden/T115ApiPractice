import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_ApiNegativeTest {

    //When an invalid authorization information is sent with a GET request to the api/visitorsPurposeList endpoint,
    // the expected status code is 403, and the response message should be "failed."

    static RequestSpecification spec;

    @Test
    public void test01(){

        String token = "OJYmK7p0wEvXPWqjOTZe09TSdvfygDasdfasdf";

        //  1 ) String token = "T6123sIlh8BC3REvY8NX4s0ne1vPrr"; // It has 30 mins limit
        //  2 )  we will create the link
        //      i) home page link
        //      ii ) setting  the parameters
        // 3 ) sending the request and storing the response
        // 4 ) Testing

//  i) home page link
        spec = new RequestSpecBuilder().setBaseUri("https://qa.wonderworldcollege.com").build();

//  ii ) setting  the parameters
        spec.pathParams("pp1","api","pp2","visitorsPurposeList");
        String fullPath = "/{pp1}/{pp2}";  //   /api/visitorsPurposeList


        //3 ) sending the request and storing the response
        Response response = null;
        String exceptionMessage ="";

        try {
            response = given()
                    .contentType(ContentType.JSON)  // We are using JSON format
                    .spec(spec)                     // creating a stage for link and parameters
                    .headers(
                            "Authorization","Bearer "+ token,  // entered token in our request
                            "Content-Type",ContentType.JSON, // we are sending data by using JSON format
                            "Accept",ContentType.JSON               // We will only accept JSON format
                    )

                    .when()
                    .log().all()   // this will print what we are sending to API
                    .get(fullPath);

            response.prettyPrint();

        } catch (Exception e) {
            exceptionMessage = e.getMessage();
            System.out.println(exceptionMessage);
        }




        // 4 ) Testing

        //// To validate that the status code is 403
        //// and the response message is "Success"

//        response
//                .then()
//                .assertThat()
//                .statusCode(403)
//                .body("message", Matchers.equalTo("failed"))
//        ;
        Assert.assertTrue(exceptionMessage.contains("status code: 403"));





    }

}
