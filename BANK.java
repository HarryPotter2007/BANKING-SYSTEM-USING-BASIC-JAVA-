import java.util.Scanner;

public class BANK {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int balance = 0;


        System.out.print("SET YOUR 4-DIGIT PIN: ");
        int userPIN = sc.nextInt();


        int attempts = 3;

        while (attempts > 0) {
            System.out.print("ENTER YOUR PIN TO LOGIN: ");
            int pin = sc.nextInt();

            if (pin == userPIN) {
                System.out.println("✅ LOGIN SUCCESSFUL! WELCOME 🏦");
                break;
            } else {
                attempts--;
                System.out.println("❌ WRONG PIN! Attempts left: " + attempts);
            }
        }


        if (attempts == 0) {
            System.out.println("🚫 ACCOUNT LOCKED! TOO MANY WRONG ATTEMPTS.");
            sc.close();
            return;
        }


        String continueBanking = "YES";

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. CHECK BALANCE");
            System.out.println("2. WITHDRAW AMOUNT");
            System.out.println("3. DEPOSIT AMOUNT");
            System.out.println("4. EXIT");
            System.out.print("ENTER YOUR CHOICE: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("✅ CURRENT BALANCE: " + balance);
                    break;

                case 2:
                    System.out.print("ENTER WITHDRAW AMOUNT: ");
                    int withdraw = sc.nextInt();

                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("✅ WITHDRAW SUCCESSFUL!");
                        System.out.println("BALANCE NOW: " + balance);
                    } else {
                        System.out.println("❌ INSUFFICIENT BALANCE / INVALID AMOUNT!");
                    }
                    break;

                case 3:
                    System.out.print("ENTER DEPOSIT AMOUNT: ");
                    int deposit = sc.nextInt();

                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("✅ DEPOSIT SUCCESSFUL!");
                        System.out.println("BALANCE NOW: " + balance);
                    } else {
                        System.out.println("❌ INVALID DEPOSIT AMOUNT!");
                    }
                    break;

                case 4:
                    System.out.println("🙏 THANK YOU FOR USING BANK SYSTEM!");
                    continueBanking = "NO";
                    break;

                default:
                    System.out.println("❌ INVALID CHOICE, TRY AGAIN!");
            }

            if (!continueBanking.equals("NO")) {
                System.out.print("\nDO YOU WANT TO CONTINUE (YES/NO): ");
                continueBanking = sc.next().toUpperCase();
            }

        } while (continueBanking.equals("YES"));

        sc.close();
    }
}
