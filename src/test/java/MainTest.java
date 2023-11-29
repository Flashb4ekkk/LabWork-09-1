import org.example.WorkClass;
import org.example.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testSearchGoodMarks() {
        Student[] students = new Student[2];
        students[0] = new Student();
        students[1] = new Student();

        int goodMarks = WorkClass.searchGoodMarksPhys(students);
        assertTrue(goodMarks >= 1 && goodMarks <= 5);
    }
}
