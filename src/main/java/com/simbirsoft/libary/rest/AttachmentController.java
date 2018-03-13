package com.simbirsoft.libary.rest;

import com.simbirsoft.libary.entity.Attachment;
import com.simbirsoft.libary.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("api/attachment")
public class AttachmentController {
    @Autowired private AttachmentService service;

    @PostMapping
    public Long upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return service.upload(multipartFile);
    }

    @GetMapping("{id}")
    public HttpEntity<byte[]> download(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Attachment attachment = service.findById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", attachment.getType());
        response.setHeader("Content-Disposition", "attachment; filename=" + attachment.getDocName());

        return new HttpEntity<>(attachment.getFile(), headers);
    }

}
