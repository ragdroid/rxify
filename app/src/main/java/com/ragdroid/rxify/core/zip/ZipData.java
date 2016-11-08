package com.ragdroid.rxify.core.zip;

/**
 * Created by garimajain on 09/11/16.
 */

public class ZipData {

    long fluxWeedTime;
    long crabHairTime;

    public ZipData() {
        reset();
    }

    public void setFluxWeedTime(long fluxWeedTime) {
        this.fluxWeedTime = fluxWeedTime;
    }

    public void setCrabHairTime(long crabHairTime) {
        this.crabHairTime = crabHairTime;
    }


    public boolean isCrabHairFirst() {
        if (crabHairTime == 0L) {
            return false;
        }
        if (fluxWeedTime == 0L) {
            return true;
        }
        return crabHairTime < fluxWeedTime;
    }

    public boolean isBothArrived() {
        return fluxWeedTime != 0L && crabHairTime != 0L;
    }

    public boolean isFluxWeedFirst() {
        if (fluxWeedTime == 0L) {
            return false;
        }
        if (crabHairTime == 0L) {
            return true;
        }
        return fluxWeedTime < crabHairTime;
    }

    public void reset() {
        fluxWeedTime = 0L;
        crabHairTime = 0L;
    }

}
