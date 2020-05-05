package io.smartnexus.ats.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Rest {
  HttpClient client = new DefaultHttpClient();
  private String responseData;
  private int statusCode = 0;
  private JSONObject jsonObj;
  private static final Logger log = Logger.getLogger(Rest.class.getName());
  TestNgParameters tng = new TestNgParameters(); 
  

  public Rest() {
  }

  /**
   * Setting the Basic Authentication for the Application
   * 
   * @return basicAuth
   */
  public String buildAuthHeader() {
    String userpass = tng.getUserName() + ":" + tng.getPassword();
    String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());
    System.out.println(basicAuth);
    return basicAuth;
  }
 public static void main(String[] args) {
  new Rest().buildAuthHeader();
}

  /**
   * Get the API parameters for the given URL
   * 
   * @param url
   * @throws IllegalStateException
   * @throws IOException
   */
  public String getJson(String url, String token) {
    HttpResponse response = null;
    try {
      HttpGet request = new HttpGet(url);
      request.setHeader("Accept", "application/json");
      request.setHeader("Ocp-Apim-Subscription-Key", "e36598b0eb14494bb70e32a2a1c90a4c");
      request.setHeader("Authorization", "Bearer " + token);
      response = client.execute(request);
      responseData = this.readResponseOutput(response);
    } catch (Exception e) {
      log.error("Unable to get the request", e);
    }
    return responseData;

  }

  public String getJsonWithToken(String url, String token) {
    try {
      HttpGet request = new HttpGet(url);
      request.setHeader("Accept", "application/json");
      request.setHeader("Ocp-Apim-Subscription-Key", "e36598b0eb14494bb70e32a2a1c90a4c");
      request.setHeader("Authorization", "Bearer " + token);
      HttpResponse response = client.execute(request);
      responseData = this.readResponseOutput(response);
    } catch (Exception e) {
      log.error("Unable to get the request", e);
    }
    return responseData;

  }

  public String postJsonWithToken(String url, JSONObject jsonObject, String token) {
    try {
      HttpPost post = new HttpPost(url);
      post.setHeader("Authorization", buildAuthHeader());
      post.setHeader("Authorization", "Bearer " + token);
      StringEntity se = new StringEntity(jsonObject.toString());
      post.setEntity(se);
      se.setContentType(ContentType.APPLICATION_JSON.toString());
      HttpResponse response = client.execute(post);
      responseData = this.readResponseOutput(response);
    } catch (Exception e) {
      log.error("Unable to post the request");
    }
    return responseData;

  }

  public int delete(String url, String token) {
    int status = 0;
    try {
      HttpDelete delete = new HttpDelete(url);
      delete.addHeader("Accept", "application/json");
      delete.setHeader("Ocp-Apim-Subscription-Key", "e36598b0eb14494bb70e32a2a1c90a4c");
      delete.setHeader("Authorization", "bearer " + token);
      HttpResponse response = client.execute(delete);
      responseData = this.readResponseOutput(response);
      status = response.getStatusLine().getStatusCode();
    } catch (Exception e) {
      log.error("Unable to delete the request");
    }
    return status;

  }

  /**
   * Put the API parameters
   * 
   * @param url
   * @param json
   * @throws IllegalStateException
   * @throws IOException
   */
  public String putJson(String url, JSONObject json) {
    try {
      HttpPut put = new HttpPut(url);
      put.setHeader("Authorization", buildAuthHeader());
      StringEntity se = new StringEntity(json.toString());
      put.setEntity(se);
      HttpResponse response = client.execute(put);
      responseData = this.readResponseOutput(response);
    } catch (Exception e) {
      log.error("Unable to put the request");
    }
    return responseData;
  }

  /**
   * Post the API parameters
   * 
   * @param url
   * @param jsonArrayData
   * @throws IllegalStateException
   * @throws IOException
   */
  public void postJson(String url, JSONArray jsonArrayData) {
    try {
      HttpPost post = new HttpPost(url);
      post.setHeader("Authorization", buildAuthHeader());
      StringEntity se = new StringEntity(jsonArrayData.toString());
      post.setEntity(se);
      HttpResponse response = client.execute(post);
      this.readResponseOutput(response);
    } catch (Exception e) {
      log.error("Unable to post the request");
    }

  }

  /**
   * Post the API parameters
   */
  public String postJson(String url, JSONObject jsonObject) {
    try {
      HttpPost post = new HttpPost(url);
      post.setHeader("Authorization", buildAuthHeader());
      StringEntity se = new StringEntity(jsonObject.toString());
      post.setEntity(se);
      HttpResponse response = client.execute(post);
      responseData = this.readResponseOutput(response);
    } catch (Exception e) {
      log.error("Unable to post the request");
    }
    return responseData;

  }

  /**
   * Post the API parameters
   */
  public JSONObject postJsonAndGetObject(String url, JSONObject jsonObject) {
    try {
      HttpPost post = new HttpPost(url);
      post.setHeader("Authorization", buildAuthHeader());
      StringEntity se = new StringEntity(jsonObject.toString());
      post.setEntity(se);
      HttpResponse response = client.execute(post);
      responseData = this.readResponseOutput(response);
      JSONParser parser = new JSONParser();
      Object obj = parser.parse(responseData);
      jsonObj = (JSONObject) obj;
    } catch (Exception e) {
      log.error("Unable to post the request");
    }
    return jsonObj;

  }

  public HttpResponse putRequest(String url, String jsonObject, String token) {

    HttpResponse response = null;
    try {
      HttpPut put = new HttpPut(url);
      put.addHeader("Accept", "application/json");
      put.setHeader("Ocp-Apim-Subscription-Key", "e36598b0eb14494bb70e32a2a1c90a4c");
      put.setHeader("Authorization", "bearer " + token);
      StringEntity stringEntity = new StringEntity(jsonObject.toString());
      put.setEntity(stringEntity);
      stringEntity.setContentType(ContentType.APPLICATION_JSON.toString());
      response = client.execute(put);
    } catch (Exception e) {
      log.error("Unable to post the request");
    }
    return response;

  }

  /**
   * Post the API parameters
   */
  public int deleteJson(String url) {
    int status = 0;
    try {
      HttpDelete delete = new HttpDelete(url);
      delete.setHeader("Authorization", buildAuthHeader());
      HttpResponse response = client.execute(delete);
      responseData = this.readResponseOutput(response);
      status = response.getStatusLine().getStatusCode();
    } catch (Exception e) {
      log.error("Unable to post the request", e);
    }
    return status;

  }

  public String readResponseOutput(HttpResponse response) throws IllegalStateException, IOException {
    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
    String line = "";
    String lineResponse = "";
    while ((line = rd.readLine()) != null) {
      lineResponse = lineResponse + line;
    }
    return lineResponse;

  }

  /**
   * Get the API parameters for the given URL
   */
  public String getRequest(String url) {
    try {

      HttpGet request = new HttpGet(url);
      request.setHeader("Authorization", buildAuthHeader());
      HttpResponse response = client.execute(request);
      statusCode = response.getStatusLine().getStatusCode();
      responseData = this.readResponseOutput(response);
    } catch (Exception e) {

      log.error("Unable to get the request", e);
    }
    return responseData;
  }

  /**
   * Put JSON and return the object
   */
  public JSONObject putJsonAndGetObject(String url, JSONObject jsonObject) {
    try {
      HttpPut put = new HttpPut(url);
      put.setHeader("Authorization", buildAuthHeader());
      StringEntity se = new StringEntity(jsonObject.toString());
      put.setEntity(se);
      HttpResponse response = client.execute(put);
      responseData = this.readResponseOutput(response);
      JSONParser parser = new JSONParser();
      Object obj = parser.parse(responseData);
      jsonObj = (JSONObject) obj;
    } catch (Exception e) {
      log.error("Unable to put the request", e);
    }
    return jsonObj;
  }

  /**
   * Post the API parameters as a Array
   */
  public String postJsonArray(String url, JSONArray jsonArray) {
    try {
      HttpPost post = new HttpPost(url);
      post.setHeader("Authorization", buildAuthHeader());
      StringEntity se = new StringEntity(jsonArray.toString());
      post.setEntity(se);
      HttpResponse response = client.execute(post);
      responseData = this.readResponseOutput(response);
    } catch (Exception e) {
      log.error("Unable to post the request", e);
    }
    return responseData;
  }

  public String postJiraApi(String url, JSONObject jsonObject) {
    try {
      HttpPost post = new HttpPost(url);
      post.addHeader("Accept", "application/json");
      post.setHeader("Authorization", buildAuthHeader());
      StringEntity stringEntity = new StringEntity(jsonObject.toString());
      post.setEntity(stringEntity);
      stringEntity.setContentType(ContentType.APPLICATION_JSON.toString());
      HttpResponse response = client.execute(post);
      responseData = response.getStatusLine().toString();
    } catch (Exception e) {
      log.error("Unable to post the request", e);
    }
    return responseData;

  }

  public String getJiraApi(String url) {
    try {
      HttpGet request = new HttpGet(url);
      request.setHeader("Accept", "application/json");
      request.setHeader("Authorization", buildAuthHeader());
      HttpResponse response = client.execute(request);
      responseData = this.readResponseOutput(response);
    } catch (Exception e) {
      log.error("Unable to get the request", e);
    }
    return responseData;

  }

  public HttpResponse postRequest(String url, String jsonInString, String token) {
    HttpResponse response = null;
    try {
      HttpPost post = new HttpPost(url);
      post.addHeader("Accept", "application/json");
      post.setHeader("Ocp-Apim-Subscription-Key", "e36598b0eb14494bb70e32a2a1c90a4c");
      post.setHeader("Authorization", "bearer " + token);
      StringEntity stringEntity = new StringEntity(jsonInString.toString());
      post.setEntity(stringEntity);
      stringEntity.setContentType(ContentType.APPLICATION_JSON.toString());
      response = client.execute(post);
    } catch (Exception e) {
      log.error("Unable to post the request", e);
    }
    return response;

  }

  public HttpResponse postRequest(String uRL, String jsonObject) {
    HttpResponse response = null;
    try {
      HttpPost post = new HttpPost(uRL);
      post.addHeader("Accept", "application/json");
      StringEntity stringEntity = new StringEntity(jsonObject.toString());
      post.setEntity(stringEntity);
      stringEntity.setContentType(ContentType.APPLICATION_JSON.toString());
      response = client.execute(post);
    } catch (Exception e) {
      log.error("Unable to post the request", e);
    }
    return response;

  }

  public HttpResponse putRequestUpdate(String url, String jsonObject, String token) {
    HttpResponse response = null;
    try {
      HttpPut put = new HttpPut(url);
      put.addHeader("Accept", "application/json");
      put.setHeader("Ocp-Apim-Subscription-Key", "e36598b0eb14494bb70e32a2a1c90a4c");
      put.setHeader("Authorization", "bearer " + token);
      StringEntity stringEntity = new StringEntity(jsonObject.toString());
      put.setEntity(stringEntity);
      stringEntity.setContentType(ContentType.APPLICATION_JSON.toString());
      response = client.execute(put);
    } catch (Exception e) {
      log.error("Unable to post the request", e);
    }
    return response;

  }

  public HttpResponse postRequestNotification(String url, String jsonObject, String token) {

    HttpResponse response = null;
    try {
      HttpPost post = new HttpPost(url);
      post.addHeader("Accept", "application/json");
      post.setHeader("Ocp-Apim-Subscription-Key", "e36598b0eb14494bb70e32a2a1c90a4c");
      post.addHeader("Authorization", "Bearer " + token);
      StringEntity stringEntity = new StringEntity(jsonObject.toString());
      post.setEntity(stringEntity);
      stringEntity.setContentType(ContentType.APPLICATION_JSON.toString());
      response = client.execute(post);
    } catch (Exception e) {
      log.error("Unable to post the request", e);
    }
    return response;

  }

  /**
   * Method to post request for Notification API with only URL param
   * 
   * @param url
   * @return HttpResponse
   * @throws IllegalStateException
   * @throws IOException
   */
  public HttpResponse postRequest(String url) {
    HttpResponse response = null;
    try {
      HttpPost post = new HttpPost(url);
      post.addHeader("Accept", "application/json");
      response = client.execute(post);
    } catch (Exception e) {
      log.error("Unable to post the request", e);
    }
    return response;
  }

  public HttpResponse postRequestFileUpload(URL url, String fileLocation, String token) {
    HttpResponse response = null;
    File inFile = new File(fileLocation);
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(inFile);
      HttpPost post = new HttpPost(url.toString());
      post.setHeader("Ocp-Apim-Subscription-Key", "e36598b0eb14494bb70e32a2a1c90a4c");
      post.addHeader("Accept", "application/json");
      post.setHeader("Authorization", "bearer " + token);
      MultipartEntity entity = new MultipartEntity();
      entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
      post.setEntity(entity);
      response = client.execute(post);
    } catch (ClientProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fis != null)
          fis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return response;
  }

  /**
   * Get the API parameters for the given URL
   */
  public int getStatusCode(String url, String token) {
    try {

      HttpGet request = new HttpGet(url);
      request.setHeader("Ocp-Apim-Subscription-Key", "e36598b0eb14494bb70e32a2a1c90a4c");
      request.setHeader("Authorization", "bearer " + token);
      HttpResponse response = client.execute(request);
      statusCode = response.getStatusLine().getStatusCode();
      responseData = this.readResponseOutput(response);
    } catch (Exception e) {  

      log.error("Unable to get the request", e);
    }
    return statusCode;
  }

  public int delete(String url) {
    int status = 0;
    try {
      HttpDelete delete = new HttpDelete(url);
      delete.setHeader("Ocp-Apim-Subscription-Key", "e36598b0eb14494bb70e32a2a1c90a4c");
      delete.addHeader("Accept", "application/json");
      HttpResponse response = client.execute(delete);
      responseData = this.readResponseOutput(response);
      status = response.getStatusLine().getStatusCode();
    } catch (Exception e) {
      log.error("Unable to post the request", e);
    }
    return status;

  }

  public String getWebhook(String url) {
    try {
      HttpGet request = new HttpGet(url);
      request.setHeader("Accept", "application/json");
      request.setHeader("Authorization", "Basic YXV0b3Rlc3Q6QXV0b3Rlc3RAMTIz");
      HttpResponse response = client.execute(request);
      responseData = this.readResponseOutput(response);
    } catch (Exception e) {
      log.error("Webhook server is down ");
    }
    return responseData;

  }

  /**
   * Post the API parameters
   */
  public int deleteWebhook(String url) {
    int status = 0;
    try {
      HttpDelete delete = new HttpDelete(url);
      delete.setHeader("Accept", "application/json");
      delete.setHeader("Authorization", "Basic YXV0b3Rlc3Q6QXV0b3Rlc3RAMTIz");
      HttpResponse response = client.execute(delete);
      responseData = this.readResponseOutput(response);
      status = response.getStatusLine().getStatusCode();
    } catch (Exception e) {
      log.error("Webhook server is down ");
    }
    return status;

  }
  
  
  public HttpResponse agentFileUpload(URL url, String fileLocation, String token) {
	HttpClient client = new DefaultHttpClient();
    HttpResponse response = null;
    File inFile = new File(fileLocation);
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(inFile);
      HttpPost post = new HttpPost(url.toString());
      post.addHeader("Accept", "application/json");
      post.setHeader("Ocp-Apim-Subscription-Key",  token);
      MultipartEntity entity = new MultipartEntity();
      entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
      post.setEntity(entity);
      response = client.execute(post);
    } catch (ClientProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fis != null)
          fis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return response;
  }
  
  public HttpResponse agentPostRequest(String url, String jsonInString, String token) {
   HttpResponse response = null;
   try {
     HttpPost post = new HttpPost(url);
     post.addHeader("Accept", "application/json");
     post.setHeader("Ocp-Apim-Subscription-Key", token);
     StringEntity stringEntity = new StringEntity(jsonInString.toString());
     post.setEntity(stringEntity);
     stringEntity.setContentType(ContentType.APPLICATION_JSON.toString());
     response = client.execute(post);
   } catch (Exception e) {
     log.error("Unable to post the request", e);
   }
   return response;

 }

 
}
