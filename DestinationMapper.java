import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 String destination = scanner.nextLine();
	        int count = 0;
	        int countMatch = 0;
	        String simbol = ", ";
	        String regexDestination = "(=|\\/)(?<destination>[A-za-z]{3,}+)\\1";
	        Pattern pattern = Pattern.compile(regexDestination);
	        Matcher matcher = pattern.matcher(destination);
	        StringBuilder nameHoliday = new StringBuilder();
	        System.out.print("Destinations: ");
	        
	        while (matcher.find()){
	        	String nameDestination = matcher.group("destination");    
	            for (int i = 0; i <= nameDestination.length()-1; i++) {
					count+=1;
				}
	            if (!nameDestination.toString().equals("noo")) {
	            nameHoliday.append(nameDestination.toString());
	            
	            countMatch+=1;
	            if (countMatch>1) {
		        	System.out.print(", ");
					}         
	            }	   
	            nameHoliday.delete(0, 2);
	           System.out.print(nameDestination.toString());    
		         countMatch+=1;			
	        }
	        System.out.println();
	        System.out.println("Travel Points: "+count);
	    }

	}