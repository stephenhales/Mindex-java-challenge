package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee rootEmployee = employeeRepository.findByEmployeeId(id);

        if (rootEmployee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        //Add recursive calls to fill out the employee tree, and then count the total.

        return new ReportingStructure();
    }
}
