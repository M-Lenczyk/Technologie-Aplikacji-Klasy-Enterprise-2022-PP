package view.backing;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author NighT_WalRiDeR
 */
@Named(value = "StudentsTable")
@RequestScoped
public class StudentsTable
{

    private List<Student> students;

    /**
     * Creates a new instance of StudentsTable
     */
    public StudentsTable()
    {
        students = new ArrayList<>();
        students.add(new Student("John", "Smith", 3.0));
        students.add(new Student("John", "Marston", 5.0));
        students.add(new Student("Malcolm", "X", 4.0));
        students.add(new Student("Xan", "Kriegor", 4.98));
        students.add(new Student("Barack", "Obama", 4.3));
        students.add(new Student("Donald", "Trump", 2.64));
        students.add(new Student("Desmond", "Doss", 3.33));
        students.add(new Student("Elon", "Husk", 4.0));
        students.add(new Student("Leszek", "Leniwczak", 2.0));

    }

    /**
     * @return the students
     */
    public List<Student> getStudents()
    {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

}
