package br.com.afsj.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.afsj.model.Peao;
import br.com.afsj.model.Tabuleiro;
import br.com.afsj.model.TradutorEspanhol;
import br.com.afsj.view.IPeao;

public class PeaoTest {

	@Test
	@DisplayName("Movimento peao preto e branco para frente")
	void movimentoPeaoPretoEBrancoParaFrente() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.iniciar(new TradutorEspanhol());

		//Pe�as no tabuleiro
		Peao pb = Tabuleiro.peaoBranco1;
		IPeao ipb = Tabuleiro.iPeaoBranco1;
		
		Peao pp = Tabuleiro.peaoPreto1;
		IPeao ipp = Tabuleiro.iPeaoPreto1;

		Tabuleiro.avaliarEventoPeca(pb, ipb);
		Tabuleiro.avaliarEventoTabuleiro(4, 5);
		assertAll("Mover Pe�o branco uma casa",
				() -> assertEquals(4, pb.getPosX()),
				() -> assertEquals(5, pb.getPosY())
				);
		
		
		Tabuleiro.avaliarEventoPeca(pp, ipp);
		Tabuleiro.avaliarEventoTabuleiro(3, 2);
		assertAll("Mover Pe�o preto uma casa",
				() -> assertEquals(3, pp.getPosX()),
				() -> assertEquals(2, pp.getPosY())
				);
		
	}

	@Test
	@DisplayName("Captura Peao Preto")
	void capturaPeaoPreto() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.iniciar(new TradutorEspanhol());

		//Pe�as no tabuleiro
		Peao pb = Tabuleiro.peaoBranco1;
		IPeao ipb = Tabuleiro.iPeaoBranco1;
		
		Peao pp = Tabuleiro.peaoPreto1;
		IPeao ipp = Tabuleiro.iPeaoPreto1;

		Tabuleiro.avaliarEventoPeca(pb, ipb);
		Tabuleiro.avaliarEventoTabuleiro(4, 4);
		Tabuleiro.avaliarEventoPeca(pp, ipp);
		Tabuleiro.avaliarEventoTabuleiro(3, 3);
		Tabuleiro.avaliarEventoPeca(pb, ipb);
		Tabuleiro.avaliarEventoPeca(pp, ipp);
		
		assertAll("Capturar Peao Preto",
				() -> assertEquals(3, pb.getPosX()),
				() -> assertEquals(3, pb.getPosY())
				);		
	}
	
	@Test
	@DisplayName("Movimento Inválido Peão Branco")
	void movimentoInvalidoPeaoBranco() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.iniciar(new TradutorEspanhol());

		//Pe�as no tabuleiro
		Peao pb = Tabuleiro.peaoBranco1;
		IPeao ipb = Tabuleiro.iPeaoBranco1;
				
		Tabuleiro.avaliarEventoPeca(pb, ipb);
		Tabuleiro.avaliarEventoTabuleiro(0, 6);
		assertAll("Mover Pe�o branco para (0, 6)",
				() -> assertEquals(4, pb.getPosX()),
				() -> assertEquals(6, pb.getPosY())
				);
	}
	
	@Test
	@DisplayName("Captura Inválida do Peão Preto pelo Peão Branco")
	void capturaInvalidaPeaoBranco() {
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.iniciar(new TradutorEspanhol());

		//Pe�as no tabuleiro
		Peao pb = Tabuleiro.peaoBranco1;
		IPeao ipb = Tabuleiro.iPeaoBranco1;
		
		Peao pp = Tabuleiro.peaoPreto1;
		IPeao ipp = Tabuleiro.iPeaoPreto1;
		
		Tabuleiro.avaliarEventoPeca(pb, ipb);
		Tabuleiro.avaliarEventoPeca(pp, ipp);

		assertAll("Nao capturar peão preto",
				() -> assertEquals(4, pb.getPosX()),
				() -> assertEquals(6, pb.getPosY())
				);
		
	}

}
