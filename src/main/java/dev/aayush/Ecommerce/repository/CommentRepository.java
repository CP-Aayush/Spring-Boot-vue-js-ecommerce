package dev.aayush.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.aayush.Ecommerce.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}