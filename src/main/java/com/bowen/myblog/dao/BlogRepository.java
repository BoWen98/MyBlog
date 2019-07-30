package com.bowen.myblog.dao;

import com.bowen.myblog.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    @Query(value = "select * from t_blog  where recommend = true", nativeQuery = true)
    List<Blog> findTop(Pageable pageable);

    @Query(value = "select * from t_blog  where title like ?1 or content like ?1", nativeQuery = true)
    Page<Blog> findByQuery(String query, Pageable pageable);


    @Transactional
    @Modifying
    @Query(value = "update t_blog  set views = views+1 where id = ?1", nativeQuery = true)
    int updateViews(Long id);

    @Query(value = "SELECT DATE_FORMAT(update_time,'%Y') as YEAR FROM t_blog GROUP BY YEAR ORDER BY YEAR DESC ", nativeQuery = true)
    List<String> findGroupYear();

    @Query(value = "select * from t_blog where DATE_FORMAT(t_blog.update_time,'%Y') = ?1", nativeQuery = true)
    List<Blog> findByYear(String year);

    @Query(value = "select * from t_blog t where t.id=?1 ", nativeQuery = true)
    Blog findOne(Long id);

    @Modifying
    @Query(value = " delete from t_blog where id= ?1 ", nativeQuery = true)
    void deleteOne(Long id);
}
