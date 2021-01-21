package com.mshcc.cloud.file;

import com.mshcc.cloud.file.util.FilePathByDeploy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
/**
 * @author mshcc
 * @Date 2021/1/13 9:12
 * @Description TODO
 */

@SpringBootApplication
@EnableConfigurationProperties({ FilePathByDeploy.class })
public class FileApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileApplication.class, args);
	}

}
