package com.epam.butterfly;

import com.epam.butterfly.utils.ZipUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * ZipUtils test.
 *
 * @author Artsiom_Buyevich
 */
public class ZipUtilsTest {

    @Test
    public void test() throws IOException {
        ZipUtils.unzip("test.zip", "d://");
    }
}
