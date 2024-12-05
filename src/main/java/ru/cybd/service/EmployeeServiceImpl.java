package ru.cybd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cybd.exceptions.ExceptionHandler;
import ru.cybd.model.*;
import ru.cybd.model.Employee;
import ru.cybd.repository.*;
import ru.cybd.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final ExceptionHandler exceptionHandler;
    private final EmployeeRepository employeeRepository;
    private final SpecializationRepository specializationRepository;
    private final AddresRepository addresRepository;
    private final PersonalDataRepository personalDataRepository;

    @Override
    public void addEmployee(Employee employee) {
        Specialization specialization = employee.getSpecialization();
        Addres addres = employee.getAddres();
        PersonalData personalData = employee.getPersonalData();

        if (specialization != null && specialization.getIdSpecialization() != null) {
            specialization = specializationRepository.findById(specialization.getIdSpecialization()).orElse(null);
        }
        if (addres != null && addres.getIdAddres() != null) {
            addres = addresRepository.findById(addres.getIdAddres()).orElse(null);
        }
        if (personalData != null && personalData.getIdPersonalData() != null) {
            personalData = personalDataRepository.findById(personalData.getIdPersonalData()).orElse(null);
        }

        employee.setSpecialization(specialization);
        employee.setAddres(addres);
        employee.setPersonalData(personalData);

        employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> putEmployeeById(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if(existingEmployee.isPresent()){

            Employee employeeToUpdate = existingEmployee.get();
            if(updatedEmployee.getSpecialization() != null && updatedEmployee.getSpecialization().getIdSpecialization() != null) {
                Specialization specialization = specializationRepository.findById(updatedEmployee.getSpecialization().getIdSpecialization()).orElse(null);
                employeeToUpdate.setSpecialization(specialization);
            }

            if(updatedEmployee.getExperience() != null) {
                employeeToUpdate.setExperience(updatedEmployee.getExperience());
            }

            if(updatedEmployee.getAddres() != null && updatedEmployee.getAddres().getIdAddres() != null) {
                Addres addres = addresRepository.findById(updatedEmployee.getAddres().getIdAddres()).orElse(null);
                employeeToUpdate.setAddres(addres);
            }
            if(updatedEmployee.getPersonalData() != null && updatedEmployee.getPersonalData().getIdPersonalData() != null) {
                PersonalData personalData = personalDataRepository.findById(updatedEmployee.getPersonalData().getIdPersonalData()).orElse(null);
                employeeToUpdate.setPersonalData(personalData);
            }
            employeeRepository.save(employeeToUpdate);
        }
        return existingEmployee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);

    }
}
