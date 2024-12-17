package ru.cybd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cybd.exceptions.ExceptionHandler;
import ru.cybd.model.Project;
import ru.cybd.model.Customer;
import ru.cybd.model.Contact;
import ru.cybd.repository.ProjectRepository;
import ru.cybd.repository.CustomerRepository;
import ru.cybd.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
    private final ExceptionHandler exceptionHandler;
    private final CustomerRepository customerRepository;
    private final ContactRepository contactRepository;
    private final ProjectRepository projectRepository;

    @Override
    public void addCustomer(Customer customer) {
        Contact contact = customer.getContact();
        Project project = customer.getProject();

        if (contact != null && contact.getIdContact() != null) {
            contact = contactRepository.findById(contact.getIdContact()).orElse(null);
        }
        if (project != null && project.getIdProject() != null) {
            project = projectRepository.findById(project.getIdProject()).orElse(null);
        }

        customer.setContact(contact);
        customer.setProject(project);

        customerRepository.save(customer);

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> putCustomerById(Long id, Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if(existingCustomer.isPresent()){

            Customer customerToUpdate = existingCustomer.get();
            if(updatedCustomer.getContact() != null && updatedCustomer.getContact().getIdContact() != null) {
                Contact contact = contactRepository.findById(updatedCustomer.getContact().getIdContact()).orElse(null);
                customerToUpdate.setContact(contact);
            }

            if(updatedCustomer.getRequirements() != null) {
                customerToUpdate.setRequirements(updatedCustomer.getRequirements());
            }

            if(updatedCustomer.getProject() != null && updatedCustomer.getProject().getIdProject() != null) {
                Project project = projectRepository.findById(updatedCustomer.getProject().getIdProject()).orElse(null);
                customerToUpdate.setProject(project);
            }
            customerRepository.save(customerToUpdate);
        }
        return existingCustomer;
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);

    }
}
