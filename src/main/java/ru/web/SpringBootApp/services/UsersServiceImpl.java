package ru.web.SpringBootApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.web.SpringBootApp.models.User;
import ru.web.SpringBootApp.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        Optional<User> foundUser = usersRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Override
    @Transactional
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User updateUser) {
        updateUser.setId(id);
        usersRepository.save(updateUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        usersRepository.deleteById(id);
    }
}
