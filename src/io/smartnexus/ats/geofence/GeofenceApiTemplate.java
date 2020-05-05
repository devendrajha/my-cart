package io.smartnexus.ats.geofence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.NorthBoundInterface;
import io.smartnexus.ats.utils.Rest;

public class GeofenceApiTemplate {
  private static final Logger log = Logger.getLogger(Geofence.class.getName());
  private Rest rest = new Rest();
  public NorthBoundInterface nbi = new NorthBoundInterface();
  int boundaryId;

  public int addInsideCircleBoundary(String cuid, String name) {
    String apiUrl = Constants.GEOFENCE_SERVICE + "tenant/" + cuid + "/boundary";
    GeofenceObject geofenceObject = new GeofenceObject();
    geofenceObject.setCuid(cuid);
    geofenceObject.setName(name);
    geofenceObject.setAlertType("Inside");
    geofenceObject.setRadius("2000");
    geofenceObject.setType("Circle");
    List<Coordinates> list = new ArrayList<Coordinates>();
    Coordinates coordinates = new Coordinates();
    coordinates.setLat("33.934022");
    coordinates.setLng("-83.536007");
    list.add(coordinates);
    geofenceObject.setCoordinates(list);
    ObjectMapper mapper = new ObjectMapper();
    String jsonStr;
    try {
      jsonStr = mapper.writeValueAsString(geofenceObject);
      HttpResponse response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
      boundaryId = Integer.parseInt(EntityUtils.toString(response.getEntity()));
    } catch (IllegalStateException | IOException e) {
      e.printStackTrace();
    }

    return boundaryId;
  }

  public int addOutsideCircleBoundary(String cuid, String name) {
    String apiUrl = Constants.GEOFENCE_SERVICE + "tenant/" + cuid + "/boundary";
    GeofenceObject geofenceObject = new GeofenceObject();
    geofenceObject.setCuid(cuid);
    geofenceObject.setName(name);
    geofenceObject.setAlertType("Outside");
    geofenceObject.setRadius("2000");
    geofenceObject.setType("Circle");
    List<Coordinates> list = new ArrayList<Coordinates>();
    Coordinates coordinates = new Coordinates();
    coordinates.setLat("22.65008027521057");
    coordinates.setLng("78.59821583409644");
    list.add(coordinates);
    geofenceObject.setCoordinates(list);
    ObjectMapper mapper = new ObjectMapper();
    String jsonStr;
    try {
      jsonStr = mapper.writeValueAsString(geofenceObject);
      HttpResponse response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
      boundaryId = Integer.parseInt(EntityUtils.toString(response.getEntity()));
    } catch (IllegalStateException | IOException e) {
      e.printStackTrace();
    }

    return boundaryId;
  }

  public int addInsidePolygonBoundary(String cuid, String name) {
    String apiUrl = Constants.GEOFENCE_SERVICE + "tenant/" + cuid + "/boundary";
    GeofenceObject geofenceObject = new GeofenceObject();
    geofenceObject.setCuid(cuid);
    geofenceObject.setName(name);
    geofenceObject.setAlertType("Inside");
    geofenceObject.setRadius("2000");
    geofenceObject.setType("Polygon");
    List<Coordinates> list = new ArrayList<Coordinates>();
    Coordinates coordinates = new Coordinates();
    coordinates.setLat("14.791111426040654");
    coordinates.setLng("76.90752150756157");

    Coordinates c1 = new Coordinates();
    c1.setLat("29.31050926787592");
    c1.setLng("57.42595548075474");

    Coordinates c2 = new Coordinates();
    c2.setLat("40.343241057262965");
    c2.setLng("75.94758900991621");

    Coordinates c3 = new Coordinates();
    c3.setLat("32.99084968354169");
    c3.setLng("106.41706941914595");

    Coordinates c4 = new Coordinates();
    c4.setLat("23.1814366510356");
    c4.setLng("93.61813243743813");

    list.add(coordinates);
    list.add(c1);
    list.add(c2);
    list.add(c3);
    list.add(c4);
    geofenceObject.setCoordinates(list);
    ObjectMapper mapper = new ObjectMapper();
    String jsonStr = null;
    HttpResponse response = null;
    try {
      jsonStr = mapper.writeValueAsString(geofenceObject);
      response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
      boundaryId = Integer.parseInt(EntityUtils.toString(response.getEntity()));
    } catch (NumberFormatException | ParseException | IOException e) {
      e.printStackTrace();
    }
    return boundaryId;
  }

