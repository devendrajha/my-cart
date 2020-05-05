package io.smartnexus.ats.mqtt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;


public class MqttApp implements MqttCallback,Runnable {
	
	public  List list=null;
	public MqttApp(){}
  
  public static void mqttNotification() {

    boolean quietMode   = false;
    String action     = "subscribe";
    String topic    = "";
    String message    = "Message from blocking Paho MQTTv3 Java client sample";
    int qos       = 2;
    String broker     = "test.mosquitto.org";
    int port      = 1883;
    String clientId   = null;
    String subTopic   = "test/MqttNotification";
    String pubTopic   = "Sample/Java/v3";
    boolean cleanSession = true;      // Non durable subscriptions
    boolean ssl = false;
    String password = null;
    String userName = null;
    // Parse the arguments -

    // Validate the provided arguments
    if (!action.equals("publish") && !action.equals("subscribe")) {
      System.out.println("Invalid action: "+action);
      printHelp();
      return;
    }
    if (qos < 0 || qos > 2) {
      System.out.println("Invalid QoS: "+qos);
      printHelp();
      return;
    }
    if (topic.equals("")) {
      // Set the default topic according to the specified action
      if (action.equals("publish")) {
        topic = pubTopic;
      } else {
        topic = subTopic;
      }
    }

    String protocol = "tcp://";

    if (ssl) {
      protocol = "ssl://";
    }

    String url = protocol + broker + ":" + port;

    if (clientId == null || clientId.equals("")) {
      clientId = "SampleJavaV3_"+action;
    }

    // With a valid set of arguments, the real work of
    // driving the client API can begin
    try {
      // Create an instance of this class
      MqttApp ClientMqtt = new MqttApp(url, clientId, cleanSession, quietMode,userName,password);

      // Perform the requested action
      if (action.equals("publish")) {
        ClientMqtt.publish(topic,qos,message.getBytes());
      } else if (action.equals("subscribe")) {
        ClientMqtt.subscribe(topic,qos);
      }
    } catch(MqttException me) {
      // Display full details of any exception that occurs
      System.out.println("reason "+me.getReasonCode());
      System.out.println("msg "+me.getMessage());
      System.out.println("loc "+me.getLocalizedMessage());
      System.out.println("cause "+me.getCause());
      System.out.println("excep "+me);
      me.printStackTrace();
    }
  }

  // Private instance variables
  private MqttClient      client;
  private String        brokerUrl;
  private boolean       quietMode;
  private MqttConnectOptions  conOpt;
  private boolean       clean;
  private String password;
  private String userName;

  /**
   * Constructs an instance of the sample client wrapper
   * @param brokerUrl the url of the server to connect to
   * @param clientId the client id to connect with
   * @param cleanSession clear state at end of connection or not (durable or non-durable subscriptions)
   * @param quietMode whether debug should be printed to standard out
   * @param userName the username to connect with
   * @param password the password for the user
   * @throws MqttException
   */
    public MqttApp(String brokerUrl, String clientId, boolean cleanSession, boolean quietMode, String userName, String password) throws MqttException {
      this.brokerUrl = brokerUrl;
      this.quietMode = quietMode;
      this.clean     = cleanSession;
      this.password = password;
      this.userName = userName;
      //This sample stores in a temporary directory... where messages temporarily
      // stored until the message has been delivered to the server.
      //..a real application ought to store them somewhere
      // where they are not likely to get deleted or tampered with
      String tmpDir = System.getProperty("java.io.tmpdir");
      MqttDefaultFilePersistence dataStore = new MqttDefaultFilePersistence(tmpDir);

      try {
        // Construct the connection options object that contains connection parameters
        // such as cleanSession and LWT
        conOpt = new MqttConnectOptions();
        conOpt.setCleanSession(clean);
        if(password != null ) {
          conOpt.setPassword(this.password.toCharArray());
        }
        if(userName != null) {
          conOpt.setUserName(this.userName);
        }

        // Construct an MQTT blocking mode client
      client = new MqttClient(this.brokerUrl,clientId, dataStore);

      // Set this wrapper as the callback handler
        client.setCallback(this);

    } catch (MqttException e) {
      e.printStackTrace();
      log("Unable to set up client: "+e.toString());
      System.exit(1);
    }
    }

    /**
     * Publish / send a message to an MQTT server
     * @param topicName the name of the topic to publish to
     * @param qos the quality of service to delivery the message at (0,1,2)
     * @param payload the set of bytes to send to the MQTT server
     * @throws MqttException
     */
    public void publish(String topicName, int qos, byte[] payload) throws MqttException {

      // Connect to the MQTT server
      log("Connecting to "+brokerUrl + " with client ID "+client.getClientId());
      client.connect(conOpt);
      log("Connected");

      String time = new Timestamp(System.currentTimeMillis()).toString();
      log("Publishing at: "+time+ " to topic \""+topicName+"\" qos "+qos);

      // Create and configure a message
      MqttMessage message = new MqttMessage(payload);
      message.setQos(qos);

      // Send the message to the server, control is not returned until
      // it has been delivered to the server meeting the specified
      // quality of service.
      client.publish(topicName, message);

      // Disconnect the client
      client.disconnect();
      log("Disconnected");
    }

