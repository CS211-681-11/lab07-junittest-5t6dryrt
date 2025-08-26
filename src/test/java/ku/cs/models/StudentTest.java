package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {


    @Test
    void changeName() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.changeName("ChangeName");
        assertEquals("ChangeName", s.getName());
    }

    @Test
    void isId() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertTrue(s.isId("6xxxxxxxx"));
    }

    @Test
    void isNameContains() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertTrue(s.isNameContains("S"));
    }

    @Test
    void getId() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertEquals("6xxxxxxxx", s.getId());

    }

    @Test
    void getName() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertEquals("StudentTest", s.getName());
    }

    @Test
    void getScore() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(10);
        assertEquals(10, s.getScore());
    }


    @Test
    void testToString() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(10);
        assertEquals("{id: '6xxxxxxxx', name: 'StudentTest', score: 10.0}", s.toString());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }
}