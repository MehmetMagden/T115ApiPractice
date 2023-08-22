import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import pojos.T113_Pojo;

import static io.restassured.RestAssured.given;

public class T113Class02 {

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


    static RequestSpecification spec;

    @Test
    public void test01() {

        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

        spec.pathParams("pp1", "booking");
        String fullPath = "/{pp1}";                     //  /booking
        //String token = "mJ9gvGG2A1y7M1mko4mtnTQojTxYXh";


        /*
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
        JSONObject innerBody = new JSONObject();
        innerBody.put("checkin", "2021-06-01");
        innerBody.put("checkout", "2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Ali");
        reqBody.put("lastname", "Bak");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", innerBody);
        reqBody.put("additionalneeds", "wi-fi");


        Response response = given()
                .contentType(ContentType.JSON)
                .spec(spec)
                .headers(
                        // "Authorization","Bearer "+token,
                        "Content-Type", ContentType.JSON,                // gönderdigim bilgilerin formatı JSON
                        "Accept", ContentType.JSON               // ben sadece JSON kabul ediyorum
                )
                .when()
                .body(reqBody.toString())                       // body gönderileceği zaman bu satır kullanılabilr
                .log().all()                                    // gönderdiğimiz responsu print ediyor
                .post(fullPath);                                 // ilgili parametrelere post request


        response.prettyPrint();

        response.then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("Ali"))
                .body("booking.bookingdates.checkin", Matchers.equalTo("2021-06-01"))
                ;

        /*
    {
    "bookingid": 193,
    "booking": {
                "firstname": "Ali",
                "lastname": "Bak",
                "totalprice": 500,
                "depositpaid": false,
                "bookingdates": {
                        "checkin": "2021-06-01",
                        "checkout": "2021-06-10"
                        },
                "additionalneeds": "wi-fi"
                }
    }
         */

        T113_Pojo pojo = response.as(T113_Pojo.class);


        System.out.println("**********POJO**************");
        System.out.println(pojo);

        Assert.assertEquals("Ali",pojo.getBooking().getFirstname());



    }
}
