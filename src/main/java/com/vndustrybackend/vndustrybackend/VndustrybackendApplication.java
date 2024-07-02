package com.vndustrybackend.vndustrybackend;

import static com.vndustrybackend.vndustrybackend.Vars.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vndustrybackend.vndustrybackend.Handlers.MindustryHandler.ResourceUtils;

@SpringBootApplication
public class VndustrybackendApplication {

	public static void main(String[] args) {

		if (!database.exists()) {
			System.out.println("Database not found");
			return;
		}

		cache.delete();

		dataDirectory.mkdirs();
		cache.mkdirs();
		resources.mkdirs();
		sprites.mkdirs();
		data.mkdirs();
		schematicSave.mkdirs();
		mapSave.mkdirs();

		ResourceUtils.init();
		SpringApplication.run(VndustrybackendApplication.class, args);
	}

}
