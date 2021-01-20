package com.app.entity;

import org.springframework.core.io.ClassPathResource;

public class FileEntity {
	ClassPathResource file;

	public FileEntity(ClassPathResource classPathResource) {
		this.file = classPathResource;
	}

	public ClassPathResource getFileText() {
		return file;
	}
}
