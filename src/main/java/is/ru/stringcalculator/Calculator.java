package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}

		else if (delim(text)){
		String delim = text.substring(text.indexOf("//") + 2, text.indexOf("//") + 3);
		String cutDown = text.replace(delim, ",");
		String replaceNewLine = cutDown.replace("\n", ",");
		String finalString = replaceNewLine.substring(replaceNewLine.indexOf("//")+4, replaceNewLine.length());
		return sum(splitNumbers(finalString));
		}
		else if(text.contains(",") || text.contains( "\\n")){
			return sum(splitNumbers(text));
		}
	
		else
			return 1;
	}

	private static Boolean delim(String number){
		if(number.startsWith("//")){
			return true;
		}
	
		return false;
	}
		

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	
	private static String[] splitNumbers(String numbers){
	   
		 return numbers.split(",|\\n");
	}

      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}
