package ru.web.SpringBootApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.web.SpringBootApp.models.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
}
