package com.vn.ntd.RabbitmqSimple.repository;

import com.vn.ntd.RabbitmqSimple.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Class MessageRepository
 *
 * @author ntduoc
 * @since 6/3/2019
 */
@Repository
public interface MessageRepository extends JpaRepository<MessageModel, Long> {
}
