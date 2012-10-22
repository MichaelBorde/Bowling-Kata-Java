import java.util.ArrayList;
import java.util.List;

public class Partie {
	public void nouveauLancé(int quilles) {
		lancés.add(quilles);
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
		return lancés.get(i + 1) + lancés.get(i + 2);
	}

	private boolean estStrike(int i) {
		return lancés.get(i) == 10;
	}

	private boolean estSpare(int i) {
		return scoreCarreau(i) == 10;
	}

	private Integer bonusSpare(int i) {
		return lancés.get(i + 2);
	}

	private int scoreCarreau(int indiceCarreau) {
		return lancés.get(indiceCarreau) + lancés.get(indiceCarreau + 1);
	}

	private List<Integer> lancés = new ArrayList<Integer>();
}
