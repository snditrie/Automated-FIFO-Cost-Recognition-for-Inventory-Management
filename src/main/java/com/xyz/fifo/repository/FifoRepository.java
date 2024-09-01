package com.xyz.fifo.repository;

import com.xyz.fifo.entity.Fifo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FifoRepository extends JpaRepository<Fifo,Long> {
    List<Fifo> findAllByOrderByAccountingIdAsc();
    List<Fifo> findAllByOrderByIdAsc();
}
