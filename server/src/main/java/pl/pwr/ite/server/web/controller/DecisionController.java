package pl.pwr.ite.server.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.model.filter.DecisionFilter;
import pl.pwr.ite.server.web.dto.DecisionDto;
import pl.pwr.ite.server.web.service.DecisionFacade;

@RestController
@RequestMapping("/decision")
@RequiredArgsConstructor
public class DecisionController {

    private final DecisionFacade decisionFacade;

    @GetMapping("/get")
    public ResponseEntity<DecisionDto> getList(@RequestBody DecisionFilter filter) {
        return ResponseEntity.ok(decisionFacade.map(decisionFacade.getService().get(filter)));
    }

    @PostMapping
    private ResponseEntity<DecisionDto> create(@RequestBody DecisionDto dto) {
        return ResponseEntity.ok(decisionFacade.map(decisionFacade.create(dto)));
    }
}
