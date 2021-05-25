package odogo.whendb.util;

public class Exceptions {

	public class ConfigurationDiscrepencyException extends RuntimeException {
		private static final long serialVersionUID = -6777708869725739412L;
		public ConfigurationDiscrepencyException(String msg) { super(msg); }
	}
}
