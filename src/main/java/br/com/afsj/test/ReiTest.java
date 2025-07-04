package br.com.afsj.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.afsj.model.Peao;
import br.com.afsj.model.Tabuleiro;
import br.com.afsj.model.TradutorEspanhol;
import br.com.afsj.view.IPeao;
import br.com.afsj.model.Rei;

public class ReiTest {

    @Test
    @DisplayName("")
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

}
