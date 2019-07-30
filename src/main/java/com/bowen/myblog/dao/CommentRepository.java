package com.bowen.myblog.dao;

import com.bowen.myblog.po.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);

    @Modifying
    @Query(value = " delete from t_comment where id= ?1 ", nativeQuery = true)
    void deleteOne(Long id);

    @Query(value = "select * from t_comment t", nativeQuery = true)
    List<Comment> findAll(List<Long> convertToList);

    @Query(value = "select * from t_comment t where t.id=?1 ", nativeQuery = true)
    Comment findOne(Long id);
}
