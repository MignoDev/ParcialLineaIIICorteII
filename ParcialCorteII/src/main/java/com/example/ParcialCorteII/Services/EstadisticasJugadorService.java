package com.example.ParcialCorteII.Services;

import com.example.ParcialCorteII.Models.Entrenador;
import com.example.ParcialCorteII.Models.EstadisticasJugador;
import com.example.ParcialCorteII.Repositories.EntrenadorRepository;
import com.example.ParcialCorteII.Repositories.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadisticasJugadorService {


    @Autowired
    public EstadisticasJugadorRepository repository;

    public List<EstadisticasJugador> ListarTodo()
    {
        return repository.findAll();
    }

    public EstadisticasJugador buscarPorId(int id)
    {
        return repository.getReferenceById(id);
    }

    public void crear(EstadisticasJugador input)
    {
        repository.save(input);
    }

    public void actualizar(int id, EstadisticasJugador input)
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
}
