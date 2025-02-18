package com.study.Board;

import com.study.Board.common.dto.SearchDto;
import com.study.Board.common.paging.PagingResponse;
import com.study.Board.domain.post.PostResponse;
import com.study.Board.domain.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestApiTestController {

    private final PostService postService;

    @GetMapping("/posts")
    public PagingResponse<PostResponse> findAllPost() {
        return postService.findAllPost(new SearchDto());
    }

}