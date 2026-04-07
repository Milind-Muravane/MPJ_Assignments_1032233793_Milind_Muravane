import java.util.Scanner;

class Shapes{
    double a,b,r;
    
    Shapes(double l, double br){
        a = l;
        br = br;
    }
    
    Shapes(double rad){
        r = rad;
    }
    
    double area(double l,double br){
        return a*b;
    }
    
    double area(double rad){
        return 3.14*rad*rad;
    }
}

public class Assignment3part1 { 
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int ch;
        
        do {
            System.out.println("\nShape choices:\n");
            System.out.println("1. Find the area of Rectangle");
            System.out.println("2.Find the area of Circle");
            System.out.println("3.Exit");
            System.out.println("Please enter your choice:");
            ch = s.nextInt();
                    
            switch(ch){
                case 1:
                    System.out.print("Enter length of the rectangle: ");
                    double l = s.nextDouble();

                    System.out.print("Enter breadth of the rectangle: ");
                    double br = s.nextDouble();

                    Shapes rect = new Shapes(l, br);
                    System.out.println("Area of Rectangle = " + rect.area(l, br));
                    break;

                case 2:
                    System.out.print("Enter radius of a circle: ");
                    double rad = s.nextDouble();

                    Shapes circle = new Shapes(rad);
                    System.out.println("Area of Circle = " + circle.area(rad));
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please re-enter");
                
            }
        } while (ch != 3);
    }
}