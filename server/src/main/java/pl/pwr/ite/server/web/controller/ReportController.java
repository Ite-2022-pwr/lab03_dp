package pl.pwr.ite.server.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.model.filter.ReportFilter;
import pl.pwr.ite.server.web.dto.ReportDto;
import pl.pwr.ite.server.web.service.ReportFacade;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportFacade reportFacade;

    @GetMapping("/get")
    public ResponseEntity<ReportDto> get(@RequestBody ReportFilter filter) {
        return ResponseEntity.ok(reportFacade.map(reportFacade.getService().get(filter)));
    }

    @PostMapping
    public ResponseEntity<ReportDto> create(@RequestBody ReportDto dto) {
        return ResponseEntity.ok(reportFacade.map(reportFacade.create(dto)));
    }
}
