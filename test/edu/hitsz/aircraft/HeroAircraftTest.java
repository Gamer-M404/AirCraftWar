package edu.hitsz.aircraft;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HeroAircraftTest {

    @Test
    void getInstance() {
        HeroAircraft h1 = HeroAircraft.getInstance();
        HeroAircraft h2 = HeroAircraft.getInstance();
        assertEquals(h1, HeroAircraft.getInstance());
        assertEquals(h1, h2);
    }

    @Test
    void forward() {
        HeroAircraft h = HeroAircraft.getInstance();
        int x = h.getLocationX(), y = h.getLocationY();
        h.forward();
        assertEquals(x + h.getSpeedX(), h.getLocationX());
        assertEquals(y + h.getSpeedY(), h.getLocationY());
    }

    @ParameterizedTest
    @ValueSource(ints={2, 3, 5, 8, 10,-1})
    void setShootNum(int num) {
        HeroAircraft h = HeroAircraft.getInstance();
        h.setShootNum(num);
        assertEquals(h.getShootNum(), num);
    }

}