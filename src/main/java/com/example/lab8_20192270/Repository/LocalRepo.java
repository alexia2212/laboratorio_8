package com.example.lab8_20192270.Repository;

import com.example.lab8_20192270.Entity.Evento;
import com.example.lab8_20192270.Entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalRepo extends JpaRepository<Local, Integer> {
}
