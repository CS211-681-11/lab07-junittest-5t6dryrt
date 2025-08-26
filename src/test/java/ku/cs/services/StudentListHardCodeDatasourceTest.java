package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListHardCodeDatasourceTest {

    @Test
    void readData() {
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();
        StudentList list = datasource.readData();

        assertNotNull(list);
        assertEquals("First", list.findStudentById("6710400001").getName());
        assertEquals("Tenth", list.findStudentById("67104000010").getName());
    }

    @Test
    void writeData() {
        StudentListHardCodeDatasource datasource = new StudentListHardCodeDatasource();
        StudentList list = new StudentList();
        datasource.writeData(list);

    }
}
