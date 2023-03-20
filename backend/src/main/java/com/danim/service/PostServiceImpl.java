package com.danim.service;

//import com.amazonaws.services.s3.AmazonS3;
import com.danim.entity.Nation;
import com.danim.entity.Photo;
import com.danim.entity.Post;
import com.danim.entity.TimeLine;
import com.danim.repository.PostRepository;
//import com.danim.utils.VoiceUtils;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {
//    private final AmazonS3 s3Client;
    private final PostRepository postRepository;
//    private final TimelineRepository timelineRepository;

    // 포스트 등록
    @Override
    public Post createPost(MultipartFile voiceFile, Long timelineId, List<Photo> photoList) throws IOException, UnsupportedAudioFileException {
        // voiceFile S3에 올리고 voiceURL 가져오기
//        String voiceKey = UUID.randomUUID().toString();
//        String voiceUrl = uploadFileToS3(voiceFile, voiceKey);

        // voice에서 voiceLength 가져오기
//        Long voiceLength = VoiceUtils.extractVoiceLength(voiceFile);

        // voiceFile -> text 변환
//        String text = "테스트용";

        // timeline 객체 가져오기
//        TimeLine timeline = timeLineRepository.findById(timelineId).orElseThrow(() -> new Exception("존재하지 않는 타임라인"));

        // imageURL, voiceURL db에 저장하기
        log.info("Starting savePost transaction");
        Post post = Post.builder()
                .voiceUrl("ㅁㄴㅇㄹ")
                .voiceLength(2L)
                .nationUrl("ㅁㄴㅇㄹ")
                .address("전주")
                .text("ㅁㄴㅇㄹ")
//                .timelineId(timeline)
//                .nationId(nation)
//                .photoList(photoList)
                .build();
        Post savedPost = postRepository.save(post);
        log.info("Transaction complete");
        return savedPost;

        // 파일 s3 서버에 올리는 메서드
//    private String uploadFileToS3(MultipartFile file, String key) throws IOException {
//        String bucketName = "my-bucket-name"; // 버킷 생성 후 수정 필요
//        s3Client.putObject(bucketName, key, file.getInputStream(), null);
//        return s3Client.getUrl(bucketName, key).toString();
//    }
    }

    // 포스트 삭제
    @Override
    public void deletePostById(Long postId) throws Exception {
        postRepository.deleteById(postId);
    }

    // 지역명 키워드로 포스트 조회
//    @Override
//    public List<Post> findByLocation(String location) throws Exception {
//        List<Post> postList = postRepository.finidByAddress(location);
//        return postList;
//    }
}
