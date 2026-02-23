package com.securin.cpeapi.controller;

import com.securin.cpeapi.model.CpeEntity;
import com.securin.cpeapi.service.CpeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cpes")
public class CpeController {

    private final CpeService service;


    public CpeController(CpeService service) {
        this.service = service;
    }

    @PostMapping("/load")
    public String loadData() throws Exception {
        service.loadXmlToDb();
        return "CPE data loaded successfully";
    }

    @GetMapping
    public Page<CpeEntity> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {

        return service.getAll(page, limit);
    }
}