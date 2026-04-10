import java.io.*;
import java.util.*;

// Customer class
class Customer implements Serializable {
    int cid;
    String name;
    double amount;

    Customer(int cid, String name, double amount) {
        this.cid = cid;
        this.name = name;
        this.amount = amount;
    }

    void display() {
        System.out.println(cid + " " + name + " " + amount);
    }
}

public class Assignment4 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n1.Create\n2.Deposit\n3.Withdraw\n4.Display\n5.Exit");
            choice = sc.nextInt();

            try {
                switch (choice) {

                    
                    case 1:
                        System.out.print("Enter CID (1-20): ");
                        int cid = sc.nextInt();

                        if (cid < 1 || cid > 20)
                            throw new Exception("Invalid CID");

                     
                        boolean exists = false;
                        for (Customer c : list) {
                            if (c.cid == cid) {
                                exists = true;
                                break;
                            }
                        }

                        if (exists)
                            throw new Exception("CID already exists");

                        System.out.print("Enter Name: ");
                        String name = sc.next();

                        System.out.print("Enter Amount: ");
                        double amt = sc.nextDouble();

                        if (amt < 0)
                            throw new Exception("Amount must be positive");

                        if (amt < 1000)
                            throw new Exception("Minimum balance is 1000");

                        list.add(new Customer(cid, name, amt));
                        System.out.println("Account Created Successfully!");
                        break;

                   
                    case 2:
                        System.out.print("Enter CID: ");
                        int d = sc.nextInt();

                        System.out.print("Enter amount: ");
                        double dep = sc.nextDouble();

                        if (dep <= 0)
                            throw new Exception("Invalid amount");

                        boolean foundDeposit = false;
                        for (Customer c : list) {
                            if (c.cid == d) {
                                c.amount += dep;
                                foundDeposit = true;
                                break;
                            }
                        }

                        if (!foundDeposit)
                            System.out.println("Customer not found");
                        else
                            System.out.println("Deposit Successful!");
                        break;

                    
                    case 3:
                        System.out.print("Enter CID: ");
                        int w = sc.nextInt();

                        System.out.print("Enter amount: ");
                        double wd = sc.nextDouble();

                        if (wd <= 0)
                            throw new Exception("Invalid amount");

                        boolean foundWithdraw = false;
                        for (Customer c : list) {
                            if (c.cid == w) {
                                if (wd > c.amount)
                                    throw new Exception("Insufficient balance");

                                c.amount -= wd;
                                foundWithdraw = true;
                                break;
                            }
                        }

                        if (!foundWithdraw)
                            System.out.println("Customer not found");
                        else
                            System.out.println("Withdrawal Successful!");
                        break;

                    
                    case 4:
                        if (list.isEmpty()) {
                            System.out.println("No records found");
                        } else {
                            for (Customer c : list) {
                                c.display();
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);

        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
        oos.writeObject(list);
        oos.close();

        System.out.println("Data saved to file.");
    }
}
