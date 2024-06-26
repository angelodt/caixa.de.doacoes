package br.com.angelodt.caixa.de.doacoes.service;

import br.com.angelodt.caixa.de.doacoes.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
