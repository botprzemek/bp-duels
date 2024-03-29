package pl.botprzemek.bpDuels.Config;

import pl.botprzemek.bpDuels.BpDuels;
import pl.botprzemek.bpDuels.Game.Class.Classs;

import java.util.UUID;

public class ProfileConfig extends Config {

    BpDuels instance;

    public ProfileConfig(BpDuels instance) {

        super(instance, "profiles.yml");

        this.instance = instance;

    }

    public Classs getClass(UUID playerUUID) {

        return Classs.getClassByName(getString(playerUUID.toString() + ".class"));

    }

    public void setClass(UUID playerUUID, Classs classs) {

        set(playerUUID.toString() + ".class", classs.getRawClassName());

    }

}
