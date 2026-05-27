import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int startHour = sc.nextInt();
        int startMinute = sc.nextInt();
        int destHour = sc.nextInt();
        int destMinute = sc.nextInt();
        int elapsed = 0;

        while (true) {
            if (startHour == destHour && startMinute == destMinute) {
                break;
            }
            elapsed++;
            startMinute++;
            if (startMinute == 60) {
                startMinute = 0;
                startHour++;
            }
        }
        System.out.println(elapsed);
    }
}