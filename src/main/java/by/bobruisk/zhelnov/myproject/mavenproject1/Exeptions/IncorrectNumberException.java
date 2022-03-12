package by.bobruisk.zhelnov.myproject.mavenproject1.Exeptions;

public class IncorrectNumberException extends IllegalArgumentException {
		private int number;
		public int getNumber() {
			return number;
		}
		public IncorrectNumberException(String message, int number) {
			super(message);
			this.number=number;
		}
}
