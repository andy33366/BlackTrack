/*
 *
 *
 *
 *
 */
import org.json.*;
import java.util.Scanner;


public class BlackTrack{

	public static void main(String[] args){


		String username = "";
		String password = "";

		Scanner input = new Scanner(System.in);
	
		System.out.println("Welcome to BlackTrack\nIn order to access the Blackboard API, you will need to give the program your login information.");
		System.out.print("Username:");
		username = input.nextLine();
		System.out.print("Password:");
		password = input.nextLine();
		//
	}
	//get request to get necessary cookies and log in
	public static void login(String username, String password){
		//make a get request to /ultra/grades
		//grab AWSELB and AWSELBCORS
		//
		//make get request to /?new_loc=%2Fultra%2Fgrades
		//send AWSELB, AWSELBCORS, and COOKIE_CONSENT_ACCEPTED=true
		//grab JSESSIONID and BbRouter
		//
		//make login request /webapps/login/
		//
		//get roles to get userId /learn/api/v1/users/me?expand=systemRoles,insRoles
		//
		//
	}
	//api call to get classes
	public static String[] getClasses(){
		//get /learn/api/v1/users/<userId>/memberships?expand=course.effectievAvailability&includeCount=true&limit=10000
	}
	//api call to get grades
	public static int[] getGrades(classes){
	}
	//calculate gpa based on grades
	public static double calcGPA(grades){
	}
	//print message based on gpa
	public static void printMessage(gpa){
	}
}
