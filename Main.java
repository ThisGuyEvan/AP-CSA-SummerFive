import java.util.Scanner;
import java.lang.Math;

class Main {
  public static void main(String[] args) {
    //This is just a restart for easy use.
    boolean run = true;
    while (run){
      Scanner userInput = new Scanner(System.in);
      System.out.println("Input integers.\n");
      int x = userInput.nextInt();
      //Incase there are negatives.
      x = Math.abs(x);
      System.out.println("Digit Range: "+digitRange(x));

      System.out.println("\nRestart? [y/any other]");
      String restart = userInput.next();
      restart = restart.toLowerCase();
      if (restart.equals("y")){run = true;}
      else{userInput.close(); break;}
    }

    // This is for complete no strings.
    /*
    int x = Math.abs(68437);
    System.out.println("Digit Range: "+digitRange(x));
    */


  }



  public static int digitRange(int x){
    int length = (int) (Math.log10(x)+1); //Since math.log10 is undefined (nothing), if I took the int and + 1'd it would output the length. Since in java, the sequence of indexes start from 0.


    System.out.println("Length: " + length);  
    //Initalized variables.
    //Mod by 10 would place a decimal point towards the left therefore singling out a single digit.
    int min = x%10; 
    int max = x%10;
    int digit = 0;

    x = x/10; //This makes it so that the initalized digit would be starting from the length - 1. So if the given integer was 4324 then, x would = 432 because it's a integer and not a float.

    if (length <= 1){ return 1;} //If one digit return 1.

    for (int i = 0; i < length-1; i++){ //Runs length of the given integer - 1.
      digit = x%10;

      if (digit > max){max = digit;} //Checking if the digit is larger than the first initalized maximum.
      if (digit < min){min = digit;} //Checking if the digit is smaller than the first initalized minimum.
      System.out.println("max:min = "+max+":"+min); 
      x = x/10; //After each loop there is one less digit.
    }

    int digitRange = (max - min) + 1;

    return digitRange; //return. (I know I didn't need to create the digitRange variable.)
  }
}