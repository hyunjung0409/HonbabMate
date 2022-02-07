package ssafy.singlemeal.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class MemberFood {
    private String food1;
    private String food2;
    private String food3;

    public MemberFood(String food1, String food2, String food3) {
        this.food1 = food1;
        this.food2 = food2;
        this.food3 = food3;
    }

    protected MemberFood(){

    }
}
