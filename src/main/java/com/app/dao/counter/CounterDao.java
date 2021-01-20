package com.app.dao.counter;

import com.app.entity.FileEntity;

import java.io.IOException;

public interface CounterDao {
    
	/**
     * The file is fetched from the file system in this case and returned back to the service layer.
     * The file returned back is obtained automatically from the resource path.
     * @return FileEntity This is wrapped object containing the file.
     * @throws IOException  Failure if the file is not found in the resource.
     */
    FileEntity fetchFile() throws IOException;

}
