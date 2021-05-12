package com.lemon.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author lemon
 * @since 2021-05-07
 */
public class JacksonProvider {
    /**
     * <p>
     * json 支持 java.util.Date 和 java.time 序列化 java.util.Date 只有 seconds 级别的进度，java.time 有可选的 nano seconds
     * 级别精度。 java.time 和 java.util.Date 默认序列化为 string。
     * <p>
     * 序列化结果看 com.xiaoju.util.app.extension.core.JacksonDateTest#showFormat()
     */
    public static final ObjectMapper objectMapper = newObjectMapper();

//    /**
//     * 可以直接使用 import static
//     */
//    public static final EnhancedObjectMapper jsonConverter = new NullSafeObjectMapper(objectMapper);

    private static ObjectMapper newObjectMapper() {
        ObjectMapper mapper = JacksonFactory.newDefaultObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }
}
