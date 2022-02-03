package ssafy.singlemeal.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ssafy.singlemeal.domain.Member;
import ssafy.singlemeal.domain.Room;
import ssafy.singlemeal.service.MemberService;
import ssafy.singlemeal.service.RoomService;

@Api(tags = {"api"})
@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;
    private final RoomService roomService;

    @ApiOperation(value = "로그인 테스트")
    @PostMapping("/api/members/login")
    public CreateMemberResponse saveMember(@RequestBody @Validated CreateMemberRequest request){

        Member member = new Member();
        member.setToken(request.getToken());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    /**
     * 임시 : 방 생성 코드 by JPA
     * */
    @ApiOperation(value = "방 생성")
    @GetMapping("/createRoom")
    public void createRoom(){

        Room room = new Room();
        roomService.createRoom(room);
    }

    @Data
    static class CreateMemberRequest{
        private String token;

    }

    @Data
    @AllArgsConstructor
    static class CreateMemberResponse{
        private Long id;

    }



}
