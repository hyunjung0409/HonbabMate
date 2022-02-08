package ssafy.singlemeal.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ssafy.singlemeal.domain.*;
import ssafy.singlemeal.file.FileStore;
import ssafy.singlemeal.file.UploadFile;
import ssafy.singlemeal.service.FileService;
import ssafy.singlemeal.service.MemberService;
import ssafy.singlemeal.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Slf4j
@Api(tags = {"api"})
@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;
    private final RoomService roomService;
    private final FileService fileService;
    private final FileStore fileStore;

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

        Long roomId =  roomService.match(request.getId(), request.getOption());
        memberService.updateRoomId(request.getId(), roomId);

        return new MatchMemberResponse(roomId);
    }

    @ApiOperation(value = "프로필 수정 테스트")
    @PutMapping("/api/profile")
    public void updateProfile(@RequestBody @Validated ProfileRequest request){
           memberService.updateProfile(request.getId(),request.getNickname(),request.getFoods(),request.getEtc());
    }

    @ApiOperation(value = "프로필 조회 테스트")
    @GetMapping("/api/profile/{id}")
    public CreateProfileResponse showProfile(@PathVariable("id") Long id){

        Member member = memberService.findOne(id);
        String nickName = member.getNickName();
        Long cntOfLikes = member.getCntOfLikes();
        List<String> foods = member.getFoods();
        List<String> etc = member.getEtc();

        return new CreateProfileResponse(member.getId(),nickName,cntOfLikes,foods,etc);
    }

    @ApiOperation(value = "좋아요 테스트")
    @GetMapping("/api/like/{id}")
    public void recommandMember(@PathVariable("id") Long id){

        memberService.updateLikes(id);
    }

    @ApiOperation(value = "이미지 업로드 테스트")
    @PostMapping("/api/image")
    public void updateImage(@RequestParam("file") MultipartFile file) throws IOException {

        UploadFile imageFile = fileStore.storeFile(file);
        Image image = new Image();

        log.info("file={}",file);

        image.setImageFile(imageFile);
        fileService.saveImage(image);
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
