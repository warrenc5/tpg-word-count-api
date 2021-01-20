package com.app.service.counter;

import com.app.dao.counter.CounterDao;
import com.app.entity.FileEntity;
import com.app.service.counter.FileCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileCounterServiceImpl implements FileCounterService {

	@Autowired
	@Qualifier("counterDao")
	private CounterDao counterDao;

	public Map<String, Integer> findcountforparameters() throws IOException {
		FileEntity textFile = counterDao.fetchFile();
		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();

		//Scan each line filter search words and add the word count and associate with search variables at once.
		BufferedReader br = new BufferedReader(new InputStreamReader(textFile.getFileText().getInputStream()));
		String line;
		while ((line = br.readLine()) != null) {
			for(String word : pattern.split(line)) {
				wordCountMap.put(word, Optional.ofNullable(wordCountMap.get(word)).orElse(new Integer(0)) + 1);
			}
		}
		return wordCountMap;
	}

	@Override
	public Map<String, Integer> getTopFileResults(Integer count) throws IOException {
		Set<Map.Entry<String, Integer>> set = findcountforparameters().entrySet();
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
		Collections.sort(list, (Entry<String, Integer> o1, Entry<String, Integer> o2) -> o2.getValue().compareTo(o1.getValue()));
		return list.stream().limit(count).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));
	}
}