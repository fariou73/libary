package com.simbirsoft.libary.service;

import com.simbirsoft.libary.entity.Attachment;
import com.simbirsoft.libary.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Transactional
@Service
public class AttachmentService {
    @Autowired private AttachmentRepository repository;

    public Long upload(MultipartFile file) throws IOException {
        Attachment attachment = new Attachment();
        attachment.setFile(file.getBytes());
        attachment.setDocName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setType(file.getContentType());
        return repository.save(attachment).getId();
    }

    public Attachment findById(Long id) {
        Optional<Attachment> attachment = repository.findById(id);
        if (attachment.isPresent()) {
            return attachment.get();
        }
        throw new EntityNotFoundException();
    }
}
