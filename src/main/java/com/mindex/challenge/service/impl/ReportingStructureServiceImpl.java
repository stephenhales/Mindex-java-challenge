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

import java.util.List;
import java.util.UUID;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Getting employee with id [{}]", id);

        Employee rootEmployee = employeeRepository.findByEmployeeId(id);

        if (rootEmployee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        List<Employee> directReports = rootEmployee.getDirectReports();
        if(directReports == null){
            return new ReportingStructure(rootEmployee, 0);
        }

        //Recursive call to get the total report count traversing down the chain of command
        int directCount = directReports.size();
        for( Employee e : directReports){
            directCount += read(e.getEmployeeId()).getNumberOfReports();
        }

        return new ReportingStructure(rootEmployee, directCount);
    }
}
