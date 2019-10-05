package io.ascending.training.jdbc;

import io.ascending.training.model.Department;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DepartmentDaoTest {
    private DepartmentDao departmentDao;
    private Department testRecord;
    @Before
    public void setup(){
        departmentDao = new DepartmentDao();
        testRecord.setName("ascending");
        testRecord.setDescription("offline bootcamp");
        departmentDao.save(testRecord);
    }

    @After
    public void tearDown(){
        departmentDao.delete(testRecord);
    }

    @Test
    public void getDepartmentsTest() {
        List<Department> departments = departmentDao.getDepartments();
        int expectedNumofDept = 4;
        Assert.assertEquals(expectedNumofDept,departments.size());

    }
}
