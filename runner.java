package playfairEncryption;

import java.util.ArrayList;

public class runner {
 public static void main(String args[]) {
	 //build a 5x5 array
	 char[][] population = new char[5][5];
	 String commonKey0 = "puzzle";
	 ArrayList<Character> commonKey = new ArrayList<Character>();
	 
	 //Create alphabet_array array
	 char[] alphabet_array = {'a','b','c','d','e','f','g','h','i','j','k','l','m'
			 ,'n','o','p','q','r','s','t','u','v','w','x','y','z'};
	 
	 ArrayList<Character> alphabet_list = new ArrayList<Character>();


	 //1)Remove Duplicates from Common Key

	 commonKey0 = commonKey0.toLowerCase();
	 commonKey0 = duplicateRemover(commonKey0);
	 
	 //2)Convert String to arrayList
	 for(int x = 0; x < commonKey0.length();x++) {
		 commonKey.add(commonKey0.charAt(x));
	 }
	 System.out.println(commonKey);
	 
	 //3)Create array list of alphabet letters
	 for(int x = 0;x < alphabet_array.length;x++) {
		 alphabet_list.add(alphabet_array[x]);
	 }
	 System.out.println(alphabet_list);
	 
	 //4)Remove letters in common key from letters in array list alphabet
	 for(int x = 0; x < commonKey.size();x++) {
		 alphabet_list.remove((Character)commonKey.get(x));
	 }
	 
	 System.out.println(alphabet_list);
	 
	 //5)Load commonKey into array & load alphabet into array
	 
	 
		 int tracker = 0;
		 int end1 = commonKey.size();
		 int gate1 = 1;
		 
		 int end2 = alphabet_list.size();
		 int gate2 = 0;
		 for(int x = 0; x < 5;x++) {
			 for(int y = 0; y < 5;y++) {
				 //Feed in common key
				 if(gate1 == 1) {
					 
					 if(tracker == end1) {
						 gate1 = 0;
					 	 gate2 = 1;
					 	tracker = -1;
					 }
					 else {
						 population[x][y] = commonKey.get(tracker);
					 }
					 tracker++;
				 }
				 
				 if(gate2 == 1) {
					 population[x][y] = alphabet_list.get(tracker);
					 tracker++;
				 }
			 }
		 }

		 
		 
		 //6) Print out the matrix we will use for our rules of encryption
		 
		 for(int x = 0; x < 5;x++) {
			 for(int y =0;y<5;y++) {
				 System.out.print(population[x][y] + "  ");
			 }
			 System.out.println();
		 }
	 

		 
		 //7)Replace white spaces in cryptographic message
		 
		 char replace = 'X';
		 String plain_text = "The Meeting is at trefforest";
		 String encrypted_text = "";
		 System.out.println(plain_text);
		 
		 plain_text = plain_text.toLowerCase();
		 plain_text = plain_text.replaceAll("\\s+","X");
		 
		 System.out.println(plain_text);

		 
		 //Program Rules---> Different Row & Column
		 //-) Iterate For Loop get X,Y value for first letter
		 //-) Repeat for second letter
		 //-) Compute New First Letter index's
		 //-) Computer New Second Letter index's

		 //Same Row Different Column
		 //Obtain first letter index's
		 //Obtain second letter index's
		 
		 //2nd & 3rd Rule
		 //X stays same
		 //Y + 1
		 
		 //Same Column Different Row
		 //X + 1
		 //Y stays the same
	 
 }
 private static String duplicateRemover(String source) {
	  char[] arrr = source.toCharArray();
	  String target = "";
	  for (char value: arrr) {
	   if (target.indexOf(value) == -1) {
	    target += value;
	   }
	  }
	  return target;
	 }
}
