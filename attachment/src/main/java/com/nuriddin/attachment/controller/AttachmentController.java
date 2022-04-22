package com.nuriddin.attachment.controller;

import com.nuriddin.attachment.entity.Attachment;
import com.nuriddin.attachment.entity.AttachmentContent;
import com.nuriddin.attachment.repository.AttachmentContentRepository;
import com.nuriddin.attachment.repository.AttachmentRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/attachments")
public record AttachmentController(AttachmentRepository attachmentRepository,
                                   AttachmentContentRepository attachmentContentRepository
) {



    @PostMapping()
    public HttpEntity uploadFile(@RequestPart("file") MultipartFile file) {
        Attachment savedAttachment = attachmentRepository.save(new Attachment(
                file.getOriginalFilename(),
                file.getSize(),
                file.getContentType()
        ));
        try {
            AttachmentContent content = attachmentContentRepository.save(new AttachmentContent(
                    file.getBytes(),
                    savedAttachment
            ));
            return ResponseEntity.ok().body("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/getFilesDb")
    public HttpEntity getFiles() {
        List<Attachment> files = attachmentRepository.findAll();
        return ResponseEntity.ok().body(files);
    }
}
