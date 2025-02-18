/*
package com.study.Board;

import com.study.Board.domain.comment.CommentRequest;
import com.study.Board.domain.comment.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class CommentServiceTest {
    @Autowired
    CommentService commentService;

    @Test
    void saveByForeach(){
        for(int i = 1; i <= 70; i++){
            CommentRequest params = new CommentRequest();
            params.setPostId(1L);
            params.setContent(i + "번 댓글 내용");
            params.setWriter("테스터" + i);
            commentService.saveComment(params);
        }
    }
}
*/
