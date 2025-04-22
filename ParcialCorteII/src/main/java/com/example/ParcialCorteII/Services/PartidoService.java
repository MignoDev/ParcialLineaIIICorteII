package com.example.ParcialCorteII.Services;

import com.example.ParcialCorteII.Models.Entrenador;
import com.example.ParcialCorteII.Models.Equipo;
import com.example.ParcialCorteII.Models.Partido;
import com.example.ParcialCorteII.Models.PartidoDetalle;
import com.example.ParcialCorteII.Repositories.EntrenadorRepository;
import com.example.ParcialCorteII.Repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartidoService {


    @Autowired
    public PartidoRepository repository;

    public List<Partido> ListarTodo()
    {
        return repository.findAll();
    }

    public Partido buscarPorId(int id)
    {
        return repository.getReferenceById(id);
    }

    public List<PartidoDetalle> detallePartidos() {
//        List<Object[]> result = repository.detallePartidos();
//
//        return result.stream().map(row -> {
//           Partido p = (Partido) row[0];
//           Equipo tl = (Equipo) row[1];
//           Equipo tv = (Equipo) row[2];
//           return new PartidoDetalle(p, tl, tv);
//        }).toList();
        return repository.detallePartidos();
    }

    public void crear(Partido input)
    {
        repository.save(input);
    }

    public void actualizar(int id, Partido input)
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
