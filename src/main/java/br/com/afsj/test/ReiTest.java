package br.com.afsj.test;

import br.com.afsj.model.*;
import br.com.afsj.view.IPeao;
import br.com.afsj.view.IRainha;
import br.com.afsj.view.IRei;
import br.com.afsj.view.ITorre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
*
* CONFIGURAÇÃO DO TABULEIRO:
*
* 1 REI BRANCO (4, 7) E 1 REI PRETO (4, 0)
* 1 RAINHA BRANCA (3, 7) E 1 RAINHA PRETA (3, 0)
* 2 TORRES BRANCAS (0, 0) E (7, 0)
* 1 PEÃO PRETO (7, 0)
*
* */

class ReiTest {
    @BeforeEach
    public void iniciarTabuleiro() {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.iniciar(new TradutorEspanhol());
    }

    @Test
    @DisplayName("Inicialização da peça")
    public void inicializacaoDaPeça() {
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Rei rp = Tabuleiro.reiPreto;
        IRei irp = Tabuleiro.iReiPreto;

        assertAll("Rei branco aparaceu na E1",
                () -> assertEquals(4, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY())
        );

        assertAll("Rei preto aparaceu na E8",
                () -> assertEquals(4, rp.getPosX()),
                () -> assertEquals(0, rp.getPosY())
        );
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
        assertAll("Mover Rei Branco para E2",
                () -> assertEquals(4, rb.getPosX()),
                () -> assertEquals(6, rb.getPosY())
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
    @DisplayName("Tentar mover o Rei para uma casa ocupada por peça aliada")
    public void validacaoDoMovimento() throws InterruptedException {
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Rainha rrb = Tabuleiro.rainhaBranca;
        IRainha irrb = Tabuleiro.iRainhaBranca;

        rrb.mover(3, 7);
        irrb.mover(3, 7);

        Tabuleiro.avaliarEventoPeca(rb, irb); // Selecionar Rei branco
        Tabuleiro.avaliarEventoPeca(rrb, irrb); // Clicar na casa que a peça branca ocupa

        assertAll("Rei branco tentou mover para D1",
                () -> assertEquals(4, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Tentar mover o Rei para uma casa em perigo")
    void reiparaUmaCasaEmPerigo() throws InterruptedException {
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Rainha rrp = Tabuleiro.rainhaPreta;
        IRainha irrp = Tabuleiro.iRainhaPreta;

        rrp.mover(3, 5);
        irrp.mover(3, 5);

        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(3, 6);

        assertAll("Mover Rei para D2",
                () -> assertEquals(4, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Validação do movimento - Casas permitidas")
    void reiparaUmaCasaPermitida() throws InterruptedException {
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        rb.mover(4, 3);
        irb.mover(4, 3);

        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(5, 3);

        assertAll("Mover Rei para f5",
                () -> assertEquals(5, rb.getPosX()),
                () -> assertEquals(3, rb.getPosY())
        );
    }

    @Test
    @DisplayName("Validação do movimento - Casas não permitidas")
    void reiparaUmaCasaNaoPermitida(){
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        rb.mover(4, 3);
        irb.mover(4, 3);

        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(6, 3);

        assertAll("Mover Rei para g5",
                () -> assertEquals(4, rb.getPosX()),
                () -> assertEquals(3, rb.getPosY())
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
        Tabuleiro.avaliarEventoPeca(pp, ipp);
        assertAll("Rei capturando peça: ",
                () -> assertEquals(-1, pp.getPosX()),
                () -> assertEquals(-1, pp.getPosY()),
                () -> assertEquals(4, WhiteKing.getPosX()),
                () -> assertEquals(5, WhiteKing.getPosY())
        );

    }

    @Test
    @DisplayName("Avisar o jogador que seu movimento deixará seu Rei em Xeque")
    void naoPermitirXeque() throws InterruptedException{
        //Ter o rei na posicao E1
        Rei whiteKing = Tabuleiro.reiBranco;
        IRei IwhiteKing = Tabuleiro.iReiBranco;

        whiteKing.remover();
        whiteKing.mover(4,7);
        IwhiteKing.mover(4,7);

        //Ter uma rainha branca na posicao D8
        Rainha rainhaPreta = Tabuleiro.rainhaPreta;
        IRainha IrainhaPreta = Tabuleiro.iRainhaPreta;

        rainhaPreta.remover();
        rainhaPreta.mover(3,0);
        IrainhaPreta.mover(3,0);

        //Selecionar Rei Branco
        //Selecionar casa D2

        Tabuleiro.avaliarEventoPeca(whiteKing, IwhiteKing);
        Tabuleiro.avaliarEventoTabuleiro(3,6);

        assertAll("Verificar movimento ilegal de Xeque",
                () -> assertNotEquals(3, whiteKing.getPosX()),
                () -> assertNotEquals(6, whiteKing.getPosY())
        );

    }

    @Test
    @DisplayName("Tentar mover a Rainha pondo o Rei em Xeque")
    public void tentarMoverRainhaPondoReiEmXeque() throws InterruptedException {
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

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
    @DisplayName("Tentar mover a Rainha enquanto o Rei está em Xeque")
    void rainhaSeMoverDeixandoOReiEmCheque() throws InterruptedException {
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Rainha rrb = Tabuleiro.rainhaBranca;
        IRainha irrb = Tabuleiro.iRainhaBranca;

        Rainha rrp = Tabuleiro.rainhaPreta;
        IRainha irrp = Tabuleiro.iRainhaPreta;

        rrp.remover();
        rrp.mover(4, 1);
        irrp.mover(4, 1);

        rrb.remover();
        rrb.mover(3, 7);
        irrb.mover(3, 7);

        Tabuleiro.avaliarEventoPeca(rrb, irrb);
        Tabuleiro.avaliarEventoTabuleiro(3, 6);

        assertAll("Mover Rainha para 6, 2",
                () -> assertEquals(7, rrb.getPosX()),
                () -> assertEquals(3, rrb.getPosY())
        );
    }

    @Test
    @DisplayName("Realizar o roque maior")
    void roqueMaior(){
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Torre tb = Tabuleiro.torreBranca1;
        ITorre itb = Tabuleiro.iTorreBranca1;

        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(2, 7);

        assertAll("Mover Rei branco para 7, 2.",
                () -> assertEquals(2, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY()),
                () -> assertEquals(3, tb.getPosX()),
                () -> assertEquals(7, tb.getPosY())
        );
    }

    @Test
    @DisplayName("Realizar o roque menor")
    void roqueMenor(){
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Torre tb = Tabuleiro.torreBranca2;
        ITorre itb = Tabuleiro.iTorreBranca2;

        Tabuleiro.avaliarEventoPeca(rb, irb);
        Tabuleiro.avaliarEventoTabuleiro(6, 7);

        assertAll("Mover Rei branco para 7, 6.",
                () -> assertEquals(6, rb.getPosX()),
                () -> assertEquals(7, rb.getPosY()),
                () -> assertEquals(5, tb.getPosX()),
                () -> assertEquals(7, tb.getPosY())
        );
    }
}
