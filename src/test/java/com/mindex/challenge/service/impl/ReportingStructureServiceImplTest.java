package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {

    private String reportingStructureUrl;

    @Autowired
    private ReportingStructureService reportingStructureService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        reportingStructureUrl = "http://localhost:" + port + "/reporting/{id}";
    }

    @Test
    public void bottomReportReturnsZeroReports() {
        String id = "c0c2293d-16bd-4603-8e08-638a9d18b22c"; // George Harrison

        ReportingStructure result = restTemplate.getForEntity(reportingStructureUrl, ReportingStructure.class, id).getBody();

        assertNotNull(result);
        Assert.assertEquals(id, result.getEmployee().getEmployeeId());
        Assert.assertEquals(0, result.getNumberOfReports());
    }

    @Test
    public void ringoStarrReturnsTwoReports() {
        String id = "03aa1462-ffa9-4978-901b-7c001562cf6f"; // Ringo Starr

        // Call endpoint
        ReportingStructure result = restTemplate.getForEntity(reportingStructureUrl, ReportingStructure.class, id).getBody();

        assertNotNull(result);
        Assert.assertEquals(id, result.getEmployee().getEmployeeId());
        Assert.assertEquals(2, result.getNumberOfReports());
    }

    @Test
    public void johnLennonReturnsFourReports() {
        String id = "16a596ae-edd3-4847-99fe-c4518e82c86f"; // John Lennon

        // Call endpoint
        ReportingStructure result = restTemplate.getForEntity(reportingStructureUrl, ReportingStructure.class, id).getBody();

        assertNotNull(result);
        Assert.assertEquals(id, result.getEmployee().getEmployeeId());
        Assert.assertEquals(4, result.getNumberOfReports());
    }
}
