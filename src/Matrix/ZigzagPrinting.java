package Matrix;

public class ZigzagPrinting {
	public int[] printMatrixZigZag(int[][] m) {
		int[] error = new int[0];
		if (m == null || m.length == 0)
			return error;
		// 设置一个flag来指示向斜上打印，还是斜下打印
		boolean flag = true; // 初始时，默认向斜上打印
		int i = 0;
		int j = 0;// 当前节点下标

		// 边界
		int dr = m.length;
		int dc = m[0].length;

		int[] restult = new int[dr * dc + 1];
		int index = 0;
		while (i + 1 != dr || j + 1 != dc) {
			System.out.println("i: " + i + " j: " + j);
			System.out.println(m[i][j]);
			restult[index++] = m[i][j];
			// 如果是向写上打印，只考虑上边界和右边界即可
			if (flag) {

				// 上边界
				if (i == 0) {
					if (j + 1 != dc) {
						j = j + 1;
					} else {
						i = i + 1;
					}
					flag = false;
				} else if (j == dc - 1) {
					i = i + 1;
					flag = false;
				} else {
					i = i - 1;
					j = j + 1;
				}

			} else {
				if (j == 0) {
					if (i + 1 != dr) {
						i = i + 1;
					} else {
						j = j + 1;
					}
					flag = true;
				} else if (i == dr - 1) {
					j = j + 1;
					flag = true;
				} else {
					i = i + 1;
					j = j - 1;
				}
			}
		}
		restult[index] = m[dr - 1][dc - 1];
		return restult;
	}

	public static void main(String[] args) {
		int[][] input = new int[3][3];
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				input[i][j] = sum++;
			}
		}
		ZigzagPrinting z = new ZigzagPrinting();
		z.printMatrixZigZag(input);
	}
}
