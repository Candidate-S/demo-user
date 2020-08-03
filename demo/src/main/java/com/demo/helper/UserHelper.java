package com.demo.helper;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import org.springframework.util.StringUtils;

import com.demo.request.FindUserRequest;
import com.demo.request.User;

public class UserHelper {

	public static final String SEP = ",";
	public static final String NEWLINE = "\n";
	public static final String USERFILE = "users.csv";
	public static final int INVALID = -1;

	public static User findInCSV(final FindUserRequest criteria) throws Exception {

		File file = new File("test.csv");

		List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

		User result = new User();
		int columnToFind;

		switch (criteria.getType()) {

		case NAME: {
			columnToFind = 0;
			break;
		}

		case IC: {
			columnToFind = 1;
			break;
		}

		default: {
			columnToFind = INVALID;
			break;
		}
		}

		if (columnToFind == INVALID) {
			// TODO error handling
			throw new Exception();
		}

		for (String line : lines) {
			String[] array = line.split(",", -1);

			String targetColumn = array[columnToFind];

			if (array.length < 2) {
				//TODO log and handle error (data integrity)
				continue;
			}

			if (StringUtils.isEmpty(targetColumn)) {
				//TODO log and handle error (data integrity)
				continue;
			}

			if (targetColumn.equalsIgnoreCase(criteria.getValue())) {

				result.setName(array[0]);
				result.setIC(array[1]);
				result.setPhoneNumber(array[2]);
				result.setGender(array[3]);

				return result;
			}
		}

		return null;
	}

	public static User writeToCSV(final User user) {

		File file = new File(USERFILE);

		try (PrintWriter pw = new PrintWriter(file);) {

			String headers = "";
			String columnNamesList = "Name, IC, Phone Number, Gender";
			headers += columnNamesList + "\n";

			String values = "";

			values = appendCSVFieldsTo(user.getName(), values);
			values = appendCSVFieldsTo(user.getIC(), values);
			values = appendCSVFieldsTo(user.getPhoneNumber(), values);
			values = appendCSVFieldsTo(user.getGender(), values);

			if (file.exists() && !file.isDirectory()) {
				// append
				pw.append(values + NEWLINE);
			} else {
				// write
				pw.write(headers + values + NEWLINE);
			}

			return user;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private static String appendCSVFieldsTo(String value, String output) {
		output += value + SEP;

		return output;
	}
}