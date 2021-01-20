package com.app.service.counter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public interface FileCounterService {

	final static Pattern pattern = Pattern.compile("[\\W]+");

	public Map<String, Integer> getTopFileResults(Integer count) throws IOException;
}
