package sopt.org.fourthSeminar.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSeminar.common.dto.ApiResponse;
import sopt.org.fourthSeminar.config.jwt.JwtService;
import sopt.org.fourthSeminar.config.resolver.UserId;
import sopt.org.fourthSeminar.controller.dto.request.BoardImageListRequestDto;
import sopt.org.fourthSeminar.exception.Success;
import sopt.org.fourthSeminar.external.client.aws.S3Service;
import sopt.org.fourthSeminar.service.BoardService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@SecurityRequirement(name = "JWT Auth")
public class BoardController {

    private final BoardService boardService;
    private final JwtService jwtService;
    private final S3Service s3Service;

/*
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(@RequestBody @Valid final BoardRequestDto request) {
        boardService.create(request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
*/

/*    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @RequestHeader("Authorization") String accessToken,
            @RequestBody @Valid final BoardRequestDto request) {
        boardService.create(Long.parseLong(jwtService.getJwtContents(accessToken)), request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }*/

/*    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @RequestBody @Valid final BoardRequestDto request) {
        boardService.create(userId, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }*/

//    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public ApiResponse create(
//            @UserId Long userId,
//            @ModelAttribute @Valid final BoardRequestDto request) {
//        String boardThumbnailImageUrl = s3Service.uploadImage(request.getThumbnail(), "board");
//        boardService.create(userId, boardThumbnailImageUrl, request);
//        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
//    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @ModelAttribute @Valid final BoardImageListRequestDto request) {
        List<String> boardThumbnailImageUrlList = s3Service.uploadImages(request.getBoardImages(), "board");
        boardService.create(userId, boardThumbnailImageUrlList, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}
