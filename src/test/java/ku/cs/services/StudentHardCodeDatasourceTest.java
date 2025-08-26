package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    void readData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList list = datasource.readData();

        assertNotNull(list);

        assertEquals("First", list.findStudentById("6710400001").getName());
        assertEquals("Second", list.findStudentById("6710400002").getName());
        assertEquals("Third", list.findStudentById("6710400003").getName());
        assertEquals("Fourth", list.findStudentById("6710400004").getName());
    }
}
