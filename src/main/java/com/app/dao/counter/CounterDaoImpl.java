package com.app.dao.counter;

import com.app.entity.WordsEntity;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("counterDao")
public class CounterDaoImpl implements CounterDao {

    @Override
    public WordsEntity fetchFile() throws IOException {
        return new WordsEntity(this, new ClassPathResource("sample.txt"));
    }

    public WordsEntity fetchFile(String resourceName) throws IOException {
        return new WordsEntity(this, new ClassPathResource(resourceName));
    }

    public Stream<String> splitStream(Pattern pattern, ClassPathResource textFile) throws IOException {
        return new Scanner(textFile.getInputStream()).useDelimiter(pattern).tokens();
    }

}
