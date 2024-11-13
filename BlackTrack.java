/*
 *
 *
 *
 *
 */


import java.net.URI;
import java.net.http.*;
import java.net.HttpURLConnection;
import java.util.Scanner;


public class BlackTrack{

		Static String username = "";
		Static String password = "";
		Static String jSessionID = "";
		Static final String cookieConsent = "COOKIE_CONSENT_ACCEPTED=\"true\"";
		Static String AWSELB = "";
		Static String AWSELBCORS = "";
		Static String BbClientCalendarTimeZone="";
		Static String BbRouter="";

	public static void main(String[] args){


		String jsonResponse="";
		//instead of sending each cookie seperately, maybe i could send all of the cookies at once?
		String cookies="";


		//initializes scanner and HttpClient objects
		Scanner input = new Scanner(System.in);
		HttpClient client = HttpClient.newHttpClient();
	
		System.out.println("Welcome to BlackTrack\nIn order to access the Blackboard API, you will need to give the program your login information. If you are not properly logged in, the program will not be able to access your grades. Make sure you are logged in through DUO authentication.");
		System.out.print("Username:");
		username = input.nextLine();
		System.out.print("Password:");
		password = input.nextLine();
		
		login(username, password, cookieConsent);
	}
	//get request to get necessary cookies and log in
	public static void login(String username, String password, String cookieConsent){
		//make login request /webapps/login/
		//grab all cookies
		HttpRequest init = HttpRequest.newBuilder()
			.uri(new URI("https://tamusa.blackboard.com/webapps/login/"))
			.header("Cookie", cookieConsent)
			.POST(BodyPublishers.ofString("user_id="+username+"&password="+password+"&login=Sign+In&secondaryAuthToken=&showMFARegistration=%24showMFAVerification&showMFASuccessFul=%24showMFASuccessFul&action=login&new_loc=&blackboard.platform.security.NonceUtil.nonce.ajax=thisdoesntworkuseanotherhttprequesttogetthis"))
			.build();
		HttpResponse<String> response =
			client.send(init, BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());
		//get roles to get userId /learn/api/v1/users/me?expand=systemRoles,insRoles
		//
		//
	}
	//api call to get classes
	public static String[] getCourses(){
		//get /learn/api/v1/users/<userId>/memberships?expand=course.effectievAvailability&includeCount=true&limit=10000
		//grab first courseId field
		//append courseId to courses[]
		//once all courses added print out courses.length()
		System.out.println("\nYou are enrolled in "+courses.length()+" courses this semester.");
	}
	//api call to get grades
	public static double[] getGrades(String[] courses){
		//for i in courses[]
		//get /learn/api/v1/courses/<courseId>/gradebook/grades?limit=100&userId=<userId>
		//grab manualGrade and pointsPossible
		//courseGrade = manualgrade/pointspossible
		//append courseGrade to grades[]
	}
	//calculate gpa based on grades
	public static double calcGPA(double[] grades){
		//for grade in grades[] 
		//case grade < 0.65 --> 0.0
		//case grade < 0.67 --> 1.0
		//case grade < 0.7 --> 1.3
		//case grade < 0.73 --> 1.7
		//case grade < 0.77 __> 2.0
		//case grade < 0.8 --> 2.3
		//case grade < 0.83 --> 2.7
		//case grade < 0.87 --> 3.0
		//case grade < 90 --> 3.3
		//case grade < 93 --> 4.0
		//default 4.0
	}
	//print message based on gpa
	public static void printMessage(double gpa){
	}
	public static String updateCookies(String cookies){
		//replace old cookies with new cookies
	}
}