    /**
     * Subscribe to a topic on an MQTT server
     * Once subscribed this method waits for the messages to arrive from the server
     * that match the subscription. It continues listening for messages until the enter key is
     * pressed.
     * @param topicName to subscribe to (can be wild carded)
     * @param qos the maximum quality of service to receive messages at for this subscription
     * @throws MqttException
     */
    public void subscribe(String topicName, int qos) throws MqttException {
      client.connect(conOpt);
      log("Connected to "+brokerUrl+" with client ID "+client.getClientId());
      client.subscribe(topicName, qos);
    try {
		Thread.sleep(6000000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    // Disconnect the client from the server
   // client.disconnect();
    log("Disconnected");
    }

    /**
     * Utility method to handle logging. If 'quietMode' is set, this method does nothing
     * @param message the message to log
     */
    private void log(String message) {
      if (!quietMode) {
        System.out.println(message);
      }
    }

  /****************************************************************/
  /* Methods to implement the MqttCallback interface              */
  /****************************************************************/

    /**
     * @see MqttCallback#connectionLost(Throwable)
     */
  public void connectionLost(Throwable cause) {
    // Called when the connection to the server has been lost.
    // An application may choose to implement reconnection
    // logic at this point. This sample simply exits.
    log("Connection to " + brokerUrl + " lost!" + cause);
    System.exit(1);
  }

    /**
     * @see MqttCallback#deliveryComplete(IMqttDeliveryToken)
     */
  public void deliveryComplete(IMqttDeliveryToken token) {
    // Called when a message has been delivered to the
    // server. The token passed in here is the same one
    // that was passed to or returned from the original call to publish.
    // This allows applications to perform asynchronous
    // delivery without blocking until delivery completes.
    //
    // This sample demonstrates asynchronous deliver and
    // uses the token.waitForCompletion() call in the main thread which
    // blocks until the delivery has completed.
    // Additionally the deliveryComplete method will be called if
    // the callback is set on the client
    //
    // If the connection to the server breaks before delivery has completed
    // delivery of a message will complete after the client has re-connected.
    // The getPendingTokens method will provide tokens for any messages
    // that are still to be delivered.
  }

    /**
     * @see MqttCallback#messageArrived(String, MqttMessage)
     */
  public void messageArrived(String topic, MqttMessage message) throws MqttException {
    // Called when a message arrives from the server that matches any
    // subscription made by the client
    String time = new Timestamp(System.currentTimeMillis()).toString();
    System.out.println("Time:\t" +time +
                           "  Topic:\t" + topic +
                           "  Message:\t" + new String(message.getPayload()) +
                           "  QoS:\t" + message.getQos());
    
    list=new ArrayList<>();
    list.add(new String(message.getPayload()));
  }

  /****************************************************************/
  /* End of MqttCallback methods                                  */
  /****************************************************************/

     static void printHelp() {
        System.out.println(
            "Syntax:\n\n" +
                "    Sample [-h] [-a publish|subscribe] [-t <topic>] [-m <message text>]\n" +
                "            [-s 0|1|2] -b <hostname|IP address>] [-p <brokerport>] [-i <clientID>]\n\n" +
                "    -h  Print this help text and quit\n" +
                "    -q  Quiet mode (default is false)\n" +
                "    -a  Perform the relevant action (default is publish)\n" +
                "    -t  Publish/subscribe to <topic> instead of the default\n" +
                "            (publish: \"Sample/Java/v3\", subscribe: \"Sample/#\")\n" +
                "    -m  Use <message text> instead of the default\n" +
                "            (\"Message from MQTTv3 Java client\")\n" +
                "    -s  Use this QoS instead of the default (2)\n" +
                "    -b  Use this name/IP address instead of the default (m2m.eclipse.org)\n" +
                "    -p  Use this port instead of the default (1883)\n\n" +
                "    -i  Use this client ID instead of SampleJavaV3_<action>\n" +
                "    -c  Connect to the server with a clean session (default is false)\n" +
                "     \n\n Security Options \n" +
                "     -u Username \n" +
                "     -z Password \n" +
                "     \n\n SSL Options \n" +
                "    -v  SSL enabled; true - (default is false) " +
                "    -k  Use this JKS format key store to verify the client\n" +
                "    -w  Passpharse to verify certificates in the keys store\n" +
                "    -r  Use this JKS format keystore to verify the server\n" +
                " If javax.net.ssl properties have been set only the -v flag needs to be set\n" +
                "Delimit strings containing spaces with \"\"\n\n" +
                "Publishers transmit a single message then disconnect from the server.\n" +
                "Subscribers remain connected to the server and receive appropriate\n" +
                "messages until <enter> is pressed.\n\n"
            );
    }

@Override
public void run() {
	mqttNotification();
	
}

}