package Matrix;

public class TransposeMatrix {
	/**
	 * 参照转圈打印矩阵的思想，分圈处理
	 * 
	 * @param m
	 */
	public void rotate(int[][] m) {
		if (m == null || m.length == 0)
			return;
		int tR = 0;
		int tC = 0;
		int dC = m[0].length - 1;
		int dR = m.length - 1;

		while (tR <= dR && tC <= dC) {
			rotateEdge(m, tR++, tC++, dR--, dC--);
			// System.out.println("@@@@");
		}
	}

	public void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		if (tR == dR)
			return;
		// 矩阵环上每个点，移动的步长为dC-tC

		// System.out.println("dr: " + dR + " dC: " + dC);
		for (int i = tC; i < dC; i++) {
			int step = dC - tC;
			int currentR = tR;
			int currentC = i;

			int tmp = m[currentR][currentC];
			int changeNum = 4;
			// System.out.println("!");
			while (changeNum != 0 && currentC != dC) {
				if (step == 0) {
					// System.out.println("1currentR:" + currentR + " currentC: " + currentC);
					int temperal = m[currentR][currentC];
					m[currentR][currentC] = tmp;
					tmp = temperal;
					step = dC - tC;
					changeNum--;
				}
				step--;
				currentC++;
			}
			while (changeNum != 0 && currentR != dR) {
				if (step == 0) {
					// System.out.println("2currentR:" + currentR + " currentC: " + currentC);
					int temperal = m[currentR][currentC];
					m[currentR][currentC] = tmp;
					tmp = temperal;
					step = dC - tC;
					changeNum--;
				}
				step--;
				currentR++;
			}
			while (changeNum != 0 && currentC != tC) {
				if (step == 0) {
					// System.out.println("3currentR:" + currentR + " currentC: " + currentC);
					int temperal = m[currentR][currentC];
					m[currentR][currentC] = tmp;
					tmp = temperal;
					step = dC - tC;
					changeNum--;
				}
				step--;
				currentC--;
			}
			while (changeNum != 0 && currentR != tC) {
				if (step == 0) {
					// System.out.println("4currentR:" + currentR + " currentC: " + currentC);
					int temperal = m[currentR][currentC];
					m[currentR][currentC] = tmp;
					tmp = temperal;
					step = dC - tC;
					changeNum--;
				}
				step--;
				currentR--;
			}
			while (changeNum != 0 && currentC != dC) {
				if (step == 0) {
					// System.out.println("5currentR:" + currentR + " currentC: " + currentC);
					int temperal = m[currentR][currentC];
					m[currentR][currentC] = tmp;
					tmp = temperal;
					step = dC - tC;
					changeNum--;
				}
				step--;
				currentC++;
			}
		}
	}

	public static void main(String[] args) {
		int[][] input = new int[3][3];
		int sum = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				input[i][j] = sum++;
			}
		}
		TransposeMatrix z = new TransposeMatrix();
		z.rotate(input);
		for (int i = 0; i < 3; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++) {
				System.out.print(input[i][j]);
			}
		}
	}
}
