package pl.pwr.ite.server.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.server.web.dto.UserDto;
import pl.pwr.ite.server.web.service.UserFacade;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getById(@PathVariable UUID userId) {
        return ResponseEntity.ok(userFacade.getDtoById(userId));
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        return ResponseEntity.ok(userFacade.map(userFacade.create(dto)));
    }

    @PostMapping("/get-by-name")
    public ResponseEntity<UserDto> getByName(@RequestBody UserDto dto) {
        return ResponseEntity.ok(userFacade.map(userFacade.getService().getByName(dto.getName())));
    }
}
