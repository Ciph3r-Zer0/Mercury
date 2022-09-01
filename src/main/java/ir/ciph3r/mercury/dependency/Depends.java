package ir.ciph3r.mercury.dependency;

import ir.ciph3r.mercury.dependency.impl.Vanish;
import lombok.Getter;

@Getter
public class Depends {
    private final Vanish vanish;

    public Depends() {
        this.vanish = new Vanish();
    }
}
