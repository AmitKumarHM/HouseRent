package org.rent.utils;

import org.rent.model.User;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

/**
 * The Class Mail.
 */
public class Mail {

	/** The instance. */
	private static Mail instance = null;

	/**
	 * Instantiates a new mail.
	 */
	private Mail() {
	}

	/**
	 * Gets the single instance of Mail.
	 *
	 * @return single instance of Mail
	 */
	public static Mail getInstance() {
		if (instance == null) {
			instance = new Mail();
		}
		return instance;
	}

	
	public static final String FROM = "rockstarakgj@gmail.com";  // Replace with your "From" address. This address must be verified.
    public static final String STATIC_TO = "p.nimbalkar39@gmail.com"; // Replace with a "To" address. If your account is still in the
    public static final String SUBJECT = "Home Renting Your Password";
	public static final String BODY="<div class='header'><h1>Home Renting</h1></div>"
			+ "<div class='row'> "
			+ "<div class='col-3 col-m-12 menu'><ul>"
			+ "<li>Bangalore</li>"
			+ "<li>Delhi</li>"
			+ "<li>Pune</li>"
			+ "<li>Mumbai</li></ul></div>"+
"<div class='col-6 col-m-9'><h1>The City</h1>"
+"<p>You recently requested for you password</p></br><h2 class='align:center;'>";

public static final String REM_BODY = "</h2></div>"+
"<div class='col-3 col-m-12'><div class='aside'><h2>PG Apartments Flats</h2><p>Lot of new Flats and Apartments</p><h2>Bangalore</h2><p>Finish you search</p><h2>Just go to Home Renting</h2>"+
"<p>Easy and Fast way to search PG Apartment Flats</p></div></div>"+
"</div><div class='footer'><p>To unsubscrible from Home Renting <a>click here</a></p></div></body></html>";

		
public static final String HEAD="<!DOCTYPE html><html><head><meta name='viewport' content='width=device-width, initial-scale=1.0'>"+
"<style> * { box-sizing: border-box; }"+ 
".row::after { content: ''; clear: both; display: table; float: right}"+ 
"[class*='col-'] { float: right; padding: 15px;}"+
"html { font-family: 'Lucida Sans', sans-serif; } .header { background-color: #9933cc; color: #ffffff; padding: 15px; }"+
".menu ul { list-style-type: none;margin: 0;padding: 0; }"+
".menu li { padding: 8px; margin-bottom: 7px; background-color: #33b5e5; color: #ffffff; box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24); }"+
".menu li:hover { background-color: #0099cc; }"+
".aside { background-color: #33b5e5; padding: 15px; color: #ffffff; text-align: center; font-size: 14px; box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24); }"+
".footer { background-color: #0099cc; color: #ffffff; text-align: center; font-size: 12px; padding: 15px; }"+


/* For mobile phones: */
"[class*='col-'] { width: 100%; }"+
"@media only screen and (min-width: 600px) { /* For tablets: */ .col-m-1 {width: 8.33%;} .col-m-2 {width: 16.66%;} .col-m-3 {width: 25%;} .col-m-4 {width: 33.33%;} .col-m-5 {width: 41.66%;} .col-m-6 {width: 50%;}"+
".col-m-7 {width: 58.33%;} .col-m-8 {width: 66.66%;} .col-m-9 {width: 75%;} .col-m-10 {width: 83.33%;} .col-m-11 {width: 91.66%;} .col-m-12 {width: 100%;} }"+
"@media only screen and (min-width: 768px) { /* For desktop: */ .col-1 {width: 8.33%;} .col-2 {width: 16.66%;} .col-3 {width: 25%;} .col-4 {width: 33.33%;} .col-5 {width: 41.66%;}"+
".col-6 {width: 50%;} .col-7 {width: 58.33%;} .col-8 {width: 66.66%;} .col-9 {width: 75%;} .col-10 {width: 83.33%;} .col-11 {width: 91.66%;} .col-12 {width: 100%;} }"+
"</style>"+
"</head><body>";
	
	
	
	
	
public static Boolean mail(User user){
	    Destination destination = new Destination().withToAddresses(new String[]{user.getEmailId()});
	    Content subject = new Content().withData(SUBJECT);
        Content textBody = new Content().withData(HEAD+BODY+user.getPassword()+REM_BODY); 
        Body body = new Body().withHtml(textBody);
        Message message = new Message().withSubject(subject).withBody(body);
        SendEmailRequest request = new SendEmailRequest().withSource(FROM).withDestination(destination).withMessage(message);
        Boolean status=false;
        try{        
            AWSCredentials credentials = new BasicAWSCredentials("AKIAJL6UWNUNC5ETDMUA", "TeWoXmauUAgea4Yn2J6td3qSMnM5GRVGp1Huds2D");
            AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient(credentials);
            Region REGION = Region.getRegion(Regions.US_WEST_2);
            client.setRegion(REGION);
            client.sendEmail(request);  
            System.out.println("Email sent!");
            status=true;
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
		return status;
	}
	
	public static void main1(String...a){
		
		// Construct an object to contain the recipient address.
        Destination destination = new Destination().withToAddresses(new String[]{"rockstarakgj@gmail.com"});
        
        // Create the subject and body of the message.
        Content subject = new Content().withData(SUBJECT);
        Content textBody = new Content().withData(HEAD+BODY); 
        Body body = new Body().withHtml(textBody);
        
        // Create a message with the specified subject and body.
        Message message = new Message().withSubject(subject).withBody(body);
        
        // Assemble the email.
        SendEmailRequest request = new SendEmailRequest().withSource(FROM).withDestination(destination).withMessage(message);
        
        try
        {        
            System.out.println("Attempting to send an email through Amazon SES by using the AWS SDK for Java...");
        
            // Instantiate an Amazon SES client, which will make the service call. The service call requires your AWS credentials. 
            // Because we're not providing an argument when instantiating the client, the SDK will attempt to find your AWS credentials 
            // using the default credential provider chain. The first place the chain looks for the credentials is in environment variables 
            // AWS_ACCESS_KEY_ID and AWS_SECRET_KEY. 
            // For more information, see http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
           
            AWSCredentials credentials = new BasicAWSCredentials("AKIAJL6UWNUNC5ETDMUA", "TeWoXmauUAgea4Yn2J6td3qSMnM5GRVGp1Huds2D");
            AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient(credentials);
               
            // Choose the AWS region of the Amazon SES endpoint you want to connect to. Note that your sandbox 
            // status, sending limits, and Amazon SES identity-related settings are specific to a given AWS 
            // region, so be sure to select an AWS region in which you set up Amazon SES. Here, we are using 
            // the US West (Oregon) region. Examples of other regions that Amazon SES supports are US_EAST_1 
            // and EU_WEST_1. For a complete list, see http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html 
            Region REGION = Region.getRegion(Regions.US_WEST_2);
            client.setRegion(REGION);
       
            // Send the email.
            client.sendEmail(request);  
            System.out.println("Email sent!");
        }
        catch (Exception ex) 
        {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
    			
	}
	
}
