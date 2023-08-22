import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T113Class01 {

    static RequestSpecification spec;

    @Test
    public void test01(){

        spec = new RequestSpecBuilder().setBaseUri("https://qa.wonderworldcollege.com").build();

        spec.pathParams("pp1","api","pp2","visitorsPurposeList");
        String fullPath = "/{pp1}/{pp2}";       //  /api/visitorsPurposeList
        String token = "bbvHP0IP9p57tpvFL5IMQktaW3JoN6";


        Response response = given()
                .contentType(ContentType.JSON)
                .spec(spec)
                .headers(
                        "Authorization","Bearer "+token,
                        "Content-Type",ContentType.JSON, // gönderdigim bilgilerin formatı JSON
                        "Accept",ContentType.JSON               // ben sadece JSON kabul ediyorum
                        )
                .when()
                .log().all()                                    // gönderdiğimiz responsu print ediyor
                .get(fullPath);                                 // ilgili parametrelere get request


        response.prettyPrint();





}

}
