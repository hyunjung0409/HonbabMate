package ssafy.singlemeal.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class MemberProfile {

    private String interest;
    private String mbti;
    private String favorite;
    private Long like;

    public MemberProfile(String interest, String mbti, String favorite, Long like) {
        this.interest = interest;
        this.mbti = mbti;
        this.favorite = favorite;
        this.like = like;
    }

    // for jpa
    public MemberProfile() {

    }
}
