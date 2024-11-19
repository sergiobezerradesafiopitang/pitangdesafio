package com.pitang.desafio.repository;

import com.pitang.desafio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Transactional(readOnly = true)
    Optional<Usuario> findByEmail(String email);

    @Transactional(readOnly = true)
    Optional<Usuario> findByLogin(String login);

    @Transactional(readOnly = true)
    @Query(value = "SELECT * FROM USUARIO u WHERE u.login = :login AND u.password = :password", nativeQuery = true)
    Usuario findByLoginAndPassword(@Param("login") String login, @Param("password") String email);

}
