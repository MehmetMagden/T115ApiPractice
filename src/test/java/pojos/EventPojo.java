//package pojos;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//        "status",
//        "message",
//        "Token_remaining_time",
//        "lists"
//})
//@Generated("jsonschema2pojo")
//public class EventPojo {
//
//    @JsonProperty("status")
//    private Integer status;
//    @JsonProperty("message")
//    private String message;
//    @JsonProperty("Token_remaining_time")
//    private Integer tokenRemainingTime;
//    @JsonProperty("lists")
//    private java.util.List<pojos.List> lists;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
//
//    @JsonProperty("status")
//    public Integer getStatus() {
//        return status;
//    }
//
//    @JsonProperty("status")
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    @JsonProperty("message")
//    public String getMessage() {
//        return message;
//    }
//
//    @JsonProperty("message")
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    @JsonProperty("Token_remaining_time")
//    public Integer getTokenRemainingTime() {
//        return tokenRemainingTime;
//    }
//
//    @JsonProperty("Token_remaining_time")
//    public void setTokenRemainingTime(Integer tokenRemainingTime) {
//        this.tokenRemainingTime = tokenRemainingTime;
//    }
//
//    @JsonProperty("lists")
//    public java.util.List<pojos.List> getLists() {
//        return lists;
//    }
//
//    @JsonProperty("lists")
//    public void setLists(java.util.List<pojos.List> lists) {
//        this.lists = lists;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//}