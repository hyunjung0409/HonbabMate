package ssafy.singlemeal.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class MemberEtc {

    private String etc1;
    private String etc2;
    private String etc3;

    public MemberEtc(String etc1, String etc2, String etc3) {
        this.etc1 = etc1;
        this.etc2 = etc2;
        this.etc3 = etc3;
    }

    protected MemberEtc(){

    }
}
