import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class T113Class03 {

    /*
    api/alumniEventsByDateRange endpoint'ine gecerli authorization bilgileri
    ve dogru datalar (start: "2021-01-14 00:00:00", end: "2023-03-15 23:59:00") iceren bir POST body gönderildiğinde
    dönen response bodydeki list içinde dataların (id'si = "1", olan veri içeriğindeki
           title: "Covid-19 Seminar",
           event_for: "class",
           session_id:"16",
           class_id: "1",
           section: "[\"1\"]",
           from_date: "2021-03-01 00:00:00",
           to_date: "2021-03-16 00:00:00",
           note: "COVID-19 is the disease caused by a new coronavirus called SARS-CoV-2.  WHO first learned of this new virus on 31 December 2019, following a report of a cluster of cases of â€˜viral pneumoniaâ€™ in Wuhan, Peopleâ€™s Republic of China.", photo: "",
           is_active: "0",
           event_notification_message: "GAVI'S RESPONSE\r\nRespond and protect: With COVID-19 now reported in almost all Gavi-eligible countries, the Vaccine Alliance is providing immediate funding to health systems, enabling countries to protect health care workers, perform vital surveillance and training, and purchase diagnostic tests.\r\n\r\nMaintain, restore and strengthen: Gavi will support countries to adapt and restart immunisation services, rebuild community trust and catch up those who have been missed both before and during the pandemic, while also investing in strengthening immunisation systems to be more resilient and responsive to the communities they serve.\r\n\r\nEnsure global equitable access: Gavi is co-leading COVAX, the global effort to securing a global response to COVID-19 that is effective and fair, using its unique expertise to help identify and rapidly accelerate development, production and delivery of COVID-19 vaccines so that anyone that needs them, gets them.",
           show_onwebsite: "0"
           ve created_at: "2021-03-23 02:54:29" olduğu ) içerikleri doğrulanmali


     */

    static RequestSpecification spec;

    @Test
    public void test01(){

        spec = new RequestSpecBuilder().setBaseUri("https://qa.wonderworldcollege.com").build();

        spec.pathParams("pp1","api","pp2","alumniEventsByDateRange");
        String fullPath = "/{pp1}/{pp2}";       //  /api/alumniEventsByDateRange
        String token = "bbvHP0IP9p57tpvFL5IMQktaW3JoN6";

        // body (start: "2021-01-14 00:00:00", end: "2023-03-15 23:59:00")
        //{
        //        "start": "2021-01-14 00:00:00"",
        //        "end": "2023-03-15 23:59:00"
        //}

        JSONObject reqBody = new JSONObject();
        reqBody.put("start","2021-01-14 00:00:00");
        reqBody.put("end","2023-03-15 23:59:00");




        Response response = given()
                .contentType(ContentType.JSON)
                .spec(spec)
                .headers(
                        "Authorization","Bearer "+token,
                        "Content-Type",ContentType.JSON, // gönderdigim bilgilerin formatı JSON
                        "Accept",ContentType.JSON               // ben sadece JSON kabul ediyorum
                )
                .when()
                .body(reqBody.toString())
                .log().all()                                    // gönderdiğimiz responsu print ediyor
                .post(fullPath);                                 // ilgili parametrelere get request


        response.prettyPrint();

        // body miz için de liste var, ve biz bu liste üzerinde işlem yapmak istiyoruz
        // listeye ulaşmak için pojo oluşturmamız gerekiyor.





    }
}
