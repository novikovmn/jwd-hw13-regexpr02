package by.epam.hw13.regexpr02.validator;

import java.util.HashMap;
import java.util.Map;

import by.epam.hw13.regexpr02.bean.User;
import by.epam.hw13.regexpr02.validator.exception.UserValidatorException;

public class UserValidator {

	// для проверки полей
	private final String ID_PATTERN = "\\d+";
	private final String NICKNAME_PATTERN = "[\\w\\.]{4,}";
	private final String EMAIL_PATTERN = "[\\w\\.]+@\\w+\\.\\w+";
	private final String PHONE_NUMBER_PATTERN = "\\+375(29|44|25|33)\\-\\d{3}\\-\\d{2}-\\d{2}";

	private String userId;
	private String nickName;
	private String email;
	private String phoneNumber;

	public UserValidator(UserValidatorBuilderImpl userValidatorBuilderImpl) {
		this.userId = userValidatorBuilderImpl.userId;
		this.nickName = userValidatorBuilderImpl.nickName;
		this.email = userValidatorBuilderImpl.email;
		this.phoneNumber = userValidatorBuilderImpl.phoneNumber;
	}

//////////////////////////// user validator builder class/////////////////////////////////////////////
	public static class UserValidatorBuilderImpl implements Builder<UserValidator> {

		private String userId;
		private String nickName;
		private String email;
		private String phoneNumber;

		public UserValidatorBuilderImpl userId(String userId) {
			this.userId = userId;
			return this;
		}

		public UserValidatorBuilderImpl nickName(String nickName) {
			this.nickName = nickName;
			return this;
		}

		public UserValidatorBuilderImpl email(String email) {
			this.email = email;
			return this;
		}

		public UserValidatorBuilderImpl phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		@Override
		public UserValidator build() {
			return new UserValidator(this);
		}

	}
////////////////////////////////////////////////////////////////////////////////////////////////////

	public User validate() throws UserValidatorException {
		Map<String, String> incorrectValues = new HashMap<>();

		if (userId != null && !userId.matches(ID_PATTERN)) {
			incorrectValues.put("userId", userId);
		}

		if (nickName != null && !nickName.matches(NICKNAME_PATTERN)) {
			incorrectValues.put("nickName", nickName);
		}

		if (email != null && !email.matches(EMAIL_PATTERN)) {
			incorrectValues.put("email", email);
		}

		if (phoneNumber != null && !phoneNumber.matches(PHONE_NUMBER_PATTERN)) {
			incorrectValues.put("phoneNumber", phoneNumber);
		}

		if (incorrectValues.isEmpty()) {
			if (userId == null) {
				return new User(nickName, email, phoneNumber);
			} else {
				return new User(Integer.parseInt(userId), nickName, email, phoneNumber);
			}
		} else {
			throw new UserValidatorException("Fields that are not validated:", incorrectValues);
		}
	}

}
