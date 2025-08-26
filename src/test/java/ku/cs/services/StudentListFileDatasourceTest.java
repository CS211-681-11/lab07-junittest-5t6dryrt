package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {

    private static final String TEST_DIR = "test-data";
    private static final String TEST_FILE = "students.csv";
    private StudentListFileDatasource datasource;

    @BeforeEach
    void setUp() {
        datasource = new StudentListFileDatasource(TEST_DIR, TEST_FILE);
    }

    @Test
    void writeData() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("1001", "Alice", 90.5);
        studentList.addNewStudent("1002", "Bob", 85.0);

        datasource.writeData(studentList);

        File file = new File(TEST_DIR + File.separator + TEST_FILE);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }

    @Test
    void readData() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("1001", "Alice", 90.5);
        studentList.addNewStudent("1002", "Bob", 85.0);
        datasource.writeData(studentList);

        StudentList loadedList = datasource.readData();
        Student alice = loadedList.findStudentById("1001");
        Student bob = loadedList.findStudentById("1002");
        assertEquals("Alice", alice.getName());
        assertEquals(90.5, alice.getScore());
        assertEquals("Bob", bob.getName());
        assertEquals(85.0, bob.getScore());
    }
}
