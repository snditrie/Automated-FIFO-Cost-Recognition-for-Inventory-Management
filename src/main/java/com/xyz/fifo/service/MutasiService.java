package com.xyz.fifo.service;

import com.xyz.fifo.entity.Fifo;
import com.xyz.fifo.entity.Mutasi;
import com.xyz.fifo.repository.MutasiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MutasiService {
    @Autowired
    private MutasiRepository mutasiRepository;

    @Autowired
    private FifoService fifoService;

    public void calculateCostForMutasi(Mutasi mutasi) {
        List<Fifo> fifoList = fifoService.getAvailableInventory();
        int qtyNeeded = mutasi.getQty();
        BigDecimal totalCost = BigDecimal.ZERO;

        for (Fifo fifo : fifoList) {
            if (qtyNeeded <= 0) break;

            int fifoQty = fifo.getQty();
            int qtyUsed = Math.min(fifoQty, qtyNeeded);

            totalCost = totalCost.add(fifo.getCost().multiply(new BigDecimal(qtyUsed)));
            qtyNeeded -= qtyUsed;
            fifo.setQty(fifoQty - qtyUsed);

            fifoService.updateFifoData(fifo);
        }

        mutasi.setCost(totalCost.divide(new BigDecimal(mutasi.getQty()), RoundingMode.HALF_UP));
        mutasiRepository.save(mutasi);
    }
}
