package com.bowen.myblog.dao;

import com.bowen.myblog.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {


    @Query(value = "select * from t_type where name=?1 ", nativeQuery = true)
    Type findByName(String name);


    @Query(value = "select * from t_type", nativeQuery = true)
    List<Type> findTop(Pageable pageable);


    @Query(value = "select * from t_type t where t.id=?1 ", nativeQuery = true)
    Type findOne(Long id);

    @Modifying
    @Query(value = " delete from t_type where id= ?1 ", nativeQuery = true)
    void deleteOne(Long id);
}
