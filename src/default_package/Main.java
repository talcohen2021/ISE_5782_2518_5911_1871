import primitives.*;
import static java.lang.System.out;
import static primitives.Util.*;
import geometries.*;
import unitTests.*;


/*
 * Submitters:

 * Meira Grafstein meiragrafstein@gmail.com 328775911
 * Tali Cohen talcohen@g.jct.ac.il 329651871
 * Yaakovah Bacharach yakovahb@gmail.com 340912518
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
	public static void main(String[] args) {
<<<<<<< HEAD
	      Result result = JUnitCore.runClasses(CameraTest.class);
=======
	      Result result = JUnitCore.runClasses(CameraIntegrationTests.class);
>>>>>>> branch 'main' of https://github.com/talcohen2021/ISE_5782_2518_5911_1871.git
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println("successful? " + result.wasSuccessful());
	   }
}		
		

