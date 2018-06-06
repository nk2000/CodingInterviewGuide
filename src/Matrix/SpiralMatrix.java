package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return result;

		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;

		// 边界问题，用while来控制
		while (tR <= dR && tC <= dC) {
			processByEdge(matrix, tR++, tC++, dR--, dC--, result);
		}
		return result;
	}

	// 把这一部分单独写成一个函数，减少重复代码
	public void processByEdge(int[][] matrix, int tR, int tC, int dR, int dC, List<Integer> result) {
		if (tR == dR) {
			// 只有一行
			for (int i = tC; i <= dC; i++) {
				result.add(matrix[tR][i]);
			}
		} else if (tC == dC) {
			// 只有一列
			for (int i = tR; i <= dR; i++) {
				result.add(matrix[i][tR]);
			}
		} else {
			int currentR = tR;
			int currentC = tC;

			while (currentC != dC) {
				result.add(matrix[currentR][currentC++]);
			}
			while (currentR != dR) {
				result.add(matrix[currentR++][currentC]);
			}
			while (currentC != tC) {
				result.add(matrix[currentR][currentC--]);
			}
			while (currentR != tR) {
				result.add(matrix[currentR--][currentC]);
			}
		}
	}

}
