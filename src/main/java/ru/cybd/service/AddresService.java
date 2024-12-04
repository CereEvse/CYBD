package ru.cybd.service;

import org.springframework.data.domain.Page;
import ru.cybd.model.Addres;

import java.util.List;
import java.util.Optional;

public interface AddresService {
    void addAddres(Addres addres);

    List<Addres> getAllAddress();

    Optional<Addres> getAddresById(Long id);

    Optional<Addres> putAddresById(Long id, Addres updatedBuyer);

    void deleteAddresById(Long id);
}
