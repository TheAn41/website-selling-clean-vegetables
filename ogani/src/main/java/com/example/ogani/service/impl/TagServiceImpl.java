package com.example.ogani.service.impl;

import com.example.ogani.dto.TagDTO;
import com.example.ogani.entity.Tag;
import com.example.ogani.exception.NotFoundException;
import com.example.ogani.repository.TagRepository;
import com.example.ogani.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;
    @Override
    public List<Tag> getListTag() {
        List<Tag> tags = tagRepository.findAll(Sort.by("id").descending());
        return tags;
    }

    @Override
    public Tag createTag(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setName(tagDTO.getName());
        tag.setEnable(false);
        tagRepository.save(tag);
        return tag;
    }

    @Override
    public Tag updateTag(Long id, TagDTO tagDTO) {
Tag tag = tagRepository.findById(id).orElseThrow(()-> new NotFoundException("Tag not found with id "+id));
tag.setName(tagDTO.getName());
tagRepository.save(tag);
        return tag;
    }

    @Override
    public void deleteTag(Long id) {
        Tag tag = tagRepository.findById(id).orElseThrow(()-> new NotFoundException("Tag not found with id "+id));
        tagRepository.delete(tag);

    }

    @Override
    public void enableTag(Long id) {
        Tag tag = tagRepository.findById(id).orElseThrow(()-> new NotFoundException("Tag not found with id "+id));
        if (tag.isEnable()){
            tag.setEnable(false);
        }else {
            tag.setEnable(true);
        }
tagRepository.save(tag);
    }
}
