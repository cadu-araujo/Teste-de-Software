package br.com.afsj.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.afsj.model.Cavalo;
import br.com.afsj.model.Tabuleiro;
import br.com.afsj.model.TradutorEspanhol;
import br.com.afsj.view.ICavalo;

public class CavaloTest {
	
	@Test
	@DisplayName("Movimento Correto do Cavalo")
	void movimentoCorretoCavalo() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.iniciar(new TradutorEspanhol());
		
		Cavalo cb = Tabuleiro.cavaloBranco1;
		ICavalo icb = Tabuleiro.iCavaloBranco1;

		Cavalo cp = Tabuleiro.cavaloPreto1;
		ICavalo icp = Tabuleiro.iCavaloPreto1;
		
		Tabuleiro.avaliarEventoPeca(cb, icb);
		Tabuleiro.avaliarEventoTabuleiro(1, 3);
		assertAll("Mover Cavalo Branco para (1, 3)",
				() -> assertEquals(1, cb.getPosX()),
				() -> assertEquals(3, cb.getPosY())
				);		

		Tabuleiro.avaliarEventoPeca(cp, icp);
		Tabuleiro.avaliarEventoTabuleiro(3, 3);
		assertAll("Mover Cavalo Preto para (3, 3)",
				() -> assertEquals(3, cp.getPosX()),
				() -> assertEquals(3, cp.getPosY())
				);		

	}
	
	@Test
	@DisplayName("Movimento Inválido do Cavalo")
	void movimentoInvalidoCavalo() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.iniciar(new TradutorEspanhol());
	}
	
	@Test
	@DisplayName("Cavalo Captura Outra Peça")
	void cavaloCapturaOutraPeca() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.iniciar(new TradutorEspanhol());

	}
	
	@Test
	@DisplayName("Cavalo Pula Sobre Outra Peça")
	void cavaloPulaSobreOutraPeca() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.iniciar(new TradutorEspanhol());

	}
}
