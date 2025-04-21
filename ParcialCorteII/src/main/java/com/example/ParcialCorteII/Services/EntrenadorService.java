package com.example.ParcialCorteII.Services;

import com.example.ParcialCorteII.Models.Entrenador;
import com.example.ParcialCorteII.Repositories.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    public EntrenadorRepository repository;

    public List<Entrenador> ListarTodo()
    {
        return repository.findAll();
    }

    public Entrenador buscarPorId(int id)
    {
        return repository.getReferenceById(id);
    }

    public void crear(Entrenador input)
    {
        repository.save(input);
    }

    public void actualizar(int id, Entrenador input)
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
