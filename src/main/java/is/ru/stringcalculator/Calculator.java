package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("-")){
			if(delim(text)){
			text = cutDown(text);
			}
			String errMessage = negativeNumbers(splitNumbers(text));
                	throw new IllegalArgumentException(errMessage);
		}

		else if (delim(text)){
	
			String s = cutDown(text);
			return sum(splitNumbers(s));
		}

		else if(text.contains(",") || text.contains( "\\n")){
			return sum(splitNumbers(text));
		}
	
		else
			return 1;
	}


	private static String negativeNumbers(String[] numbers){
	String errMessage = "Numbers not allowed: ";
		
	int arrSize = numbers.length;	
		for(String i: numbers){
		
		if(toInt(i) < 0){

			if(arrSize <= 1) errMessage += i;
			else
			errMessage += i + ", ";
		
			}
		}	
		
		return errMessage;
	}

	private static String anyDelim(String text){
		
		int symbolIndex = text.indexOf("[");
		int newLineIndex = text.indexOf("\n");
		String delim = text.substring(symbolIndex + 1, symbolIndex + 2);
		String numbers = text.substring(newLineIndex + 1, text.length());
		String turnToComma = numbers.replace(delim,",");
		String removeCommas = turnToComma.replaceAll(",+", ",");

		return removeCommas;
		
		} 

	private static String cutDown(String text){
		int backSlashIndex = text.indexOf("//");
		 String delim = text.substring(backSlashIndex + 2, backSlashIndex + 3);
		if(delim.equals("[")){
		return anyDelim(text);
		}
		String cutDown = text.replace(delim, ",");
		String replaceNewLine = cutDown.replace("\n", ",");
		 String finalString = replaceNewLine.substring(backSlashIndex + 4, replaceNewLine.length());
		 return finalString;
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

		if(toInt(number) > 1000) total += 0;
	
		else
		    total += toInt(number);
		}
		return total;
    }



}
