package ru.cybd.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.cybd.model.Addres;
import ru.cybd.service.AddresService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Addres")
public class AddresController {

    private final AddresService addresService;

    @PostMapping
    ResponseEntity<Void> addAddres(@RequestBody @Valid Addres addres,
                                    BindingResult bindingResult){
        addresService.addAddres(addres);
        return ResponseEntity.ok().build();

    }


    @GetMapping
    ResponseEntity<List<Addres>> getAllAddres(){
        return ResponseEntity.ok(addresService.getAllAddress());
    }


    @GetMapping("/{id}")
    ResponseEntity<Addres> getAddresById(@PathVariable Long id){
        Optional<Addres> addresOptional = addresService.getAddresById(id);
        return addresOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    ResponseEntity<Addres> updateAddresById(@PathVariable Long id, @RequestBody Addres updatedAddres) {
        Optional<Addres> updatedAddresOptional = addresService.putAddresById(id, updatedAddres);
        return updatedAddresOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAddresById(@PathVariable Long id){
        addresService.deleteAddresById(id);
        return ResponseEntity.ok().build();
    }
}
