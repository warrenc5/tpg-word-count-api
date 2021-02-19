package com.app.service.counter;

import com.app.dao.counter.CounterDao;
import com.app.entity.WordsEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import static java.util.function.Function.identity;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FileCounterServiceImpl implements FileCounterService {

	@Autowired
    @Qualifier("counterDao")
    private CounterDao counterDao;

    Map<String, Long> countEntityWords() throws IOException {
        WordsEntity textFile = counterDao.fetchFile();
        //Scan each line filter search words and add the word count and associate with search variables at once.
        //TODO: map through to lowercase - check with business requirements
        Map<String, Long> wordCountMap = (Map<String, Long>) textFile.splitStream(FileCounterService.PATTERN).collect(Collectors.groupingBy(identity(), counting()));
        return wordCountMap;
    }

	@Override
    public Map<String, Long> getTopFileResults(Integer count) throws IOException {
        Set<Map.Entry<String, Long>> set = countEntityWords().entrySet();
        ArrayList<Map.Entry<String, Long>> list = new ArrayList<>(set);
        Collections.sort(list, (Entry<String, Long> o1, Entry<String, Long> o2) -> o2.getValue().compareTo(o1.getValue()));
		return list.stream().limit(count).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));
	}
}