package com.example.lab8_20192270.Repository;

import com.example.lab8_20192270.Entity.TipoTicketEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTicketRepo extends JpaRepository<TipoTicketEvento, Integer> {
}
