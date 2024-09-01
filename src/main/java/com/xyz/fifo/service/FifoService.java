package com.xyz.fifo.service;

import com.xyz.fifo.entity.Fifo;
import com.xyz.fifo.repository.FifoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FifoService {
    @Autowired
    private FifoRepository fifiRepository;

    public List<Fifo> getAvailableInventory() {
        return fifiRepository.findAllByOrderByIdAsc();
    }

    public void updateFifoData(Fifo fifo) {
        fifiRepository.save(fifo);
    }
}
