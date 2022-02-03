package ssafy.singlemeal.api;

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

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;
    private final RoomService roomService;

    @PostMapping("/api/members/login")
    public CreateMemberResponse saveMember(@RequestBody @Validated CreateMemberRequest request){

        Member member = new Member();
        member.setToken(request.getToken());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

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
