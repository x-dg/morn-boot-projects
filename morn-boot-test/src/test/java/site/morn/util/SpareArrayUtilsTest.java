package site.morn.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * 数组工具单元测试
 *
 * @author timely-rain
 * @since 1.0.0, 2019/4/21
 */
@RunWith(JUnit4.class)
public class SpareArrayUtilsTest {

  private Integer[] intArray = {1, 2, 3};

  @Test
  public void isEmpty() {
    boolean isEmpty = SpareArrayUtils.isEmpty(intArray);
    Assert.assertFalse(isEmpty);
  }

  @Test
  public void toArray() {
    Integer[] merge = SpareArrayUtils.toArray(1, 2, 3);
    Assert.assertArrayEquals(intArray, merge);
  }

  @Test
  public void findValueForParent() {
    Object[] objects = {null, new Coffee(), new Banana(), new Apple()};
    Food first = SpareArrayUtils.findValueForParent(objects, Food.class);
    Assert.assertNotNull(first);
    Assert.assertEquals(first.getClass().getSimpleName(), Banana.class.getSimpleName());
  }

  @Test
  public void contains() {
    String[] empty = {};
    String[] large = {"2", "3", "1", null};
    String[] small = {"1", "2"};
    String[] nullable = {null};
    Assert.assertTrue(SpareArrayUtils.contains(empty, empty));
    Assert.assertTrue(SpareArrayUtils.contains(small, empty));
    Assert.assertTrue(SpareArrayUtils.contains(large, small));
    Assert.assertTrue(SpareArrayUtils.contains(large, nullable));
    Assert.assertFalse(SpareArrayUtils.contains(small, large));
  }

  private interface Food {

  }

  private interface Water {

  }

  private class Apple implements Food {

  }

  private class Banana implements Food {

  }

  private class Coffee implements Water {

  }
}