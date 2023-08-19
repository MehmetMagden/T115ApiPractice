import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import org.openqa.selenium.json.Json;
import pojos.FirstPojoClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C09_JsonObject {

    //https://restful-booker.herokuapp.com/booking

    // we will send a post req with this body

    /*
    req body :
                           {
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                            "checkin" : "2021-06-01",
                                            "checkout" : "2021-06-10"
                                             },
                            "additionalneeds" : "wi-fi"
                        }
     */
    /*
    to create req body we will create JSON Object, but this one has inner objects so we need to create an inner Json object
    then will create an outer Json object. we will add all variables to this object

     */




    /*
    Test that response's status code is 200
    first name : Ali
    LastName Bak
    TotalPrice 500
     */



    static RequestSpecification spec;

    @Test
    public void test01(){

        String token = "clExEkJvB6kKYFUBguQ8dpgXJXujJ2";

//  i) home page link
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

//  ii ) setting  the parameters
        spec.pathParams("pp1","booking");
        String fullPath = "/{pp1}";  //   /api/visitorsPurposeId

        /*
         ******* critical{
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                            "checkin" : "2021-06-01",
                                            "checkout" : "2021-06-10"
                                             },
                            "additionalneeds" : "wi-fi"
                        }
         */

        // first let's create an inner object
        /*
        "bookingdates" : {
                                            "checkin" : "2021-06-01",
                                            "checkout" : "2021-06-10"
                                             }
         */

JSONObject innerObject = new JSONObject();
innerObject.put("checkin","2021-06-01");
innerObject.put("checkout","2021-06-10");

/*
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : innerObject,
                            "additionalneeds" : "wi-fi"
                        }
 */
        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerObject);
        reqBody.put("additionalneeds","wi-fi");



        //3 ) sending the request and storing the response
        Response response = given()
                .contentType(ContentType.JSON)  // We are using JSON format
                .spec(spec)                     // creating a stage for link and parameters
                .headers(
                       // "Authorization","Bearer "+ token,  // entered token in our request
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

//        response
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body("message", Matchers.equalTo("Success"))
//        ;



            /*
    Test that response's status code is 200
    first name : Ali
    LastName Bak
    TotalPrice 500
     */

        /*
        response body :
        {
    "firstname": "Ali",
    "additionalneeds": "wi-fi",
    "bookingdates": {
        "checkin": "2021-06-01",
        "checkout": "2021-06-10"
    },
    "totalprice": 500,
    "depositpaid": false,
    "lastname": "Bak"
}

         */

        //Test that response's status code is 200
//        response
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body("booking.firstname",equalTo("Ali"))
//                .body("booking.lastname",equalTo("Bak"))
//                .body("booking.totalprice",equalTo(500))
//                .body("booking.depositpaid",equalTo(false))
//                .body("booking.depositpaid",equalTo(false))
//                .body("booking.bookingdates.checkin",equalTo("2021-06-01"))
//                ;


        FirstPojoClass responseBody = response.as(FirstPojoClass.class);
        System.out.println(responseBody);

        System.out.println(responseBody.getBookingid());
        System.out.println(responseBody.getBooking().getFirstname());

    }
}
