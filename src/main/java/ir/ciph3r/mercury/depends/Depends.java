package ir.ciph3r.mercury.depends;

import io.github.leonardosnt.bungeechannelapi.BungeeChannelApi;
import ir.ciph3r.mercury.MercuryAPI;
import ir.ciph3r.mercury.depends.impl.PapiAPI;
import ir.ciph3r.mercury.depends.impl.Vanish;
import lombok.Getter;

@Getter
public class Depends {
    private final BungeeChannelApi bungeeAPI;
    private final Vanish vanish;
    private final PapiAPI papiAPI;

    public Depends() {
        this.bungeeAPI = BungeeChannelApi.of(MercuryAPI.INSTANCE.getPlugin());
        this.vanish = new Vanish();
        this.papiAPI = new PapiAPI();
    }
}
