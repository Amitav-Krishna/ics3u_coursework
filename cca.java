class Main {
	public static void main(String[] args) {
		String expression = "3+4*2-1"
		System.out.println(evaluate(expression));
	}

	public int evaluate(String expr) {
		int[] terms = [];
		String[] exprs = [];
		for (int i = 0; i < expr.length(); i++) 
			if ((int) expr.charAt(i) 

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		return a / b;
	}

}
