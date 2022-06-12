package view.backing;

/**
 *
 * @author NighT_WalRiDeR
 */
public class Student
{
    private String name;
    private String surname;
    private double average;

    public Student(String name, String surname, double average)
    {   
        this.name=name;
        this.surname=surname;
        this.average=average;
    }
    
    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * @return the surname
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }


    /**
     * @return the average
     */
    public double getAverage()
    {
        return average;
    }

    /**
     * @param average the average to set
     */
    public void setAverage(float average)
    {
        this.average = average;
    }
    
}
