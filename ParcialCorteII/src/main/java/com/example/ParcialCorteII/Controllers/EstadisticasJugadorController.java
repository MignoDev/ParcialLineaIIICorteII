package com.example.ParcialCorteII.Controllers;


import com.example.ParcialCorteII.Models.EstadisticasJugador;
import com.example.ParcialCorteII.Services.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasJugadorController {

    @Autowired
    public EstadisticasJugadorService service;

    @GetMapping("")
    public ResponseEntity<?> listarTodo()
    {
        try {
            List<EstadisticasJugador> response = service.ListarTodo();
            if(response.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se ha encontrado ningún registro");
            }
            return ResponseEntity.ok(response);
        } catch ( Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error en el servidor");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id)
    {
        try {
            EstadisticasJugador response = service.buscarPorId(id);
            if (response == null)
            {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se ha encontrado registro");
            }
            return ResponseEntity.ok(response);
        } catch ( Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error en el servidor");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody EstadisticasJugador input)
    {
        try {
            service.crear(input);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error en el servidor");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar (@PathVariable int id, @RequestBody EstadisticasJugador input)
    {
        try{
            service.actualizar(id, input);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error en el servidor");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId (@PathVariable int id)
    {
        try{
            service.eliminarPorId(id);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error en el servidor");
        }
    }
}
