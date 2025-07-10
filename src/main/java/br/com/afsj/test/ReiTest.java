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
        Rei rb = Tabuleiro.reiBranco;
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
    @DisplayName("Tentar mover para uma casa em perigo")
    void reiparaUmaCasaEmPerigo(){
        Rei rb = Tabuleiro.reiBranco;
        IRei irb = Tabuleiro.iReiBranco;

        Rainha rrb = Tabuleiro.rainhaBranca;
        IRainha irrb = Tabuleiro.iRainhaBranca;

        Rainha rrp = Tabuleiro.rainhaPreta;
        IRainha irrp = Tabuleiro.iRainhaPreta;

        rrp.mover(3, 5);
        irrp.mover(3, 5);

        Tabuleiro.avaliarEventoPeca(rrb, irrb);
        Tabuleiro.avaliarEventoTabuleiro(3, 6);

        assertAll("Mover Rei para D2",
                () -> assertEquals(4, rrb.getPosX()),
                () -> assertEquals(7, rrb.getPosY())
        );
    }

    @Test
    @DisplayName("Validação do movimento - Casas permitidas")
    void reiparaUmaCasaPermitida(){
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

}
