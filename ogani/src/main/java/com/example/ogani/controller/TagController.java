package com.example.ogani.controller;

import com.example.ogani.dto.TagDTO;
import com.example.ogani.entity.Tag;
import com.example.ogani.response.MessageResponse;
import com.example.ogani.service.TagService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public ResponseEntity<?> getListTag() {
        List<Tag> tags = tagService.getListTag();
        return ResponseEntity.ok(tags);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createTag(@Valid @RequestBody TagDTO tagDTO) {
        Tag tag = tagService.createTag(tagDTO);
        return ResponseEntity.ok(tag);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTag(@PathVariable Long id,@Valid @RequestBody TagDTO tagDTO) {
        Tag tag = tagService.updateTag(id, tagDTO);
        return ResponseEntity.ok(tag);
    }
    @PutMapping("/enable/{id}")
    public ResponseEntity<?> enableTag(@PathVariable Long id) {
        tagService.enableTag(id);
        return ResponseEntity.ok(new MessageResponse("Cập nhật thành công"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.ok(new MessageResponse("Xoá thành công"));
    }
}
