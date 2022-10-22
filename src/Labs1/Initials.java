package Labs1;
//За дадено име и презиме на личност кои се внесуваат од стандарден влез,
// да се испечатат иницијалите за таа личност.
import java.util.Scanner;

public class Initials {

    //Steve Jobs -> SJ
    static void printInitials(String name)
    {
        //System.out.print(name.charAt(0)); // == name[0]
        String initials = "";
        initials += name.charAt(0);
        for(int i = 1 ; i < name.length() ; i++) {
            if(name.charAt(i) == ' ') {
                initials += name.charAt(i+1);
            }
        }
        initials = initials.toUpperCase();
        System.out.print(initials);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        String name;
        input.nextLine();

        for(int i=0; i<n; i++){
            name = input.nextLine();
            printInitials(name);
            System.out.println();
        }
    }
}
