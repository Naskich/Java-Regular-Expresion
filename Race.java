import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {

	public static void main(String[] args) {
	     Scanner scanner = new Scanner(System.in);

	        String regexName = "(?<name>[A-Za-z]+)";
	        String regexNumbers = "(?<numbers>[0-9])";

	        List<String> racers = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
	        Map<String, Integer> racerDistans = new LinkedHashMap<>();
	        racers.forEach(racer -> racerDistans.put(racer, 0));

	        String input = scanner.nextLine();

	        Pattern patternName = Pattern.compile(regexName);
	        Pattern patternNumbers = Pattern.compile(regexNumbers);

	        while (!input.equals("end of race")) {

	            Matcher matcherName = patternName.matcher(input);
	            Matcher matcherNumbers = patternNumbers.matcher(input);

	            String nameRacecer = "";

	            while (matcherName.find()) {
	                nameRacecer += matcherName.group();
	            }
	            int distans = 0;
	            while (matcherNumbers.find()) {
	                distans += Integer.parseInt(matcherNumbers.group());
	            }
	            if (racerDistans.containsKey(nameRacecer)) {
	                racerDistans.put(nameRacecer, racerDistans.get(nameRacecer) + distans);
	            }
	            input = scanner.nextLine();
	        }
	        List<String> sorted = racerDistans.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	                .limit(3)
	                .map(Map.Entry::getKey)
	                .collect(Collectors.toList());
	            System.out.println("1st place: "+sorted.get(0));
	            System.out.println("2nd place: "+sorted.get(1));
	            System.out.println("3rd place: "+sorted.get(2));
	        }
	}