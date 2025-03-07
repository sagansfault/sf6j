package sh.sagan.sf6j;

import java.util.Objects;

public class Move {

    private final String identifier;
    private final String input;
    private final String name;
    private final String image;
    private final String damage;
    private final String chipDamage;
    private final String damageScaling;
    private final String guard;
    private final String cancel;
    private final String hitconfirmWindow;
    private final String startup;
    private final String active;
    private final String recovery;
    private final String total;
    private final String hitstun;
    private final String blockstun;
    private final String driveDamageBlock;
    private final String driveDamageHit;
    private final String driveGain;
    private final String superGainHit;
    private final String superGainBlock;
    private final String projectileSpeed;
    private final String invuln;
    private final String armor;
    private final String airborne;
    private final String juggleStart;
    private final String juggleIncrease;
    private final String juggleLimit;
    private final String perfectParryAdvantage;
    private final String afterDriveRushHit;
    private final String afterDriveRushBlock;
    private final String driveRushCancelHit;
    private final String driveRushCancelBlock;
    private final String punishAdvantage;
    private final String hitAdvantage;
    private final String blockAdvantage;
    private final String hitstop;
    private final String attackRange;
    private final String notes;

    public Move(String identifier, String input, String name, String image, String damage, String chipDamage, String damageScaling,
                String guard, String cancel, String hitconfirmWindow, String startup, String active, String recovery,
                String total, String hitstun, String blockstun, String driveDamageBlock, String driveDamageHit,
                String driveGain, String superGainHit, String superGainBlock, String projectileSpeed, String invuln,
                String armor, String airborne, String juggleStart, String juggleIncrease, String juggleLimit,
                String perfectParryAdvantage, String afterDriveRushHit, String afterDriveRushBlock,
                String driveRushCancelHit, String driveRushCancelBlock, String punishAdvantage, String hitAdvantage,
                String blockAdvantage, String hitstop, String attackRange, String notes) {
        this.identifier = identifier;
        this.input = input;
        this.name = name;
        this.image = image;
        this.damage = damage;
        this.chipDamage = chipDamage;
        this.damageScaling = damageScaling;
        this.guard = guard;
        this.cancel = cancel;
        this.hitconfirmWindow = hitconfirmWindow;
        this.startup = startup;
        this.active = active;
        this.recovery = recovery;
        this.total = total;
        this.hitstun = hitstun;
        this.blockstun = blockstun;
        this.driveDamageBlock = driveDamageBlock;
        this.driveDamageHit = driveDamageHit;
        this.driveGain = driveGain;
        this.superGainHit = superGainHit;
        this.superGainBlock = superGainBlock;
        this.projectileSpeed = projectileSpeed;
        this.invuln = invuln;
        this.armor = armor;
        this.airborne = airborne;
        this.juggleStart = juggleStart;
        this.juggleIncrease = juggleIncrease;
        this.juggleLimit = juggleLimit;
        this.perfectParryAdvantage = perfectParryAdvantage;
        this.afterDriveRushHit = afterDriveRushHit;
        this.afterDriveRushBlock = afterDriveRushBlock;
        this.driveRushCancelHit = driveRushCancelHit;
        this.driveRushCancelBlock = driveRushCancelBlock;
        this.punishAdvantage = punishAdvantage;
        this.hitAdvantage = hitAdvantage;
        this.blockAdvantage = blockAdvantage;
        this.hitstop = hitstop;
        this.attackRange = attackRange;
        this.notes = notes;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getInput() {
        return input;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDamage() {
        return damage;
    }

    public String getChipDamage() {
        return chipDamage;
    }

    public String getDamageScaling() {
        return damageScaling;
    }

    public String getGuard() {
        return guard;
    }

    public String getCancel() {
        return cancel;
    }

    public String getHitconfirmWindow() {
        return hitconfirmWindow;
    }

    public String getStartup() {
        return startup;
    }

    public String getActive() {
        return active;
    }

    public String getRecovery() {
        return recovery;
    }

    public String getTotal() {
        return total;
    }

    public String getHitstun() {
        return hitstun;
    }

    public String getBlockstun() {
        return blockstun;
    }

    public String getDriveDamageBlock() {
        return driveDamageBlock;
    }

    public String getDriveDamageHit() {
        return driveDamageHit;
    }

    public String getDriveGain() {
        return driveGain;
    }

    public String getSuperGainHit() {
        return superGainHit;
    }

    public String getSuperGainBlock() {
        return superGainBlock;
    }

    public String getProjectileSpeed() {
        return projectileSpeed;
    }

    public String getInvuln() {
        return invuln;
    }

    public String getArmor() {
        return armor;
    }

    public String getAirborne() {
        return airborne;
    }

    public String getJuggleStart() {
        return juggleStart;
    }

    public String getJuggleIncrease() {
        return juggleIncrease;
    }

    public String getJuggleLimit() {
        return juggleLimit;
    }

    public String getPerfectParryAdvantage() {
        return perfectParryAdvantage;
    }

    public String getAfterDriveRushHit() {
        return afterDriveRushHit;
    }

    public String getAfterDriveRushBlock() {
        return afterDriveRushBlock;
    }

    public String getDriveRushCancelHit() {
        return driveRushCancelHit;
    }

    public String getDriveRushCancelBlock() {
        return driveRushCancelBlock;
    }

    public String getPunishAdvantage() {
        return punishAdvantage;
    }

    public String getHitAdvantage() {
        return hitAdvantage;
    }

    public String getBlockAdvantage() {
        return blockAdvantage;
    }

    public String getHitstop() {
        return hitstop;
    }

    public String getAttackRange() {
        return attackRange;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(identifier, move.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifier);
    }

    @Override
    public String toString() {
        return "Move{" +
                "active='" + active + '\'' +
                ", identifier='" + identifier + '\'' +
                ", input='" + input + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", damage='" + damage + '\'' +
                ", chipDamage='" + chipDamage + '\'' +
                ", damageScaling='" + damageScaling + '\'' +
                ", guard='" + guard + '\'' +
                ", cancel='" + cancel + '\'' +
                ", hitconfirmWindow='" + hitconfirmWindow + '\'' +
                ", startup='" + startup + '\'' +
                ", recovery='" + recovery + '\'' +
                ", total='" + total + '\'' +
                ", hitstun='" + hitstun + '\'' +
                ", blockstun='" + blockstun + '\'' +
                ", driveDamageBlock='" + driveDamageBlock + '\'' +
                ", driveDamageHit='" + driveDamageHit + '\'' +
                ", driveGain='" + driveGain + '\'' +
                ", superGainHit='" + superGainHit + '\'' +
                ", superGainBlock='" + superGainBlock + '\'' +
                ", projectileSpeed='" + projectileSpeed + '\'' +
                ", invuln='" + invuln + '\'' +
                ", armor='" + armor + '\'' +
                ", airborne='" + airborne + '\'' +
                ", juggleStart='" + juggleStart + '\'' +
                ", juggleIncrease='" + juggleIncrease + '\'' +
                ", juggleLimit='" + juggleLimit + '\'' +
                ", perfectParryAdvantage='" + perfectParryAdvantage + '\'' +
                ", afterDriveRushHit='" + afterDriveRushHit + '\'' +
                ", afterDriveRushBlock='" + afterDriveRushBlock + '\'' +
                ", driveRushCancelHit='" + driveRushCancelHit + '\'' +
                ", driveRushCancelBlock='" + driveRushCancelBlock + '\'' +
                ", punishAdvantage='" + punishAdvantage + '\'' +
                ", hitAdvantage='" + hitAdvantage + '\'' +
                ", blockAdvantage='" + blockAdvantage + '\'' +
                ", hitstop='" + hitstop + '\'' +
                ", attackRange='" + attackRange + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
