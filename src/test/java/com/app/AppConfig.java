package com.app;

import com.app.dao.counter.CounterDao;
import com.app.entity.WordsEntity;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wozza
 */
@TestConfiguration
public class AppConfig {

    public AppConfig() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    CounterDao testDao;
    @Mock
    WordsEntity testWords;

    public static String[] testWordsArray = new String[]{"hello", "I", "am", "a", "fish", "yes", "a", "fish", "is", "not", "fish"};

    @Bean(name = "counterDao")
    @Primary
    CounterDao createCounterDao() throws IOException {
        assertThat(testWords).isNotNull();
        assertThat(testDao).isNotNull();
        Mockito.doAnswer(ic -> Arrays.stream(testWordsArray)).when(testWords).splitStream(any(Pattern.class));
        Mockito.doReturn(testWords).when(testDao).fetchFile();
        return testDao;
    }

}
