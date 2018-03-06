package com.simbirsoft.libary.repository;

import com.simbirsoft.libary.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
