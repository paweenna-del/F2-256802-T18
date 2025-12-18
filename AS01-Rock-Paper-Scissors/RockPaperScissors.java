import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int rating = 0;
        int winStreak = 0;
        int loseStreak = 0;

        int totalGames = 0;
        int wins = 0;
        int draws = 0;
        int loses = 0;

        // รับชื่อผู้เล่น
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("\nHello, " + name + "!");
        System.out.println("Let's play Rock-Paper-Scissors!");
        System.out.println("Type rock, paper, scissors or !exit to quit.\n");

        while (true) {
            System.out.print("> ");
            String player = sc.nextLine().toLowerCase();

            // ผู้เล่นอยากออกจากเกม
            if (player.equals("!exit")) {
                break;
            }

            // ตรวจสอบ input ผิด
            if (!player.equals("rock") &&
                !player.equals("paper") &&
                !player.equals("scissors")) {

                System.out.println("Invalid input!\n");
                continue;
            }

            totalGames++;

            // คอมพิวเตอร์สุ่มเลือก 1 ใน 3
            String[] choices = {"rock", "paper", "scissors"};
            String computer = choices[rand.nextInt(3)];

            System.out.println("Computer chose: " + computer);

            // เกมเสมอ
            if (player.equals(computer)) {
                System.out.println("Result: Draw");
                rating += 1;
                draws++;

                winStreak = 0;
                loseStreak = 0;
            }
            // ผู้เล่นชนะ
            else if (
                (player.equals("rock") && computer.equals("scissors")) ||
                (player.equals("paper") && computer.equals("rock")) ||
                (player.equals("scissors") && computer.equals("paper"))
            ) {
                System.out.println("Result: You Win!");
                wins++;

                rating += 3;
                winStreak++;

                // Win Streak Bonus
                if (winStreak == 2) {
                    rating += 1;
                    System.out.println("Win Streak Bonus +1");
                } else if (winStreak >= 3) {
                    rating += 2;
                    System.out.println("Win Streak Bonus +2");
                }

                // Comeback Bonus
                if (loseStreak >= 3) {
                    rating += 2;
                    System.out.println("Comeback Bonus +2");
                }

                loseStreak = 0;
            }
            // ผู้เล่นแพ้
            else {
                System.out.println("Result: You Lose");
                loses++;

                loseStreak++;
                winStreak = 0;
            }

            System.out.println("Current Rating: " + rating);
            System.out.println("Win Streak: " + winStreak + " | Lose Streak: " + loseStreak);
            System.out.println();
        }

        // สรุปผล
        System.out.println("\n===== Game Summary =====");
        System.out.println("Player: " + name);
        System.out.println("Total Games: " + totalGames);
        System.out.println("Wins: " + wins);
        System.out.println("Draws: " + draws);
        System.out.println("Loses: " + loses);
        System.out.println("Final Rating: " + rating);
        System.out.println("========================");
        System.out.println("Bye!");

        sc.close();
    }
}
