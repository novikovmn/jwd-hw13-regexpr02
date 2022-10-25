package by.epam.hw13.regexpr02.main;

import java.util.Map.Entry;
import java.util.Set;

import by.epam.hw13.regexpr02.bean.User;
import by.epam.hw13.regexpr02.validator.UserValidator;
import by.epam.hw13.regexpr02.validator.exception.UserValidatorException;

public class Main {

	public static void main(String[] args) {

		UserValidator.UserValidatorBuilderImpl validatorBuilder = new UserValidator.UserValidatorBuilderImpl();

		UserValidator userValidator = validatorBuilder
													.userId("11cxcd")
													.nickName("agent007")
													.email("ivan.agent007@bk.ru")
													.phoneNumber("+37544-222-33-44")
													.build();

		try {
			User user = userValidator.validate();
			System.out.print("All fields are validated: \n" + user);
			
		} catch (UserValidatorException e) {
			System.err.println("\t" + e.getMessage());
			Set<Entry<String, String>> incorrectValues = e.getIncorrectValues().entrySet();
			for (Entry<String, String> incorrectValue : incorrectValues) {
				System.err.println("\"" + incorrectValue.getKey() + "\"" + " has the wrong value -> " + incorrectValue.getValue());
			}
		}

	}

}
