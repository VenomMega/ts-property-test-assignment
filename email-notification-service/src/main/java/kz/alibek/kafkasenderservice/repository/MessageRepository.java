package kz.alibek.kafkasenderservice.repository;

import kz.alibek.kafkasenderservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySender(String sender);
    List<Message> findTop10ByOrderByCreatedAtDesc();
}
