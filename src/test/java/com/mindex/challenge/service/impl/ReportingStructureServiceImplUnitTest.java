package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.ReportingStructure;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplUnitTest {

    private String employeeUrl;
    private String employeeIdUrl;

    @Autowired
    private ReportingStructureServiceImpl reportingStructureService;

    //Looks like h2 in-memory database isn't being used. I need to create a database mock.

    @Test
    public void BottomEmployeeShouldReturnOne() {
        ReportingStructure result = reportingStructureService.read("1");

        Assert.assertEquals("1", result.getEmployee().getEmployeeId() );
        Assert.assertEquals(1, result.getNumberOfReports());
    }
}
