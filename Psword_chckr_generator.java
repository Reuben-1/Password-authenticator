/**
 * Psword_chckr_generator
 */
import java.util.Random;
import java.util.Scanner;
public class Psword_chckr_generator {

    public static void main(String[] args){
       
        System.out.println("This is a password generator/ checker");
        boolean passkey=false;
        boolean upperCase=false;
        boolean lowerCase=false;
        boolean number=false;
        boolean specialCharacter=false;
        Scanner input = new Scanner(System.in);
        int failcount=0;
        char ch;

        while (passkey==false) {
            System.out.println("Password should have atleast 8 characters");
            System.out.println("Password should contain lowercase letters");
            System.out.println("Password should contain Uppercase letters");
            System.out.println("Password should contain atleast 1 special character");
            System.out.println("Password should contain atleast 1 number");
            System.out.println("Enter a password according to the rules");
            String passWord=input.nextLine();
    
            for(int i=0; i<passWord.length();i++){
                ch=passWord.charAt(i);
                if (Character.isUpperCase(ch)) {
                    upperCase=true;
                }
                else if(Character.isLowerCase(ch)){
                    lowerCase=true;
                }
                else if(Character.isDigit(ch)){
                    number=true;
                }
                else if(!Character.isDigit(ch) && !Character.isLetter(ch) && !Character.isWhitespace(ch) ){
                    specialCharacter=true;
                }
            }

            if (passWord.length()<8) {
                System.out.println("Password is less than 8 characters");
            }
            else if(upperCase==false){
                System.out.println("There are no Uppercase letters");
            }
            else if(lowerCase==false){
                System.out.println("There are no Lowercase letters");
            }
            else if(number==false){
                System.out.println("There are no numbers in password");
            }
            else if(specialCharacter==false){
                System.out.println("There are no special characters in password");
            }
            else{
                passkey=true;
                System.out.println("You have successfully created a password");
                input.close();
            }
            failcount++;

            if (failcount==3) {
                System.out.println("Would you like me to recommend a password y/n");
                String y_n= input.nextLine();
                if(y_n.equals("yes")){
                    //String of all characters
                    String values="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";

                        //Random string builder
                    StringBuilder sb= new StringBuilder();

                    //Create Random object
                    Random random_string= new Random();

                    //Specify length of random string
                    int length=8;
                    
                    for(int i=0; i < length; i++){
                        //generate random index number
                        int index= random_string.nextInt(values.length());

                        //get character specified by index from the string
                        char randomchar=values.charAt(index);

                        //append the character to string builder
                        sb.append(randomchar);
                    }
                    
                    String randomString = sb.toString();
                    System.out.println("This is your recommended password "+ randomString);
                    break;
                }
                else{
                    passkey=false;
                    failcount=0;
                }
                
            }
        }
    }

}