import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.RestException;
import net.sf.json.JSON;
import net.sf.json.JSONObject;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestWebhookCreation {

  public static void main(String[] args) throws URISyntaxException, IOException, RestException {

    WebhookCreateRequest request = new WebhookCreateRequest();
    request.setName("webhook via rest 5");
    request.setUrl("http://localhost:9654/main?a=b");
    List<String> events = new ArrayList<String>();
    events.add("jira:issue_created");
    events.add("jira:issue_updated");
    request.setEvents(events);
    request.setExcludeBody(false);
    Map<String,String> filters = new HashMap<>();
    filters.put("issue-related-events-section","issuekey = TEST1-24 AND status CHANGED FROM \"In Progress\" TO \"Open\"");
    request.setFilters(filters);

    JSONObject JSON = JSONObject.fromObject(request);
    BasicCredentials creds = new BasicCredentials("pooja.singhal", "tulara@335");
    JiraClient jira = new JiraClient("http://localhost:8080", creds);
    JSON resp =  jira.getRestClient().post(new URI("http://localhost:8080/rest/webhooks/1.0/webhook/"),JSON);
    System.out.println(resp.toString());



  }
}
