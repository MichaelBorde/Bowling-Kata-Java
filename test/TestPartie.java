import static org.fest.assertions.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class TestPartie {

	@Before
	public void avant() throws Exception {
		partie = new Partie();
	}

	@Test
	public void leScoreDUnePartieGoutiereEstZéro() {
		nouveauxLancés(20, 0);

		assertThat(partie.score()).isEqualTo(0);
	}

	@Test
	public void leScoreDUnePartieModesteEstAussiModeste() {
		partie.nouveauLancé(1);
		nouveauxLancés(19, 0);

		assertThat(partie.score()).isEqualTo(1);
	}

	@Test
	public void leScorePrendEnCompteUnSpare() {
		nouveauSpare();
		partie.nouveauLancé(1);
		nouveauxLancés(17, 0);

		assertThat(partie.score()).isEqualTo(12);
	}

	@Test
	public void leScorePrendEnCompteUnStrike() {
		partie.nouveauLancé(10);
		partie.nouveauLancé(1);
		partie.nouveauLancé(2);
		nouveauxLancés(16, 0);

		assertThat(partie.score()).isEqualTo(16);
	}

	@Test // facultatif
	public void leScoreDUnePartieDe8Est80() {
		nouveauxLancés(20, 4);

		assertThat(partie.score()).isEqualTo(80);
	}

	@Test // facultatif
	public void leScoreDUnePartieDeSparesEst150() {
		nouveauxLancés(21, 5);

		assertThat(partie.score()).isEqualTo(150);
	}

	@Test // facultatif
	public void leScoreMaximalEst300() {
		nouveauxLancés(12, 10);

		assertThat(partie.score()).isEqualTo(300);
	}

	private void nouveauSpare() {
		partie.nouveauLancé(3);
		partie.nouveauLancé(7);
	}

	private void nouveauxLancés(int nombre, int quilles) {
		for (int i = 0; i < nombre; i++) {
			partie.nouveauLancé(quilles);
		}
	}

	private Partie partie;
}
