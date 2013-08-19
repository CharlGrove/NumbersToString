public class Main {
	
	public static void main(String[] args) {
		// Examples provided
		
		System.out.println(1);
		System.out.println(getNumberWords(1));
		
		System.out.println(27);
		System.out.println(getNumberWords(27));
		
		System.out.println(115);
		System.out.println(getNumberWords(115));
		
		System.out.println(3700);
		System.out.println(getNumberWords(3700));
		
		System.out.println(56945781);
		System.out.println(getNumberWords(56945781));
		
		System.out.println(126000010);
		System.out.println(getNumberWords(126000010));
		
		System.out.println(999999999);
		System.out.println(getNumberWords(999999999));
		
	}
	
	/**
	 * 
	 * @param number
	 * @return Wording for number provided
	 */
	
	private static String getNumberWords(int number) {
		String numString = Integer.toString(number);
		String returnString = "";
		
		// calculate length to see if it is in millions/thousands or less
		int len = numString.length();
		
		if (len > 6) { // millions
			String mil = numString.substring(0, len - 6);
			returnString += getMillions(mil);
			
			String thousand = numString.substring(len - 6, len - 3);
			returnString += getThousands(thousand);
			
			String hundred = numString.substring(len - 3);
			returnString += getHundreds(hundred);
			
		} else if (len > 3) { // thousands
			String thousand = numString.substring(0, len - 3);
			returnString += getThousands(thousand, true);
			
			String hundred = numString.substring(len - 3);
			returnString += getHundreds(hundred);
		} else if (len < 3) { // less than thousand
			returnString += getHundreds(numString, true);
		} else {
			returnString += "Number exceeded 999 999 999";
		}
		return returnString.trim();
	}
	
	/**
	 * 
	 * @param million
	 * @return Wording of the millions
	 */
	
	private static String getMillions(String million) {
		return getMillions(million, false);
	}
	
	/**
	 * 
	 * @param million
	 * @param isFirst If it is the first word we dont start the return value with 'and'
	 * @return Wording of the millions 
	 */
	
	private static String getMillions(String million, boolean isFirst) {
		if (million.equals("000")) {
			return "";
		} else {
			return getThreeDigitWord(Integer.parseInt(million), isFirst) + " million";
		}
	}
	
	/**
	 * 
	 * @param thousand
	 * @return Wording of thousands
	 */
	
	private static String getThousands(String thousand) {
		return getThousands(thousand, false);
	}
	
	/**
	 * 
	 * @param thousand
	 * @param isFirst If it is the first word we dont start the return value with 'and'
	 * @return Wording of thousands
	 */
	
	private static String getThousands(String thousand, boolean isFirst) {
		if (thousand.equals("000")) {
			return "";
		} else {
			return getThreeDigitWord(Integer.parseInt(thousand), isFirst) + " thousand";
		}
	}
	
	/**
	 * 
	 * @param hundred
	 * @return Wording of numbers lower than thousand
	 */
	
	private static String getHundreds(String hundred) {
		return getHundreds(hundred, false);
	}
	
	/**
	 * 
	 * @param hundred
	 * @param isFirst If it is the first word we dont start the return value with 'and'
	 * @return Wording of numbers lower than thousand
	 */
	
	private static String getHundreds(String hundred, boolean isFirst) {
		if (hundred.equals("000")) {
			return "";
		} else {
			return getThreeDigitWord(Integer.parseInt(hundred), isFirst);
		}
	}
	
	/**
	 * 
	 * @param number
	 * @param isFirst Is it the first word in the return string
	 * @return The wording for the 3 digits provided
	 */
	
	private static String getThreeDigitWord(int number, boolean isFirst) {
		String returnString = "";
		String numString = Integer.toString(number);
		
		// numbers smaller than 20 has their own wording 
		if (number <= 20 && number > 0) { // numbers 20 and smaller
			return (isFirst ? " "  : " and ") + getSingleWord(number);
		} else if (numString.length() == 2) { //numbers between 21 and 99
			returnString += " " + getTensWord(Integer.parseInt(numString.substring(0, 1)));
			returnString += " " + getSingleWord(Integer.parseInt(numString.substring(1, 2)));
		} else { // 100 to 999
			returnString += " " + getSingleWord(Integer.parseInt(numString.substring(0, 1)));
			returnString += " hundred"; 
			int sub = Integer.parseInt(numString.substring(1, 3));
			if (sub <= 20 && sub > 0) {
				returnString += (isFirst ? " " : " and ") + getSingleWord(sub);
			} else if (sub != 0){
				returnString += (isFirst ? " " : " and ") + getTensWord(Integer.parseInt(numString.substring(1, 2)));
				returnString += " " + getSingleWord(Integer.parseInt(numString.substring(2, 3)));
			}
		}
		return returnString;
	}
	
	/**
	 * 
	 * @param number
	 * @return The wording for numbers between 1 and 20
	 */
	
	private static String getSingleWord(int number) {
		switch (number) {
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4:
			return "four";
		case 5:
			return "five";
		case 6:
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 14:
			return "fourteen";
		case 15:
			return "fifteen";
		case 16:
			return "sixteen";
		case 17:
			return "seventeen";
		case 18:
			return "eighteen";
		case 19:
			return "nineteen";
		case 20:
			return "twenty";
		default:
			return "";
		}
	}
	
	/**
	 * 
	 * @param number
	 * @return Wording for tens
	 */
	
	private static String getTensWord(int number) {
		switch (number) {
		case 2:
			return "twenty";
		case 3:
			return "thirty";
		case 4:
			return "forty";
		case 5:
			return "fifty";
		case 6:
			return "sixty";
		case 7:
			return "seventy";
		case 8:
			return "eighty";
		case 9:
			return "ninety";
		default:
			return "";
		}
	}
	
}
