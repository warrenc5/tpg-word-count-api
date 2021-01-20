package com.app.dao.counter;

import com.app.entity.FileEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
@Qualifier("counterDao")
public class CounterDaoImpl implements CounterDao {

	@Override
	public FileEntity fetchFile() throws IOException {
		return new FileEntity(new ClassPathResource("sample.txt"));
	}
}
