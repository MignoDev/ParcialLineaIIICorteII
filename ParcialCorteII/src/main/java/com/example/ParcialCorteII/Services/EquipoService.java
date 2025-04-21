package com.example.ParcialCorteII.Services;

import com.example.ParcialCorteII.Models.Entrenador;
import com.example.ParcialCorteII.Models.Equipo;
import com.example.ParcialCorteII.Repositories.EntrenadorRepository;
import com.example.ParcialCorteII.Repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    public EquipoRepository repository;

    public List<Equipo> ListarTodo()
    {
        return repository.findAll();
    }

    public Equipo buscarPorId(int id)
    {
        return repository.getReferenceById(id);
    }

    public void crear(Equipo input)
    {
        repository.save(input);
    }

    public void actualizar(int id, Equipo input)
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
