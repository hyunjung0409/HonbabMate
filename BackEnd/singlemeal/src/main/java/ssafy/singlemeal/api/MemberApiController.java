package ssafy.singlemeal.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ssafy.singlemeal.domain.Member;
import ssafy.singlemeal.domain.Room;
import ssafy.singlemeal.domain.RoomOption;
import ssafy.singlemeal.domain.RoomStatus;
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
        member.setEmail(request.getEmail());
        member.setGender(request.getGender());
        member.setNickname(request.getNickname());

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }


    @ApiOperation(value = "매치 테스트")
    @PutMapping("/api/members/match")
    public MatchMemberResponse matchMember(@RequestBody @Validated MatchMemberRequest request){
        memberService.updateOption(request.getId(), request.getOption());
        /**
         * 매치 로직 추가
         * */
        Long roomId =  roomService.match(request.getId(), request.getOption());
        memberService.updateRoomId(request.getId(), roomId);

        return new MatchMemberResponse(roomId);
    }

//    @GetMapping("/api/members/escapeRoom")
//    public void escapeRoom(){
//
//    }

    @Data
    static class MatchMemberRequest{
        private Long id;
        private String Option;
    }

    @Data
    @AllArgsConstructor
    static class MatchMemberResponse{
        private Long id;
    }

    /**
     * 임시 : 방 생성 코드 by JPA
     * */
    @ApiOperation(value = "방 생성")
    @GetMapping("/createRoom")
    public void createRoom(){
        Room room = new Room();
        roomService.createRoom(room);
        for(int i = 1; i<=10; i++) {
            room = new Room();
            room.setRoomOption(RoomOption.TALKABLE2);
            room.setStatus(RoomStatus.NOTFULL);
            roomService.createRoom(room);
        }
        for(int i = 11; i<=20; i++){
            room = new Room();
            room.setRoomOption(RoomOption.NONTALKABLE2);
            room.setStatus(RoomStatus.NOTFULL);
            roomService.createRoom(room);
        }
        for(int i = 21; i<=30; i++){
            room = new Room();
            room.setRoomOption(RoomOption.TALKABLE5);
            room.setStatus(RoomStatus.NOTFULL);
            roomService.createRoom(room);
        }
        for(int i = 31; i<=40; i++){
            room = new Room();
            room.setRoomOption(RoomOption.NONTALKABLE5);
            room.setStatus(RoomStatus.NOTFULL);
            roomService.createRoom(room);
        }
    }

    @Data
    static class CreateMemberRequest{
        private String email;
        private String nickname;
        private String gender;
    }

    @Data
    @AllArgsConstructor
    static class CreateMemberResponse{
        private Long id;

    }



}
