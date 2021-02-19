package com.app.service.counter;

import com.app.AppConfig;
import com.app.Main;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author wozza
 */
@SpringBootTest(classes = Main.class)
@Import(AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

    @Autowired
    FileCounterServiceImpl service;

    @Test
    public void testResults() throws IOException {
        var results = service.countEntityWords();
        assertThat(results).isNotNull();
        assertThat(results).isNotEmpty();
        Logger.getAnonymousLogger().info(results.toString());
        assertThat(results.keySet()).containsAll(Arrays.asList(AppConfig.testWordsArray));
    }

    @Test
    public void testTopResults() throws IOException {
        int resultSize = 4;

        var results = service.getTopFileResults(resultSize);
        assertThat(results).isNotNull();
        assertThat(results).isNotEmpty();
        assertThat(results).hasSize(resultSize);
        assertThat(results.keySet()).containsSequence("fish", "a"); //TODO: ordered by size and alphabetically by key?
        assertThat(results.values()).containsExactly(3l, 2l, 1l, 1l);
    }

}
