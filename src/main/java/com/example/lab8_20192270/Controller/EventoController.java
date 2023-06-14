package com.example.lab8_20192270.Controller;

import ch.qos.logback.core.model.Model;
import com.example.lab8_20192270.Entity.Evento;
import com.example.lab8_20192270.Entity.TipoTicketEvento;
import com.example.lab8_20192270.Repository.EventoRepo;
import com.example.lab8_20192270.Repository.TipoTicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
//@RequestMapping("/evento")
public class EventoController {

    @Autowired
    TipoTicketRepo tipoTicketRepo;
    @Autowired
    EventoRepo eventoRepo;
    @GetMapping("/evento")
    public List<Evento> listaDeEventos(){

        return eventoRepo.findAll();
    }

    @GetMapping("/evento/{id}")
    public ResponseEntity<HashMap<String, Object>> obtenerIdEvento(@PathVariable("id") String idStr){
        HashMap<String, Object> respuesta = new HashMap<>();

        try{
            int id = Integer.parseInt(idStr);
            Optional<Evento> optProduct = eventoRepo.findById(id);
            if (optProduct.isPresent()) {
                respuesta.put("evento",optProduct.get());
                respuesta.put("resultado;","exitoso");

                return ResponseEntity.ok(respuesta);
            } else {
                respuesta.put("msg","Id no encontrado");
            }
        } catch (NumberFormatException e) {
            respuesta.put("msg","el ID debe ser un número entero positivo");
        }
        respuesta.put("Resultado","Falla");
        return ResponseEntity.badRequest().body(respuesta);


    }


    @PostMapping("/crear")
    public ResponseEntity<HashMap<String, String>> crearUsuarios(@RequestBody Evento evento, @RequestParam("idEvento") int id){
        HashMap<String, String> respuesta = new HashMap<>();
        Optional<Evento> eventoOptional = eventoRepo.findById(id);

        if(eventoOptional.isPresent()){
            eventoRepo.save(evento);
            respuesta.put("id creado",""+evento.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);

        }else{
            respuesta.put("error","No existe solicitud con este ID");
            return ResponseEntity.ok(respuesta);
        }
    }
    @GetMapping("/eventoConTipoDeTicket/{id}")
    public ResponseEntity<HashMap<String, Object>> obtenerIdTicket(@PathVariable("id") String idStr){
        HashMap<String, Object> respuesta = new HashMap<>();

        try{
            int id = Integer.parseInt(idStr);
            Optional<TipoTicketEvento> optTicket = tipoTicketRepo.findById(id);
            if (optTicket.isPresent()) {
                respuesta.put("ticket",optTicket.get());
                respuesta.put("resultado;","exitoso");

                return ResponseEntity.ok(respuesta);
            } else {
                respuesta.put("msg","Id no encontrado");
            }
        } catch (NumberFormatException e) {
            respuesta.put("msg","el ID debe ser un número entero positivo");
        }
        respuesta.put("Resultado","Falla");
        return ResponseEntity.badRequest().body(respuesta);


    }


}
