package com.app.service.counter;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

public interface FileCounterService {

    final static Pattern PATTERN = Pattern.compile("[\\W]+");

    public Map<String, Long> getTopFileResults(Integer count) throws IOException;
}
