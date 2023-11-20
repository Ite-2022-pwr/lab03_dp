package pl.pwr.ite.server.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pwr.ite.server.model.filter.TreeFilter;
import pl.pwr.ite.server.web.dto.TreeDto;
import pl.pwr.ite.server.web.service.TreeFacade;

import java.util.Collection;

@RestController
@RequestMapping("/tree")
@RequiredArgsConstructor
public class TreeController {

    private final TreeFacade treeFacade;

    @GetMapping("/list")
    public ResponseEntity<Collection<TreeDto>> getList(@RequestBody TreeFilter filter) {
        return ResponseEntity.ok(treeFacade.map(treeFacade.getService().getList(filter)));
    }
}
