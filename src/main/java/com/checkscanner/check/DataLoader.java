package com.checkscanner.check;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Component
public class DataLoader
{
	
	private static List<Map> placeCategories;

	@PostConstruct
	public void loadSomeData()
	{
		final File dir = new File("src/main/resources/venues/");
		final File[] directoryListing = dir.listFiles();
		final int count = 0;

		if (directoryListing != null)
		{

			for (final File child : directoryListing)
			{
				try
				{
					final Scanner scanner = new Scanner(child);
					final String content = scanner.useDelimiter("\\Z").next();

					final Gson gson = new GsonBuilder().create();
					final Map venue = gson.fromJson(content, Map.class);

					placeCategories = (List<Map>) venue.get("categories");
					scanner.close();
				}
				catch (final FileNotFoundException e)
				{
				}
			}
		}

	}
}
