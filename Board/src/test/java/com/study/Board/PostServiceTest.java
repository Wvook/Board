package com.study.Board;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.study.Board.domain.post.PostRequest;
import com.study.Board.domain.post.PostResponse;
import com.study.Board.domain.post.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;


    @Test
    void save(){
        PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        Long id = postService.savePost(params);
        System.out.println("생성된 게시글 ID : " + id);
    }

    @Test
    void findByid(){
        PostResponse id = postService.findPostById(4L);
        try{
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(id);
            System.out.println(postJson);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test // 업데이트가 안되는데
    void update(){
        PostRequest params = new PostRequest();
        params.setId(4L);
        params.setTitle("첫걸음");
        params.setContent("제발");
        params.setWriter("Wook");
        params.setNoticeYn(false);
        postService.updatePost(params);

        PostResponse post = postService.findPostById(4L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

//    @Test
//    void delete(){
//        System.out.println("삭제 이전의 전체 게시글 개수는 : " + postService.findAllPost().size() + "개입니다.");
//        postService.deletePost(3L);
//        System.out.println("삭제 이후의 전체 게시글 개수는 : " + postService.findAllPost().size() + "개입니다.");
//    }

    @Test
    void saveByForeach() {
        for (int i = 1; i <= 1000; i++) {
            PostRequest params = new PostRequest();
            params.setTitle(i + "번 게시글 제목");
            params.setContent(i + "번 게시글 내용");
            params.setWriter("테스터" + i);
            params.setNoticeYn(false);
            postService.savePost(params);
        }
    }
}
