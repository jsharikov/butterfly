package com.epam.butterfly;

import com.epam.butterfly.utils.ZipUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Artsiom_Buyevich on 7/5/2016.
 */
public class ZipUtilsTest {

    @Test
    public void test() throws IOException {
        ZipUtils.unzip("test.zip", "d://");
    }
}
