package br.com.afsj.test;

import br.com.afsj.model.*;
import br.com.afsj.view.IRainha;
import br.com.afsj.view.IRei;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.afsj.view.IPeao;

import javax.swing.table.TableCellEditor;

import static org.junit.jupiter.api.Assertions.*;

public class ReiTest {
    @BeforeEach
    public void iniciarTabuleiro() {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.iniciar(new TradutorEspanhol());
    }

    @Test
    @DisplayName("Selecionar o Rei com sucesso")
    public void selecionarReiComSucesso() {
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Rei rp = Tabuleiro.reiPreto;
        IRei irp = Tabuleiro.iReiPreto;

        Tabuleiro.avaliarEventoPeca(rb, irb); // Selecionar Rei branco

        Tabuleiro.avaliarEventoTabuleiro(4, 6);
        assertAll("Mover Rei Branco para (4, 6)",
                () -> assertEquals(4, rb.getPosX()),
                () -> assertEquals(6, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Inicialização da peça")
    public void inicializacaoDaPeça() {
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Rei rp = Tabuleiro.reiPreto;
        IRei irp = Tabuleiro.iReiPreto;

        assertAll("Rei branco aparaceu na E1",
                () -> assertEquals(5, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY())
        );

        assertAll("Rei preto aparaceu na E8",
                () -> assertEquals(5, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Movimento de uma peça")
    public void movimentoDePeca() {
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Rei rp = Tabuleiro.reiPreto;
        IRei irp = Tabuleiro.iReiPreto;

        Tabuleiro.avaliarEventoPeca(rb, irb); // Selecionar Rei branco

        Tabuleiro.avaliarEventoTabuleiro(4, 6);
        assertAll("Mover Rei Branco para (4, 6)",
                () -> assertEquals(4, rb.getPosX()),
                () -> assertEquals(6, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Validação do Movimento")
    public void validacaoDoMovimento() throws InterruptedException {
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Peao pb = Tabuleiro.peaoBranco1;
        IPeao ipb = Tabuleiro.iPeaoBranco1;

        pb.mover(3, 7);
        ipb.mover(3, 7);

        Thread.sleep(1000);

        Rei rp = Tabuleiro.reiPreto;
        IRei irp = Tabuleiro.iReiPreto;

        Tabuleiro.avaliarEventoPeca(rb, irb); // Selecionar Rei branco

        Tabuleiro.avaliarEventoTabuleiro(3, 7);
        assertAll("Rei branco tentou mover para D1",
                () -> assertEquals(4, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Tentar mover a Rainha pondo o Rei em Xeque")
    public void tentarMoverRainhaPondoReiEmXeque() throws InterruptedException {
        Rei rb =  Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Thread.sleep(1000);

        Rei rp = Tabuleiro.reiPreto;
        IRei irp = Tabuleiro.iReiPreto;

        Rainha rnb = Tabuleiro.rainhaBranca;
        IRainha irnb = Tabuleiro.iRainhaBranca;

        rnb.mover(4, 6);
        irnb.mover(4, 6);

        Rainha rnp = Tabuleiro.rainhaPreta;
        IRainha irnp = Tabuleiro.iRainhaPreta;

        rnp.mover(4, 7);
        irnp.mover(4, 7);

        Tabuleiro.avaliarEventoPeca(rb, irb); // Selecionar Rei branco

        Tabuleiro.avaliarEventoTabuleiro(3, 7);
        assertAll("Rei branco tentou mover para D1",
                () -> assertEquals(4, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY())
        );
    }

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

    @Test
    @DisplayName("Rei capturar uma peça do adversário")
    void reiCapturarPecaAdversario(){


        Rei WhiteKing = Tabuleiro.reiBranco;
        IRei IWhiteKing = Tabuleiro.iReiBranco;

        Peao pp = Tabuleiro.peaoPreto1;
        IPeao ipp = Tabuleiro.iPeaoPreto1;

        WhiteKing.remover();
        WhiteKing.mover(4,6);
        IWhiteKing.mover(4,6);
        pp.remover();
        pp.mover(4,5);
        ipp.mover(4,5);

        Tabuleiro.avaliarEventoPeca(WhiteKing, IWhiteKing);
        //Tabuleiro.avaliarEventoTabuleiro(4,5);
        Tabuleiro.avaliarEventoPeca(pp, ipp);
        assertAll("Rei capturando peça: ",
                () -> assertEquals(-1, pp.getPosX()),
                () -> assertEquals(-1, pp.getPosY()),
                () -> assertEquals(4, WhiteKing.getPosX()),
                () -> assertEquals(5, WhiteKing.getPosY())
        );

    }

    @Test
    @DisplayName("RF66 - Não permitir o Xeque")
    void naoPermitirXeque(){
        //Ter o rei na posicao E1
        Rei whiteKing = Tabuleiro.reiBranco;
        IRei IwhiteKing = Tabuleiro.iReiBranco;
        whiteKing.remover();
        whiteKing.mover(4,7);
        IwhiteKing.mover(4,7);

        //Ter uma rainha branca na posicao D8
        Rainha rainha = Tabuleiro.rainhaPreta;
        IRainha Irainha = Tabuleiro.iRainhaPreta;
        rainha.remover();
        rainha.mover(3,0);
        Irainha.mover(3,0);

        //Selecionar Rei Branco
        //Selecionar casa D2

        Tabuleiro.avaliarEventoPeca(whiteKing, IwhiteKing);
        Tabuleiro.avaliarEventoTabuleiro(6,3);

        System.out.println('x rei: ');

        assertAll("Verificar movimento ilegal de Xeque",
                () -> assertNotEquals(6, whiteKing.getPosX()),
                () -> assertNotEquals(3, whiteKing.getPosY())
                );

    }

    void naoPermitirXequeRainha (){

    }

}
