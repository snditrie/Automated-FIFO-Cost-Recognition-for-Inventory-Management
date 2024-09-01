package com.xyz.fifo.repository;

import com.xyz.fifo.entity.Mutasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MutasiRepository extends JpaRepository<Mutasi,Long> {
}
