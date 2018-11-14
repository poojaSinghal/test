import java.util.List;
import java.util.Map;

public class WebhookCreateRequest {
  public String name;
  public String url;
  public List<String> events;
  public Map<String,String> filters;
  public Boolean excludeBody;

  public void setName(String name) {
    this.name = name;
  }

  public void setFilters(Map<String, String> filters) {
    this.filters = filters;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }

  public List<String> getEvents() {
    return events;
  }

  public Map<String, String> getFilters() {
    return filters;
  }

  public Boolean getExcludeBody() {
    return excludeBody;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setExcludeBody(Boolean excludeBody) {
    this.excludeBody = excludeBody;
  }

  public void setEvents(List<String> events) {
    this.events = events;
  }


}
