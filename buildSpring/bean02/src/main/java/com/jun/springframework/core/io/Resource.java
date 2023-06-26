package com.jun.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: buildSpring
 * @description:
 * @author: jun.luo
 * @create: 2023-06-20 16:24
 **/
public interface Resource {
    InputStream getInputStream() throws IOException;
}
