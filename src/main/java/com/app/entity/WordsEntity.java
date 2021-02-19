package com.app.entity;

import com.app.dao.counter.CounterDaoImpl;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.springframework.core.io.ClassPathResource;

public class WordsEntity {
    private final ClassPathResource file;
    private final CounterDaoImpl dao;

    public WordsEntity(CounterDaoImpl dao, ClassPathResource classPathResource) {
        this.dao = dao;
		this.file = classPathResource;
	}

	public ClassPathResource getFileText() {
		return file;
    }

    public Stream splitStream(Pattern pattern) throws IOException {
        return dao.splitStream(pattern, this.file);
    }
}
