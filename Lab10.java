import java.util.Random;
import java.util.Scanner;

public class Lab10 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Q1();
        Q2();
        Q3();
        Q4();
        scan.close();
    }

    public static void Q1() {
        while (true) {
            System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");
            String input = scan.nextLine();
            if (input.equals("q")) {
                return;
            }
            double sideA, sideB, radius;
            if (input.equals("square")) {
                System.out.println("Enter the length of side a: ");
                sideA = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the square is: " + sideA * 4);
                System.out.println("The area of the square is: " + sideA * sideA);

            } else if (input.equals("rectangle")) {
                System.out.println("Enter the length of side a: ");
                sideA = Double.parseDouble(scan.nextLine());
                System.out.println("Enter the length of side b: ");
                sideB = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the rectangle is: " + (2 * sideA + 2 * sideB));
                System.out.println("The area of the rectangle is: " + (sideA * sideB));
            } else if (input.equals("circle")) {
                System.out.println("Enter the radius: ");
                radius = Double.parseDouble(scan.nextLine());
                System.out.println("The circumference of the circle is: " + (Math.PI * radius * 2));
                System.out.println("The area of the circle is: " + (Math.PI * radius * radius));
            }
        }
    }

    public static void Q2() {
        System.out.println("Q2: Enter the current day (1-31): ");
        int day = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the current month: (1-12)");
        int month = Integer.parseInt(scan.nextLine());

        String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        
        String suffix = getDaySuffix(day);
        System.out.println("You selected " + day + suffix + " of " + months[month]);
    }
private static String getDayuffix(int day) {
    if (day >= 11 && day <= 13) {
        return "th";
    } else if (day == 1 || day == 21 || day == 31) {
        return "st";
    } else if (day == 2 || day == 22) {
        return "nd";
    } else if (day == 3 || day == 23) {
        return "rd";
    } else {
        return "th";
    }
}

    

public static void Q3() {
System.out.println("Q3: Enter how many numbers you want to check for primality: ");
int maxNumber = Integer.parseInt(scan.nextLine());
int primeCount = 0;

for (int current = 2; current < maxNumber; current++) {
    boolean isPrime = true;
    

    for(int divisor = 2; divisor * divisor <= current; divisor++) {
        if (current % divisor == 0) {
        isPrime = false;
        break;
    } 
}
    if (isPrime) {
        primeCount++;
    } 
}

        System.out.println("There are: " + primeCount + " primes between 0 and " + maxNumber);
    }

    public static void Q4() {
        Random rng = new Random();

        String next;
        System.out.println("Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack. Kill the enemy to win!");
        System.out.println("Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
        System.out.println("Q4: Your damage is 2-16 (2d8)");

        int enemyHP = 100;
        int a = 0;

        boolean check = false;
        while (true) {

            boolean doAttack = false;
            boolean check2 = false;
            while (!check2) {
                next = scan.nextLine();
                check2 = true;
                switch (next) {
                    case "A", "a":
                        doAttack = true;
                        break;
                    case "B", "b":
                        check = true;
                        System.out.println("Buffing! +5 to your next attack roll and damage");
                        break;
                    default:
                        System.out.println("Invalid input");
                        check2 = false;
                }
            }

            if (doAttack) {
                a++;
                int attackRoll = rng.nextInt(20) + 1;
                int damage = 0;
                System.out.print("You rolled: " + attackRoll);
                if(check) {
                    attackRoll += 5;
                    System.out.print(" + 5 (buff active)\n");
                } else {
                    System.out.println();
                }
                if (attackRoll >= 12) {
                    damage = rng.nextInt(8) + 1;
                    damage += rng.nextInt(8) + 1;
                    if(check) {
                        damage += 5;
                    }
                    if (attackRoll == 20 || (check && attackRoll == 20 + 5)) {
                        damage *= 2;
                        System.out.print("Critical hit! ");
                    }
                    System.out.print("You dealt " + damage + " damage");
                    if(check) {
                        System.out.print(" (buffed attack)");
                    }
                    enemyHP -= damage;
                    System.out.println("\nEnemy HP: " + Math.max(0, enemyHP));

                } else {
                    System.out.println("Miss");
                }

                check = false;
                if (enemyHP <= 0) {
                    System.out.println("Enemy died in " + a + " turns");
                    scan.close();
                    return;
                }
            }

        }
    }
}


