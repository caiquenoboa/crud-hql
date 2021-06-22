package com.example.demo.service;

import com.example.demo.models.UsuarioModel;
import com.example.demo.models.UsuarioRequest;
import com.example.demo.models.UsuarioResponse;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService  {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioResponse> getUsers(){
        return usuarioRepository.findAll().stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }

    public List<UsuarioResponse> getUsersByName(String nombre){
        return usuarioRepository.findUsuarioModelByName(nombre).stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }

    public List<UsuarioResponse> getUsersById(Long id){
        return usuarioRepository.findUsuarioModelById(id).stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }

    public  UsuarioResponse saveUser(UsuarioRequest nuevoUsuario){
        return new UsuarioResponse(usuarioRepository.save(new UsuarioModel(nuevoUsuario)));
    }

    public void deleteUserById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioResponse updateUser(UsuarioModel usuarioModel) {
        this.usuarioRepository.updatePassword(usuarioModel.getId(), usuarioModel.getPassword());
        this.usuarioRepository.updateUsername(usuarioModel.getId(), usuarioModel.getUserName());

        return new UsuarioResponse(this.usuarioRepository.findById(usuarioModel.getId()).get());

    }
}
