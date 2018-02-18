package com.gitlab.adilcan.erp.service_product.api;

import com.gitlab.adilcan.erp.service_product.Tag;
import com.gitlab.adilcan.erp.service_product.TagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityListeners;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/tags")
public class TagApiController {

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Tag>> getTagList(){
        return ResponseEntity.ok(tagRepository.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Tag> createNewTag(@Validated @RequestBody Tag tag){
        tagRepository.save(tag);
        return ResponseEntity.ok(tag);
    }

    @PutMapping("")
    public ResponseEntity<Tag> updateTag(@Validated @RequestBody Tag tag){
        tagRepository.save(tag);
        return ResponseEntity.ok(tag);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> showTag(@PathVariable Long id){

        Optional<Tag> tagOptional = tagRepository.findById(id);

        if(!tagOptional.isPresent()){
            log.warn("Tag with id: {} is not present");
            return ResponseEntity.noContent().build();
        }
        else
        {
            return ResponseEntity.ok(tagOptional.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id){
        tagRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
