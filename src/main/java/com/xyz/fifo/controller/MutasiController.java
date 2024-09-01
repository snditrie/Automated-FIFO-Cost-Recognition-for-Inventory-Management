package com.xyz.fifo.controller;

import com.xyz.fifo.entity.Mutasi;
import com.xyz.fifo.service.MutasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mutasi")
public class MutasiController {
    @Autowired
    private MutasiService mutasiService;

    @PostMapping("/calculate")
    public ResponseEntity<String> calculateCost(@RequestBody Mutasi mutasi) {
        try {
            mutasiService.calculateCostForMutasi(mutasi);
            return ResponseEntity.ok("Cost calculation completed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error calculating cost: " + e.getMessage());
        }
    }
}
