/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.mauriceliddy.Project0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.github.mauriceliddy.Project0.DataManagement.*;
import com.github.mauriceliddy.Project0.Model.*;
import java.util.List;

class DataInputTest {
    DataInput dataInput = new DataInput();
    List<Workout> masterList = dataInput.readInData();

    @Test
    void basicTest() {
        // System.out.println("Working Directory = " + System.getProperty("user.dir"));
        assertEquals("expected", "expected");
    }

    @Test
    void testMasterListIsPopulated() {
        assertNotNull(masterList);
    }

    @Test
    void testWorkoutNumber() {
        assertEquals(20, masterList.size());
    }


}
