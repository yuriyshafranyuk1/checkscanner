package com.checkscanner.check;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class DataLoader {
	@PostConstruct
	public void loadSomeData() {
		final File dir = new File("src/main/resources/venues/");
		final File[] directoryListing = dir.listFiles();
		int count = 0;

		if (directoryListing != null) {

			for (final File child : directoryListing) {
				try {
					final Scanner scanner = new Scanner(child);
					final String content = scanner.useDelimiter("\\Z").next();

					final Gson gson = new GsonBuilder().create();
					final Map venue = gson.fromJson(content, Map.class);

					List<Map> placeCategories = (List<Map>) venue.get("categories");
					
					count++;
					
					System.out.println("bla bla bla");
				} catch (final FileNotFoundException e) {
				}
				Matcher matcher = Pattern.compile("@@\\p{IsWhite_Space}-[0-9]+(?:,[0-9]+)?\\p{IsWhite_Space}\\+([0-9]+)(?:,[0-9]+)?\\p{IsWhite_Space}@@.*").matcher("fdef hor rgrei gjreiog");
				if(matcher.matches()) {
					System.out.println("something");
				}
			}
		}
	}
}