  public int addOutsidePolygonBoundary(String cuid, String name) {
    String apiUrl = Constants.GEOFENCE_SERVICE + "tenant/" + cuid + "/boundary";
    GeofenceObject geofenceObject = new GeofenceObject();
    geofenceObject.setCuid(cuid);
    geofenceObject.setName(name);
    geofenceObject.setAlertType("Outside");
    geofenceObject.setRadius("2000");
    geofenceObject.setType("Polygon");
    List<Coordinates> list = new ArrayList<Coordinates>();
    Coordinates coordinates = new Coordinates();
    coordinates.setLat("15.368949896534705");
    coordinates.setLng("9.744873046875");

    Coordinates c1 = new Coordinates();
    c1.setLat("15.376150006326215");
    c1.setLng("9.790253341197968");

    Coordinates c2 = new Coordinates();
    c2.setLat("15.343250925940294");
    c2.setLng("9.809510260820389");

    Coordinates c3 = new Coordinates();
    c3.setLat("15.325930270046422");
    c3.setLng("9.724910035729408");

    Coordinates c4 = new Coordinates();
    c4.setLat("15.365608381773999");
    c4.setLng("9.680939577519894");

    list.add(coordinates);
    list.add(c1);
    list.add(c2);
    list.add(c3);
    list.add(c4);
    geofenceObject.setCoordinates(list);
    ObjectMapper mapper = new ObjectMapper();
    String jsonStr;
    try {
      jsonStr = mapper.writeValueAsString(geofenceObject);
      HttpResponse response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
      boundaryId = Integer.parseInt(EntityUtils.toString(response.getEntity()));
    } catch (IllegalStateException | IOException e) {
      e.printStackTrace();
    }

    return boundaryId;
  }

  public String updateBoundary(String cuid, String name) {
    String apiUrl = Constants.GEOFENCE_SERVICE + "tenant/" + cuid + "/boundary/" + boundaryId;
    Gson gson = new Gson();
    GeofenceObject geofenceObject = new GeofenceObject();
    geofenceObject.setCuid(cuid);
    geofenceObject.setName(name);
    geofenceObject.setAlertType("Inside");
    geofenceObject.setRadius("3000");
    geofenceObject.setType("Circle");
    List<Coordinates> list = new ArrayList<Coordinates>();
    Coordinates coordinates = new Coordinates();
    coordinates.setLat("33.934022");
    coordinates.setLng("-83.536007");
    list.add(coordinates);
    geofenceObject.setCoordinates(list);
    ObjectMapper mapper = new ObjectMapper();
    String jsonStr;
    String responce = null;
    int status = 0;
    try {
      jsonStr = mapper.writeValueAsString(geofenceObject);
      HttpResponse response = rest.putRequest(apiUrl, jsonStr, nbi.getToken());
      responce = EntityUtils.toString(response.getEntity());
      status = response.getStatusLine().getStatusCode();
    } catch (IllegalStateException | IOException e) {
      e.printStackTrace();
    }
    log.debug("updateBoundary " + boundaryId + "  " + status + " ");
    GeofenceObject res = gson.fromJson(responce, GeofenceObject.class);
    return res.getName();
  }

  public int getBoundary(String cuid) {
    String apiUrl = Constants.GEOFENCE_SERVICE + "tenant/" + cuid + "/boundary/";
    int response = 0;
    try {
      response = rest.getStatusCode(apiUrl, nbi.getToken());
    } catch (IllegalStateException e) {
      e.printStackTrace();
    }
    return response;
  }

  public String getBoundaryById(String cuid, int boundaryId) {
    Gson gson = new Gson();
    String apiUrl = Constants.GEOFENCE_SERVICE + "tenant/" + cuid + "/boundary/" + boundaryId;
    GeofenceObject response = gson.fromJson(rest.getJsonWithToken(apiUrl, nbi.getToken()), GeofenceObject.class);
    log.debug("getBoundaryById  " + response.getName());
    return response.getName();
  }

  public int deleteBoundary(String cuid) {
    String apiUrl = Constants.GEOFENCE_SERVICE + "tenant/" + cuid + "/boundary/" + boundaryId;
    int response = 0;
    try {
      response = rest.delete(apiUrl, nbi.getToken());
    } catch (IllegalStateException e) {
      e.getMessage();
    }
    return response;
  }

}
