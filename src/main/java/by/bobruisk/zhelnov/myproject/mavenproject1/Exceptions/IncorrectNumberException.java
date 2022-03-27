package by.bobruisk.zhelnov.myproject.mavenproject1.Exceptions;

public class IncorrectNumberException extends Exception {
		/**
	 * 
	 */
	private static final long serialVersionUID = 5045474994483233515L;
		private int number;
		public int getNumber() {
			return number;
		}
		public IncorrectNumberException(String message, int number) {
			super(message);
			this.number=number;
		}
}
