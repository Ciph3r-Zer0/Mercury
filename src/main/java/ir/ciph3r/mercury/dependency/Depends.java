package ir.ciph3r.mercury.dependency;

import io.github.leonardosnt.bungeechannelapi.BungeeChannelApi;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.dependency.impl.Vanish;
import lombok.Getter;

@Getter
public class Depends {
    private final BungeeChannelApi bungeeAPI;
    private final Vanish vanish;

    public Depends() {
        this.bungeeAPI = BungeeChannelApi.of(MercuryAPI.INSTANCE.getPlugin());
        this.vanish = new Vanish();
    }
}
