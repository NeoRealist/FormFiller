package by.bobruisk.zhelnov.myproject.mavenproject1.Exceptions;

public class IncorrectNumberException extends Exception {
		private int number;
		public int getNumber() {
			return number;
		}
		public IncorrectNumberException(String message, int number) {
			super(message);
			this.number=number;
		}
}
