import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C01_FirstClass {


    @Test
    public void getUsersReqIn(){

        /*
        url : https://restful-booker.herokuapp.com/booking/10

        get request

        print status code
        content type :  application/json; charset=utf-8
        print "Server" named header is Cowboy
        print status line : HTTP/1.1 200 OK
        print response time

{
    "firstname": "Susan",
    "lastname": "Jackson",
    "totalprice": 653,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2021-05-13",
        "checkout": "2022-01-04"
    },
    "additionalneeds": "Breakfast"
}
         */


        // 1 ) URL
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2) we can send the request

                            // second part will send the request
        Response response = given().when().get(url);
        // left part will save it

        response.prettyPrint();

        System.out.println("Status code : "+ response.getStatusCode());
        System.out.println("Content type : " +response.getContentType());
        System.out.println("Server Header : "+ response.getHeader("Server"));
        System.out.println("StatusLine : " + response.getStatusLine());
        System.out.println("Response Time : "+ response.getTime());

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
        Assert.assertEquals("Cowboy",response.getHeader("Server"));
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
        Assert.assertTrue(response.getTime()<6000);

    }
}
