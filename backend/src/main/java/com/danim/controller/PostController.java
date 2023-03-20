package com.danim.controller;

import com.danim.entity.Photo;
import com.danim.entity.Post;
import com.danim.repository.PostRepository;
import com.danim.service.PhotoService;
import com.danim.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/auth/post")
@RestController
public class PostController {
    private final PostService postService;
    private final PhotoService photoService;
    private final PostRepository postRepository;

    //포스트 등록
    @PostMapping("")
    public ResponseEntity<?> insertPost(@RequestPart List<MultipartFile> imageFiles,
                                        @RequestPart MultipartFile voiceFile,
                                        @RequestPart Long timelineId) throws Exception {
        Post post = new Post();
        Post savedPost = postRepository.save(post);
        List<Photo> photoList = new ArrayList<>();
        for (MultipartFile imageFile : imageFiles) {
            Photo savedPhoto = photoService.createPhoto(imageFile, savedPost);
            photoList.add(savedPhoto);
        }
        Post resavedPost = postService.createPost(voiceFile, timelineId, photoList);
        return ResponseEntity.ok(resavedPost);
    }

    //포스트 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) throws Exception {
            postService.deletePostById(postId);
            return ResponseEntity.ok().build();
    }

    //지역명 키워드로 포스트 조회
//    @GetMapping("/{location}")
//    public ResponseEntity<?> getPost(@PathVariable String location) throws Exception {
//            List<Post> postList = postService.findByLocation(location);
//            return ResponseEntity.ok(postList);
//    }

}
