package com.example.demo.controller;

import com.example.demo.models.UsuarioModel;
import com.example.demo.models.UsuarioRequest;
import com.example.demo.models.UsuarioResponse;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/list")
    public List<UsuarioResponse> getUsers(){
        return usuarioService.getUsers();
    }

    @GetMapping("/list/name/{name}")
    public List<UsuarioResponse> getUsersByName(@PathVariable String name){
        return usuarioService.getUsersByName(name);
    }

    @GetMapping("/list/{id}")
    public List<UsuarioResponse> getUsersById(@PathVariable Long id){
        return usuarioService.getUsersById(id);
    }

    @PostMapping
    public UsuarioResponse createUser(@RequestBody UsuarioRequest usuarioRequest){
        return this.usuarioService.saveUser(usuarioRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        this.usuarioService.deleteUserById(id);
    }

    @PutMapping
    public UsuarioResponse updateUser(@RequestBody UsuarioModel usuarioModel){
        return this.usuarioService.updateUser(usuarioModel);
    }


}
