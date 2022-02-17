package ssafy.singlemeal.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ssafy.singlemeal.domain.*;
import ssafy.singlemeal.file.FileStore;
import ssafy.singlemeal.file.UploadFile;
import ssafy.singlemeal.service.MemberService;
import ssafy.singlemeal.service.RoomService;
import java.util.List;

@Slf4j
@Api(tags = {"api"})
@RestController
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;
    private final RoomService roomService;
    private final FileStore fileStore;

    @ApiOperation(value = "온라인 카운트 테스트")
    @GetMapping("/api/members/online")
    public Long countOnlineMembers(){
        return memberService.countOnlines();
    }

    @ApiOperation(value = "로그인 테스트")
    @PostMapping("/api/members/login")
    public Long saveMember(@RequestBody @Validated CreateMemberRequest request){

        Member member = new Member();
        member.setEmail(request.getEmail());
        member.setGender(request.getGender());
        member.setNickname(request.getNickname());

        UploadFile imageFile = fileStore.storeUrltoFIle(request.getImageURL());
        member.setImagePath(imageFile.getFullPath());

        return memberService.join(member);
    }

    @ApiOperation(value = "로그아웃 테스트")
    @GetMapping("/api/members/logout/{id}")
    public void logoutMember(@PathVariable("id") Long id){
        memberService.logout(id);
    }

    @ApiOperation(value = "매치 테스트")
    @PutMapping("/api/members/match")
    public MatchMemberResponse matchMember(@RequestBody @Validated MatchMemberRequest request){

        Long roomId = roomService.match(request.getId(), request.getOption());
        memberService.updateOption(request.getId(), request.getOption());
        memberService.updateRoomId(request.getId(), roomId);

        return new MatchMemberResponse(memberService.findOne(request.getId()).getRoom().getId());
    }

    @ApiOperation(value="프로필 수정 테스트")
    @PutMapping("/api/profile")
    public CreateProfileResponse updateProfile(@ModelAttribute ProfileRequest request) {

        Member member = memberService.updateProfile(request.getId(), request.getNickname(), request.getFoods(), request.getEtc());

        return new CreateProfileResponse(member.getId(), member.getNickName(), member.getCntOfLikes(), member.getFood(), member.getEtc());
    }


    @ApiOperation(value = "프로필 조회 테스트")
    @GetMapping("/api/profile/{id}")
    public CreateProfileResponse showProfile(@PathVariable("id") Long id) {

        Member member = memberService.findOne(id);
        String nickName = member.getNickName();
        Long cntOfLikes = member.getCntOfLikes();
        List<String> foods = member.getFood();
        List<String> etc = member.getEtc();

        return new CreateProfileResponse(member.getId(),nickName,cntOfLikes,foods,etc);
    }

//    @ApiOperation(value = "프로필 이미지 조회 테스트")
//    @GetMapping("/api/profile/image/{id}")
//    public UrlResource getImage(@PathVariable("id") Long id) throws MalformedURLException {
//
//        Member member = memberService.findOne(id);
//        return new UrlResource("file:"+member.getImagePath());
//
//    }

    @ApiOperation(value = "방 나가기 테스트")
    @GetMapping("/api/member/matchOut/{id}")
    public void matchOutMember(@PathVariable("id") Long id){

        memberService.matchOutMember(id);

    }

    @ApiOperation(value = "싫어요 테스트")
    @GetMapping("/api/dislike/{id}")
    public Long dislikeMember(@PathVariable("id") Long id){

        return memberService.disLikeMember(id);
    }

    @ApiOperation(value = "좋아요 테스트")
    @GetMapping("/api/like/{id}")
    public Long likeMember(@PathVariable("id") Long id){

        return memberService.likeMmeber(id);
    }

    @Data
    @AllArgsConstructor
    static class CreateProfileResponse{
        private Long id;
        private String nickName;
        private Long cntOfLikes;
        private List<String> foods;
        private List<String> etc;
    }

    @Data
    static class ProfileRequest{

        private Long id;
        private String nickname;
        private List<String> foods;
        private List<String> etc;
    }

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


    @Data
    static class CreateMemberRequest{
        private String email;
        private String nickname;
        private String gender;
        private String imageURL;
    }

    /**
     * 임시 : 방 생성 코드 by JPA
     * */
    @ApiOperation(value = "방 생성")
    @GetMapping("/createRoom")
    public void createRoom() {
        Room room = new Room();
        roomService.createRoom(room);
        for (int i = 1; i <= 10; i++) {
            room = new Room();
            room.setRoomOption(RoomOption.TALKABLE2);
            room.setStatus(RoomStatus.NOTFULL);
            roomService.createRoom(room);
        }
        for (int i = 11; i <= 20; i++) {
            room = new Room();
            room.setRoomOption(RoomOption.NONTALKABLE2);
            room.setStatus(RoomStatus.NOTFULL);
            roomService.createRoom(room);
        }
        for (int i = 21; i <= 30; i++) {
            room = new Room();
            room.setRoomOption(RoomOption.TALKABLE5);
            room.setStatus(RoomStatus.NOTFULL);
            roomService.createRoom(room);
        }
        for (int i = 31; i <= 40; i++) {
            room = new Room();
            room.setRoomOption(RoomOption.NONTALKABLE5);
            room.setStatus(RoomStatus.NOTFULL);
            roomService.createRoom(room);
        }
    }
}
