import java.util.Scanner;
import Fibonacci.Fibonacci;

public class Main
{
    /**
     * Empty constructor
     */
    public Main() {}
    /**
     * create, fill and display an array of Fibonacci numbers
     * @param size array size
     * @return - an array of class objects {@link Fibonacci}
     */
    static Fibonacci[] CreateArrayOfObjects(int size)
    {
        Fibonacci[] Array = new Fibonacci[size]; // масив об'єктів
        Array[0] =  new Fibonacci(1,1); // задання перших 2 чисел Фібоначчі
        Array[1] = new Fibonacci(1,2);
        for (int i = 2; i < size; i++) // заповнення масиву відповідними даними
        {
            Array[i] = new Fibonacci(Array[i-1].getData() + Array[i-2].getData(), i+1);
        }
        System.out.println("Fibonacci`s numbers: ");
        for (int i = 0; i < size; i++) // вивід масиву на екран
        {
            System.out.println("Number: "+Array[i].getNumber()+" Data: "+Array[i].getData());
        }
        return Array;
    }

    /**
     * Task N
     * @return N - the number of Fibonacci numbers that need to be checked under the condition in {@link Main#Check(Fibonacci[], int)}
     */
    static int setN()
    {
        System.out.print("\nEnter the N: ");
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextInt(); // N
    }
    static int setSize()
    {
        int size;
        do{
            System.out.print("Enter the size: ");
            Scanner myScanner = new Scanner(System.in);
            size =  myScanner.nextInt();
        }while(size>0 && size<92);

        return size;
    }
    /**
     * Condition check w*w+1 = Fibonacci number and display the results on the screen, w - a natural number
     * @param Array an array of Fibonacci numbers
     * @param N the number of tested Fibonacci numbers
     */
    static void Check(Fibonacci[] Array, int N)
    {
        System.out.println("\nResult: ");
        for (int i = 0; i < N; i++) // алгоритм перевірки
        {
            for (int w = 1; ; w++)
            {
                if ((long) w*w + 1 == Array[i].getData())
                {
                    System.out.println(Array[i].getData());
                }
                else if ((long) w*w + 1 > Array[i].getData()) // додаткова умова для скорочення роботи алгоритму
                {
                    break;
                }
            }

        }
    }

    /**
     * The main method of the program
     * @param args command line value
     */
    public static void main(String[] args)
    {
        Fibonacci[] Array = CreateArrayOfObjects(setSize());
        int N = setN(); // number of numbers to check
        Check(Array,N);
    }
}