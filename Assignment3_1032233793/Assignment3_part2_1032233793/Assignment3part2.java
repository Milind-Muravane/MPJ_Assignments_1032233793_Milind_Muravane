import java.util.Scanner;

class Hillstations {
    void famousfood() {
        System.out.println("General hill station food");
    }

    void famousfor() {
        System.out.println("Known for it's landscape");
    }
}


class Manali extends Hillstations {
    void famousfood() {
        System.out.println("Manali Famous Food: momo");
    }

    void famousfor() {
        System.out.println("Manali Famous For: Snow mountains");
    }
}


class Mahabaleshwar extends Hillstations {
    void famousfood() {
        System.out.println("Mahabaleshwar Famous Food: Strawberries");
    }

    void famousfor() {
        System.out.println("Mahabaleshwar Famous For: Hill views");
    }
}


class Ooty extends Hillstations {
    void famousfood() {
        System.out.println("Ooty Famous Food: Chocolates");
    }

    void famousfor() {
        System.out.println("Ooty Famous For: Tea gardens");
    }
}

public class Assignment3part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hillstations h; // Parent reference
        int choice;

        do {
            System.out.println("\nSelect your location:");
            System.out.println("1. Manali");
            System.out.println("2. Mahabaleshwar");
            System.out.println("3. Ooty");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    h = new Manali();
                    h.famousfood();
                    h.famousfor();
                    break;

                case 2:
                    h = new Mahabaleshwar();
                    h.famousfood();
                    h.famousfor();
                    break;

                case 3:
                    h = new Ooty();
                    h.famousfood();
                    h.famousfor();
                    break;

                case 4:
                    System.out.println("Exit!");
                    break;

                default:
                    System.out.println("Invalid choice!Plese re-enter");
            }

        } while (choice != 4);

        sc.close();
    }
}

