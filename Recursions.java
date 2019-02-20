import java.util.Scanner;

public class Recursions {

	//-------------1st Function Question 8 Chapter 10-------------//
	private static boolean changeableNumber(int numToCheck) {
		
		if(numToCheck / 10 == 0){
			return true;
		}
		if((numToCheck%10) == 1 || (numToCheck/10%10) == 1){
			if((numToCheck%10) % 2 == 0 || (numToCheck/10%10) % 2 == 0){
				return changeableNumber(numToCheck/10);
			}
		}
		if((numToCheck%10) % 2 == 0 && (numToCheck/10%10) % 2 != 0 || (numToCheck/10%10) % 2 == 0 && (numToCheck%10) % 2 != 0) {
			return changeableNumber(numToCheck/10);
		}
			return false;
	}
	
	//-------------2nd Function Question 9 Chapter 10-------------//
	private static boolean toSearchIn(int numToSearchIn) {
		
		if(numToSearchIn/10 == 0)
			return false;
		
		if((numToSearchIn%10) % 2 == 0 && (numToSearchIn/10%10) % 2 != 0 || (numToSearchIn/10%10) % 2 == 0 && (numToSearchIn%10) % 2 != 0) 
			return true;
		else 
			return toSearchIn(numToSearchIn/10);
	}
	
	//-------------3rd Function Question 10 Chapter 10-------------//
	private static int restOfDivision(int num1, int num2) {

		if((num1-num2) == 0 && num1 != 0)
			return 0;
		
		if((num1-num2) < 0)
			return 1;
		
		return restOfDivision(num1-num2,num2);
	}

	//-------------4th Function Question 11 Chapter 10-------------//
		public static void switchLetters(String str, int indexBegin, int indexEnd){

		String str1="";

		if (indexBegin == indexEnd)
		return;
		
		String newString = str.substring(indexBegin, indexBegin+1);
		str1 = newString + str1;
		switchLetters(str,(indexBegin+1),(indexEnd));
		System.out.printf("%s",str1);
		
		}
		
	//-------------5th Function Question 13 Chapter 10-------------//
		private static void numToConvert(int numToConvert) {
			
			if(numToConvert == 0)
				return;
			
			numToConvert(numToConvert/2);
			
			if(numToConvert % 2 == 0)
			System.out.printf("%d",0);
			else
				System.out.printf("%d",1);
		}
		
	//-------------6th Function Question 16 Chapter 10-------------//
		public static int fromStrToHexadecimalNum(String str){
			
			if(str.length()==0)
				return 0;
			
			if(65 <= str.charAt(0) && str.charAt(0) <= 70)
				return ((str.charAt(0)-55)*(int)Math.pow((double)16,(double)str.length()-1)) + fromStrToHexadecimalNum(str.substring(1));
			else 
				return ((str.charAt(0)-48)*(int)Math.pow((double)16,(double)str.length()-1)) + fromStrToHexadecimalNum(str.substring(1));
		}
		
	//-------------7th Function Question 18 Chapter 10-------------//
		private static int checkTheChar(String[] stringArray, int sizeArray, char charToSearch) {
			
			if(sizeArray == 0)
				return 0;
			
			if(stringArray[sizeArray-1].indexOf(charToSearch) != -1)
				return checkHowMany(stringArray[sizeArray-1],charToSearch) + checkTheChar(stringArray,sizeArray-1,charToSearch);
			else
				return checkTheChar(stringArray,sizeArray-1,charToSearch);
		}
		//----Sub-function For Question 18 Chapter 10----//
		private static int checkHowMany(String stringToCheck, char charToSearch) {
				
				int counter = 0;
				char[] stringArray = stringToCheck.toCharArray();
				
				for(int i =0 ; i<stringToCheck.length() ; i++){
					if(stringArray[i]==charToSearch)
						counter++;
				}
				return counter;
			}
		
	//-------------8th Function Question 20 Chapter 10-------------//
			
		private static int valueToCheck(int valueToCheck) {

			if(valueToCheck <= 3){
				return valueToCheck;
			}
			if(valueToCheck % 2 == 0)
				return valueToCheck(valueToCheck-1) + valueToCheck(valueToCheck-2) + valueToCheck(valueToCheck-3);
			else
				return valueToCheck(valueToCheck-1) - valueToCheck(valueToCheck-3);
		}

	//-------------8th Function Question 22 Chapter 10-------------//
		
		private static Object drawToolbar(int numToDraw) {
			
			if(numToDraw==0)
				return null;
			
			System.out.printf("-\n");
			System.out.printf("--\n");
			System.out.printf("-\n");
			
			if(numToDraw >1)
				System.out.printf("---\n");
			
			return drawToolbar(numToDraw-1);

		}

		//--------------------------------------------------------------------------------------Main-------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		boolean checker = true;

