package com.example.ParcialCorteII.Services;

import com.example.ParcialCorteII.Models.Entrenador;
import com.example.ParcialCorteII.Models.Jugador;
import com.example.ParcialCorteII.Repositories.EntrenadorRepository;
import com.example.ParcialCorteII.Repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {


    @Autowired
    public JugadorRepository repository;

    public List<Jugador> ListarTodo()
    {
        return repository.findAll();
    }

    public Jugador buscarPorId(int id)
    {
        return repository.getReferenceById(id);
    }

    public void crear(Jugador input)
    {
        repository.save(input);
    }

    public void actualizar(int id, Jugador input)
    {
        if(!repository.existsById(id))
        {
            throw new RuntimeException("Registro con el id " + id + " no existe");
        }
        repository.save(input);
    }

    public void eliminarPorId(int id)
    {
        if(!repository.existsById(id))
        {
            throw new RuntimeException("Registro con el id " + id + " no existe");
        }
        repository.deleteById(id);
    }

    public List<Object[]> jugadorEquipo(int equipo)
    {
        return repository.buscaJugadoresEquipo(equipo);
    }
}
