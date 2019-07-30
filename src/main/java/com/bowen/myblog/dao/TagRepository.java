package com.bowen.myblog.dao;

import com.bowen.myblog.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(value = "select * from t_tag t where t.name=?1 ", nativeQuery = true)
    Tag findByName(String name);

    @Query(value = "select * from t_tag t", nativeQuery = true)
    List<Tag> findTop(Pageable pageable);

    @Query(value = "select * from t_tag t where t.id=?1 ", nativeQuery = true)
    Tag findOne(Long id);

    @Modifying
    @Query(value = " delete from t_tag where id= ?1 ", nativeQuery = true)
    void deleteOne(Long id);

    @Query(value = "select * from t_tag t", nativeQuery = true)
    List<Tag> findAll(List<Long> convertToList);
}
