package rpg_lab;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {

    private final static int TARGET_EXP = 10;
    @Test
    public void testHeroGainsXPWhenTargetDies() {

        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_EXP);

        Hero hero = new Hero("Hachi", weaponMock);

        hero.attack(targetMock);

        Assert.assertEquals(TARGET_EXP, hero.getExperience());
    }


}

