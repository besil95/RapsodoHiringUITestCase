package test;

import driver.Driver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stepDefinitions.RapsodoDefinitions;

public class RapsodoTest extends Driver {
    RapsodoDefinitions rapsodoDefinitions;

    @Before
    public void before() {
        rapsodoDefinitions = new RapsodoDefinitions(webDriver);
    }

    @Test
    public void rapsodoShoppingAndCouponCodeCheck() {
        rapsodoDefinitions.homePageControl();
        rapsodoDefinitions.mlmPageControl();
        rapsodoDefinitions.shoppingSteps();
        rapsodoDefinitions.couponCodeCheck();
    }

}
