package pl.pwr.ite.server.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.server.web.dto.RegistrationDto;
import pl.pwr.ite.model.filter.RegistrationFilter;
import pl.pwr.ite.server.web.service.RegistrationFacade;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationFacade registrationFacade;

    @PostMapping
    public ResponseEntity<RegistrationDto> create(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(registrationFacade.map(registrationFacade.create(dto)));
    }

    @PutMapping
    public ResponseEntity<RegistrationDto> update(@RequestBody RegistrationDto dto) {
        return ResponseEntity.ok(registrationFacade.map(registrationFacade.update(dto)));
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<RegistrationDto>> getAllByUserId(@RequestBody RegistrationFilter filter) {
        return ResponseEntity.ok(registrationFacade.map(registrationFacade.getService().getList(filter)));
    }

    @GetMapping("/get-all")
    public ResponseEntity<Collection<RegistrationDto>> getAll() {
        return ResponseEntity.ok(registrationFacade.map(registrationFacade.getService().getAll()));
    }

    @GetMapping("/{registrationId}")
    public ResponseEntity<RegistrationDto> getById(@PathVariable UUID registrationId) {
        return ResponseEntity.ok(registrationFacade.getDtoById(registrationId));
    }
}
