
/*1.	Furniture
Write a program to calculate the total cost of different types of furniture.
 You will be given some lines of input until you receive the line "Purchase".
  For the line to be valid it should be in the following format:
">>{furniture name}<<{price}!{quantity}"
The price can be a floating-point number or a whole number.
 Store the names of the furniture and the total price. At the end print each
  bought furniture on a separate line in the format:
"Bought furniture:
{1st name}
{2nd name}
…"
And on the last line print the following: "Total money spend: {spend money}" 
formatted to the second decimal point.
Examples
Input	Output	Comment
>>Sofa<<312.23!3
>>TV<<300!5
>Invalid<<!5
Purchase	Bought furniture:
Sofa
TV
Total money spend: 2436.69	Only the Sofa and the TV are valid, for each of
 them we multiply the price by the quantity and print the result


 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        String regex = ">>(?<furniture>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";
	        String input = scanner.nextLine();
	        Pattern pattern = Pattern.compile(regex);
	        List<String> furnitures = new ArrayList<>();
	        double totalMoney = 0;
	        while (!input.equals("Purchase")) {
	            Matcher matcher = pattern.matcher(input);
	            if (matcher.find()){
	               String furniture = matcher.group("furniture");
	                double price = Double.parseDouble(matcher.group("price"));
	                int quantity = Integer.parseInt(matcher.group("quantity"));
	                furnitures.add(furniture);
	                totalMoney += price*quantity;
	            }
	            input = scanner.nextLine();
	        }
	        System.out.print("Bought furniture:");
	        System.out.println();
	        furnitures.forEach(e -> System.out.println(e));
	        System.out.printf("Total money spend: %.2f",totalMoney);
	    }
	}
