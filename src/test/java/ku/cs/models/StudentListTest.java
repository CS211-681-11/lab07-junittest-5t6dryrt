package ku.cs.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    @Test
    void addNewStudent() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S001", "Alice");
        assertEquals(1, studentList.getStudents().size());
        assertEquals("Alice", studentList.getStudents().get(0).getName());
        assertEquals("S001", studentList.getStudents().get(0).getId());
    }

    @Test
    void testAddNewStudent() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S002", "Bob", 85.5);
        assertEquals(1, studentList.getStudents().size());
        Student bob = studentList.getStudents().get(0);
        assertEquals("Bob", bob.getName());
        assertEquals("S002", bob.getId());
        assertEquals(85.5, bob.getScore());
    }

    @Test
    void findStudentById() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S003", "Charlie");
        Student student = studentList.findStudentById("S003");
        assertNotNull(student);
        assertEquals("Charlie", student.getName());
    }

    @Test
    void filterByName() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S001", "Alice");
        studentList.addNewStudent("S002", "Alicia");
        studentList.addNewStudent("S003", "Bob");

        StudentList filtered = studentList.filterByName("Ali");
        assertEquals(2, filtered.getStudents().size());
    }

    @Test
    void giveScoreToId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S001", "Alice", 50);
        studentList.giveScoreToId("S001", 20);
        Student alice = studentList.findStudentById("S001");
        assertEquals(70, alice.getScore());
    }

    @Test
    void viewGradeOfId() {
        StudentList studentList = new StudentList();
        assertNull(studentList.viewGradeOfId("S999"));
    }

    @Test
    void getStudents() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("S001", "Alice");
        studentList.addNewStudent("S002", "Bob");
        assertEquals(2, studentList.getStudents().size());
    }
}