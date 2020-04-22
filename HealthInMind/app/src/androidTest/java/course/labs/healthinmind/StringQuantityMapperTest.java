package course.labs.healthinmind;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.common.Quantity;
import course.labs.healthinmind.screens.addmedicine.StringFormsMapper;
import course.labs.healthinmind.screens.addmedicine.reminders.StringQuantityMapper;

@RunWith(AndroidJUnit4.class)
public class StringQuantityMapperTest {

    StringQuantityMapper mapper;
    Context context;
    @Test
    public void test(){
        context  = ApplicationProvider.getApplicationContext();
        mapper = new StringQuantityMapper(context);

        testValue(Quantity.QUARTER, context.getString(R.string.quarter));
        testValue(Quantity.HALF, context.getString(R.string.half));
        testValue(Quantity.ONE, context.getString(R.string.one));
        testValue(Quantity.ONE_AND_QUARTER, context.getString(R.string.one_and_quarter));
        testValue(Quantity.ONE_AND_HALF, context.getString(R.string.one_and_half));
        testValue(Quantity.ONE_AND_TREE_QUARTERS, context.getString(R.string.one_and_three_quarters));
        testValue(Quantity.TWO, context.getString(R.string.two));

    }

    private void testValue(Quantity quantity, String expected){
        String value = mapper.getString(quantity);
        Assert.assertNotNull(value);
        Assert.assertEquals(expected,value);
    }
}
