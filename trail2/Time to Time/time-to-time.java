import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startHour = sc.nextInt();
        int startMinute = sc.nextInt();
        int destHour = sc.nextInt();
        int destMinute = sc.nextInt();
        
        System.out.println(destHour * 60 + destMinute - (startHour * 60 + startMinute));
    }
}