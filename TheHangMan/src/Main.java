import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        ArrayList<String>Words=new ArrayList<>();
        Words.add("Dog");
        Words.add("Cat");
        Words.add("Java");
        Words.add("Junior");

        int randomword=random.nextInt(Words.size());
       String answer= Words.get(randomword);
        int length = answer.length()+3; /// 3 lives 
        int end=0;
        char[] guessed = new char[answer.length()];
        for (int i = 0; i < guessed.length; i++) {
            guessed[i] = '-';
        }
            for (int i = 0; end <length; i++) {
                if(i==answer.length()){
                    System.out.println("Congratulations you won!");
                    break;
                }

                for (char c : guessed) {
                    System.out.print(c + " ");
                }
                System.out.println();

                char charanswer=answer.toUpperCase().charAt(i) ;

                char useranswer=scanner.next().charAt(0);
                if(useranswer == charanswer){
                    System.out.println("Good answer");
                    guessed[i] = charanswer;

                }
                else if(useranswer != charanswer){
                    System.out.println("Wrong answer");
                    if(i<=0){
                        i=-1;
                    }
                    else i=i-1;
                }
             end++;
            }
    }

}
