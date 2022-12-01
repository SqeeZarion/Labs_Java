package Fibonacci;

/**
 *The class of Fibonacci numbers with fields <b>data</b> і <b>number</b>
 * @author Kachanovskyi Oleg
 */
public class Fibonacci
{
    /** Fibonacci number value field */
    private long data;
    /** Fibonacci number field */
    private int number;

    /**
     * Function to get the field {@link Fibonacci#data}
     * @return data - the value of the Fibonacci number
     */
    public long getData() {
        return data;
    }
    /**
     * Function to get the field {@link Fibonacci#number}
     * @return number - Fibonacci number number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Field setting function {@link Fibonacci#data}
     * @param data the value of the Fibonacci number
     */
    public void setData(long data) {
        this.data = data;
    }

    /**
     * Field setting function {@link Fibonacci#number}
     * @param number Fibonacci number number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Designer by parameters
     * @param data the value of the Fibonacci number
     * @param number Fibonacci number number
     */
    public Fibonacci(long data, int number)
    {
        this.data = data;
        this.number = number;
    }

}