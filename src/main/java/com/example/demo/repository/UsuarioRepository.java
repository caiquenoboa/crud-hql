package com.example.demo.repository;

import com.example.demo.models.UsuarioModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    @Override
    @Query("from UsuarioModel")
    List<UsuarioModel> findAll();

    @Query("select u from UsuarioModel u where u.userName like :name order by u.userName")
    List<UsuarioModel> findUsuarioModelByName(@Param("name") String name);

    @Query("from UsuarioModel u where u.id = :searchId")
    List<UsuarioModel> findUsuarioModelById(@Param("searchId") Long searchId);

    @Modifying
    @Transactional
    @Query("UPDATE UsuarioModel user set user.password = :password WHERE user.id = :id")
    int updatePassword(Long id, String password);

    @Modifying
    @Transactional
    @Query("UPDATE UsuarioModel user set user.userName = :userName WHERE user.id = :id")
    int updateUsername(Long id, String userName);

    @Modifying
    @Query("DELETE FROM UsuarioModel WHERE id = :searchId")
    void deleteById(@Param("searchId") Long searchId);


}



