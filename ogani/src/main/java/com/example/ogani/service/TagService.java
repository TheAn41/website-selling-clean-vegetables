package com.example.ogani.service;

import com.example.ogani.dto.TagDTO;
import com.example.ogani.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getListTag();
    Tag createTag(TagDTO tagDTO);
    Tag updateTag( Long id,TagDTO tagDTO);
    void deleteTag(Long id);
    void enableTag(Long id);
}
