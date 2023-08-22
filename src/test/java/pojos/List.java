package pojos;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "event_for",
        "session_id",
        "class_id",
        "section",
        "from_date",
        "to_date",
        "note",
        "photo",
        "is_active",
        "event_notification_message",
        "show_onwebsite",
        "created_at"
})
@Generated("jsonschema2pojo")
public class List {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("event_for")
    private String eventFor;
    @JsonProperty("session_id")
    private String sessionId;
    @JsonProperty("class_id")
    private Object classId;
    @JsonProperty("section")
    private String section;
    @JsonProperty("from_date")
    private String fromDate;
    @JsonProperty("to_date")
    private String toDate;
    @JsonProperty("note")
    private String note;
    @JsonProperty("photo")
    private Object photo;
    @JsonProperty("is_active")
    private String isActive;
    @JsonProperty("event_notification_message")
    private String eventNotificationMessage;
    @JsonProperty("show_onwebsite")
    private String showOnwebsite;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("event_for")
    public String getEventFor() {
        return eventFor;
    }

    @JsonProperty("event_for")
    public void setEventFor(String eventFor) {
        this.eventFor = eventFor;
    }

    @JsonProperty("session_id")
    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty("session_id")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("class_id")
    public Object getClassId() {
        return classId;
    }

    @JsonProperty("class_id")
    public void setClassId(Object classId) {
        this.classId = classId;
    }

    @JsonProperty("section")
    public String getSection() {
        return section;
    }

    @JsonProperty("section")
    public void setSection(String section) {
        this.section = section;
    }

    @JsonProperty("from_date")
    public String getFromDate() {
        return fromDate;
    }

    @JsonProperty("from_date")
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    @JsonProperty("to_date")
    public String getToDate() {
        return toDate;
    }

    @JsonProperty("to_date")
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    @JsonProperty("photo")
    public Object getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    @JsonProperty("is_active")
    public String getIsActive() {
        return isActive;
    }

    @JsonProperty("is_active")
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("event_notification_message")
    public String getEventNotificationMessage() {
        return eventNotificationMessage;
    }

    @JsonProperty("event_notification_message")
    public void setEventNotificationMessage(String eventNotificationMessage) {
        this.eventNotificationMessage = eventNotificationMessage;
    }

    @JsonProperty("show_onwebsite")
    public String getShowOnwebsite() {
        return showOnwebsite;
    }

    @JsonProperty("show_onwebsite")
    public void setShowOnwebsite(String showOnwebsite) {
        this.showOnwebsite = showOnwebsite;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}