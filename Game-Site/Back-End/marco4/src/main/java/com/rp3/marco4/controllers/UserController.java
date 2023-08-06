package com.rp3.marco4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rp3.marco4.domain.Users.UpdateUserData;
import com.rp3.marco4.domain.Users.User;
import com.rp3.marco4.domain.Users.UserListData;
import com.rp3.marco4.domain.Users.UserRegisterData;
import com.rp3.marco4.repositories.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
// @CrossOrigin("*")
@RequestMapping("users")
public class UserController {

    @Autowired // O Spring instancia a classe
    private UserRepository repository;

    @PostMapping
    @Transactional // Registrar novo usuário
    public void userRegister(@RequestBody @Valid UserRegisterData data) {
        repository.save(new User(data));
    }

    @GetMapping // Listar Usuários
    public Page<UserListData> userList(Pageable paging) {
        return repository.findAll(paging).map(UserListData::new);
    }

    @PutMapping
    @Transactional // Atualizar usuários
    public void updateUser(@RequestBody @Valid UpdateUserData data) {
        var user = repository.getReferenceById(data.id());
        user.update(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
