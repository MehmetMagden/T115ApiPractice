import org.json.JSONObject;
import org.junit.Test;

public class C03_CreatingBodyJsonObject {


    /*
    create this body and print it


        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
        }
     */

    @Test
    public void test01(){

        // for the body we will create a JSONObject

        JSONObject firstBody = new JSONObject(); // we have created an empty body

        firstBody.put("title","Ahmet");
        firstBody.put("body","Merhaba");
        firstBody.put("userId",1);


        System.out.println("our precious first JSON object : "+firstBody);


    }


    @Test
    public void test02(){

        /*
                 {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                                 },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

        JSONObject littleObject = new JSONObject();
        littleObject.put("checkin","2018-01-01");
        littleObject.put("checkout","2019-01-01");

        JSONObject outerObject = new JSONObject();

        outerObject.put("firstname","Jim");
        outerObject.put("additionalneeds","Breakfast");
        outerObject.put("bookingdates",littleObject);  // we have used little object we created before as value
        outerObject.put("totalprice",111);
        outerObject.put("depositpaid",true);
        outerObject.put("lastname","Brown");

        System.out.println("Json OBject is : "+ outerObject);



    }
}
