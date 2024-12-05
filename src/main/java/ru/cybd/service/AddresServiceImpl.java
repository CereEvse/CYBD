package ru.cybd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cybd.exceptions.ExceptionHandler;
import ru.cybd.model.Addres;
import ru.cybd.repository.AddresRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddresServiceImpl implements AddresService{

    private final AddresRepository addresRepository;
    private final ExceptionHandler exceptionHandler;

    @Override
    public void addAddres(Addres addres) {
        addresRepository.save(addres);
    }

    @Override
    public List<Addres> getAllAddress() {
        return addresRepository.findAll();
    }

    @Override
    public Optional<Addres> getAddresById(Long id) {
        return addresRepository.findById(id);
    }

    @Override
    public Optional<Addres> putAddresById(Long id, Addres updatedAddres) {
        Optional<Addres> existingAddres = addresRepository.findById(id);
        if (existingAddres.isPresent()) {
            Addres addresToUpdate = existingAddres.get();
            if (updatedAddres.getCity() != null) {
                addresToUpdate.setCity(updatedAddres.getCity());
            }
            if (updatedAddres.getStreet() != null) {
                addresToUpdate.setStreet(updatedAddres.getStreet());
            }
            if (updatedAddres.getHouse() != null) {
                addresToUpdate.setHouse(updatedAddres.getHouse());
            }
            addresRepository.save(addresToUpdate);
        }
        return existingAddres;
    }

    @Override
    public void deleteAddresById(Long id) {
        addresRepository.deleteById(id);
    }

}