		do{
			System.out.println("\nHi! And Welcome to Shalev Lazarof Recursion Program\n\n"
					+ "Question 8 in Chapter 10:  Will check if the number is a changeable Number\n"
					+ "                           >>> For This Question Press 8\n\n"
					+ "Question 9 in Chapter 10:  Will check if theres at least 1 couple of changeable Numbers\n"
					+ "                           >>> For This Question Press 9\n\n"
					+ "Question 10 in Chapter 10: Will return the rest Of The Division Between 2 numbers\n"
					+ "                           >>> For This Question Press 10\n\n"
					+ "Question 11 in Chapter 10: Will recieve a string and flip it\n"
					+ "                           >>> For This Question Press 11\n\n"
					+ "Question 13 in Chapter 10: Will receive a Decimal number and return it in base 2 configuration\n"
					+ "                           >>> For This Question Press 13\n\n"
					+ "Question 18 in Chapter 10: Will recieve String array and a letter and return the number of times\n"
					+ "                           the letters appears in the array\n"
					+ "                           >>> For This Question Press 18 \n\n"
					+ "Question 20 in Chapter 10: Will return the organ value that you will enter\n"
					+ "                           >>> For this question press 20\n\n"
					+ "Question 22 in Chapter 10: Will Draw Toolbar Tick\n"
					+ "                           >>> For this question press 22\n\n");
		
		System.out.printf("\nPlease enter your choise:");
		int qNum = s.nextInt();
		
		switch(qNum){
		
		//--Case 8--//
		case 8:{
			int numToCheck;
			
			System.out.printf("Please Enter A Number: ");
			numToCheck = s.nextInt();
			
			if(changeableNumber(numToCheck))
				System.out.print("The Number is A Changeable Number\n");
			else
				System.out.print("The Number is Not A Changeable Number\n");

			break;
		}
		
		//--Case 9--//
		case 9:{
			int numToSearchIn;
			
			System.out.printf("Please enter a Number: ");
			numToSearchIn = s.nextInt();
			
			if(toSearchIn(numToSearchIn))
				System.out.printf("The Number --Have-- 2 Changeable Numbers");
			else
				System.out.printf("The Number --Do Not Have-- 2 Changeable Numbers\n");
			
			break;
		}
		
		//--Case 10--//
		case 10:{
			int num1;
			int num2;
			
			System.out.printf("Please Enter The First Number:");
			num1 = s.nextInt();
			System.out.printf("Please Enter The Second Number:");
			num2 = s.nextInt();
			
			System.out.printf("The Rest Of The Division Between The 2 Numbers is:%d",restOfDivision(num1,num2));
		
			break;
		}
		
		//--Case 11--//
		case 11:{
			String str;
			
			System.out.printf("Please enter String in order To Switch it:");
			str = s.next();
			
			switchLetters(str,0,str.length());
			
			break;
		}
		
		//--Case 13--//
		case 13:{
			int numToConvert;
			
			System.out.printf("Please enter a Number:");
			numToConvert = s.nextInt();
			
			numToConvert(numToConvert);
			
			break;
		}
		
		//--Case 16--//
		case 16:{
			String str;
			
			System.out.printf("Please enter a String:");
			str = s.next();
			
			System.out.printf("%d\n",fromStrToHexadecimalNum(str));
			
			break;
		}	
		
		//--Case 18--//
		case 18:{
			
			int sizeArray;
			char charToSearch;
			
			System.out.printf("Please enter The Number:");
			sizeArray = s.nextInt();
			
			String[] stringArray = new String[sizeArray];
			
			for(int i = 0; i < stringArray.length ; i++){
				System.out.printf("enter a String Please:");
				stringArray[i] = s.next();
			}
			
			System.out.printf("Please enter a Char That You Would Like To Know How Many Times it Appears in The Array");
			charToSearch = s.next().charAt(0);
			
			System.out.printf("The Letter Show Up In The Array %d Times\n",checkTheChar(stringArray,sizeArray,charToSearch));
			
			break;
		}
		
		//--Case 20--//
		case 20:{
			
			int valueToCheck;
			
			System.out.printf("What Value Of Series You Want To Know?");
			valueToCheck = s.nextInt();
			
			System.out.printf("The Value is: %d",valueToCheck(valueToCheck));
			
			break;
		}
		
		//--Case 22--//
		case 22:{
			
			int numToDraw;
			
			System.out.printf("Please enter a Number:");
			numToDraw = s.nextInt();
			
			drawToolbar(numToDraw);
			
			break;
		}

		case 0:{
			checker = false;
			break;
		}
		default:
			System.out.println("invalid number, try again please");
			break;
		}
		
		}while(checker);
	
	System.out.println("Thank you, Have a great day");
	}

	private static int pow(int i, int letterCounter) {
		// TODO Auto-generated method stub
		return 0;
	}

}
