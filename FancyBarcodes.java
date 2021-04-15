import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		int numberCode = 0;
		String barcodRegex = "@{1}#+(?<barcod>[A-Za-z0-9]+[0-9]?[a-z]?[A-Z]{1}+)@{1}#+";
		Pattern patternInput = Pattern.compile(barcodRegex);		
		while (number!=numberCode) {
		String input = scanner.nextLine();
		Matcher matcherProduct = patternInput.matcher(input);
		String productGrup = "";
		if (matcherProduct.find()) {	
			 String barcodContent = matcherProduct.group("barcod");
			for (int i = 0; i <= barcodContent.length()-1; i++) {
				char simbol = barcodContent.charAt(i);
				if (Character.isDigit(simbol)) {
					productGrup+=simbol;
				}
			}
			if (productGrup.equals("")) {
				System.out.println("Product group: 00");
			} else {
				System.out.println("Product group: "+ productGrup);
			}
		} else {
			System.out.println("Invalid barcode");
		}			
			numberCode++;
		}
	}
}
