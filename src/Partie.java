import java.util.ArrayList;
import java.util.List;

public class Partie {
	public void nouveauLancer(int quilles) {
		lancers.add(quilles);
	}

	public int score() {
		int résultat = 0;
		int indiceCarreau = 0;
		for (int i = 0; i < 10; i++, indiceCarreau++) {
			if (estStrike(indiceCarreau)) {
				résultat += 10 + bonusStrike(indiceCarreau);
			} else {
				résultat += scoreCarreau(indiceCarreau);
				if (estSpare(indiceCarreau)) {
					résultat += bonusSpare(indiceCarreau);
				}
				indiceCarreau++;
			}
		}
		return résultat;
	}

	private int bonusStrike(int i) {
		return lancers.get(i + 1) + lancers.get(i + 2);
	}

	private boolean estStrike(int i) {
		return lancers.get(i) == 10;
	}

	private boolean estSpare(int i) {
		return scoreCarreau(i) == 10;
	}

	private Integer bonusSpare(int i) {
		return lancers.get(i + 2);
	}

	private int scoreCarreau(int indiceCarreau) {
		return lancers.get(indiceCarreau) + lancers.get(indiceCarreau + 1);
	}

	private List<Integer> lancers = new ArrayList<Integer>();
}
