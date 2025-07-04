package br.com.afsj.model;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import br.com.afsj.control.Xadrez;
import br.com.afsj.view.IBispo;
import br.com.afsj.view.ICavalo;
import br.com.afsj.view.IPeao;
import br.com.afsj.view.IPeca;
import br.com.afsj.view.IRainha;
import br.com.afsj.view.IRei;
import br.com.afsj.view.ITabuleiro;
import br.com.afsj.view.ITorre;

public class Tabuleiro {

	protected static JFrame TELA;
	
	public static ArrayPecas listaBrancas;
	public static ArrayPecas listaPretas;

	protected static int corJogadorAtual;
	protected static Peca pecaMarcada;
	protected static IPeca iPecaMarcada;
	
	protected static ITabuleiro iTabuleiro;

/*
	protected static Torre torreBranca = new Torre();
	protected static ITorre iTorreBranca = new ITorre(torreBranca);
	
	protected static Torre torrePreta = new Torre();
	protected static ITorre iTorrePreta = new ITorre(torrePreta);

	protected static Rei reiBranco = new Rei();
	protected static IRei iReiBranco = new IRei(reiBranco);
	
	protected static Rei reiPreto = new Rei();
	protected static IRei iReiPreto = new IRei(reiPreto);

	protected static Cavalo cavaloPreto1 = new Cavalo();
	protected static ICavalo iCavaloPreto1 = new ICavalo(cavaloPreto1);

	protected static Cavalo cavaloBranco1 = new Cavalo();
	protected static ICavalo iCavaloBranco1 = new ICavalo(cavaloBranco1);
	
	
	protected static Bispo bispoBranco = new Bispo();
	protected static IBispo iBispoBranco = new IBispo(bispoBranco);
	
	protected static Bispo bispoPreto = new Bispo();
	protected static IBispo iBispoPreto = new IBispo(bispoPreto);

	protected static Rainha rainhaBranca = new Rainha();
	protected static IRainha iRainhaBranca = new IRainha(rainhaBranca);
	
	protected static Rainha rainhaPreta = new Rainha();
	protected static IRainha iRainhaPreta = new IRainha(rainhaPreta);
*/	
	public static Peao peaoBranco1;
	public static IPeao iPeaoBranco1;

	public static Peao peaoPreto1;
	public static IPeao iPeaoPreto1;

	public static Cavalo cavaloPreto1;
	public static ICavalo iCavaloPreto1;

	public static Cavalo cavaloBranco1;
	public static ICavalo iCavaloBranco1;

	public void iniciar(Tradutor t) {

		
		listaBrancas = new ArrayPecas();
		listaPretas = new ArrayPecas();

		corJogadorAtual = Xadrez.corBRANCA;
		pecaMarcada = null;
		iPecaMarcada = null;
		ITabuleiro iTabuleiro = new ITabuleiro();

		TELA = new JFrame(t.traduzir("Xadrez"));
/*
		//Torres
		
		torreBranca.setCor(Xadrez.corBRANCA);
		torreBranca.mover(0, 7);
		iTorreBranca.setIconeBranco(new ImageIcon("imagens/Torre-Brancas-Branco.png"));
		iTorreBranca.setIconeMarrom(new ImageIcon("imagens/Torre-Brancas-Marrom.png"));
		iTorreBranca.mover(0, 7);
		TELA.getContentPane().add(iTorreBranca.getImagem());
		listaBrancas.add(torreBranca);

		torrePreta.setCor(Xadrez.corPRETA);
		torrePreta.mover(0, 0);
		iTorrePreta.setIconeBranco(new ImageIcon("imagens/Torre-Pretas-Branco.png"));
		iTorrePreta.setIconeMarrom(new ImageIcon("imagens/Torre-Pretas-Marrom.png"));
		iTorrePreta.mover(0, 0);
		TELA.getContentPane().add(iTorrePreta.getImagem());
		listaPretas.add(torrePreta);



		
		// Reis

		reiBranco.setCor(Xadrez.corBRANCA);
		reiBranco.mover(4, 7);
		iReiBranco.setIconeBranco(new ImageIcon("imagens/Rei-Brancas-Branco.png"));
		iReiBranco.setIconeMarrom(new ImageIcon("imagens/Rei-Brancas-Marrom.png"));
		iReiBranco.mover(4, 7);
		TELA.getContentPane().add(iReiBranco.getImagem());
		listaBrancas.add(reiBranco);

		reiPreto.setCor(Xadrez.corPRETA);
		reiPreto.mover(4, 0);
		iReiPreto.setIconeBranco(new ImageIcon("imagens/Rei-Pretas-Branco.png"));
		iReiPreto.setIconeMarrom(new ImageIcon("imagens/Rei-Pretas-Marrom.png"));
		iReiPreto.mover(4, 0);
		TELA.getContentPane().add(iReiPreto.getImagem());
		listaPretas.add(reiPreto);


		// Bispos

		bispoBranco.setCor(Xadrez.corBRANCA);
		bispoBranco.mover(2, 7);
		iBispoBranco.setIconeBranco(new ImageIcon("imagens/Bispo-Brancas-Branco.png"));
		iBispoBranco.setIconeMarrom(new ImageIcon("imagens/Bispo-Brancas-Marrom.png"));
		iBispoBranco.mover(2, 7);
		TELA.getContentPane().add(iBispoBranco.getImagem());
		listaBrancas.add(bispoBranco);

		bispoPreto.setCor(Xadrez.corPRETA);
		bispoPreto.mover(2, 0);
		iBispoPreto.setIconeBranco(new ImageIcon("imagens/Bispo-Pretas-Branco.png"));
		iBispoPreto.setIconeMarrom(new ImageIcon("imagens/Bispo-Pretas-Marrom.png"));
		iBispoPreto.mover(2, 0);
		TELA.getContentPane().add(iBispoPreto.getImagem());
		listaPretas.add(bispoPreto);
		
 		// Rainhas

		rainhaBranca.setCor(Xadrez.corBRANCA);
		rainhaBranca.mover(3, 4);
		iRainhaBranca.setIconeBranco(new ImageIcon("imagens/Rainha-Brancas-Branco.png"));
		iRainhaBranca.setIconeMarrom(new ImageIcon("imagens/Rainha-Brancas-Marrom.png"));
		iRainhaBranca.mover(3, 4);
		TELA.getContentPane().add(iRainhaBranca.getImagem());
		listaBrancas.add(rainhaBranca);

		rainhaPreta.setCor(Xadrez.corPRETA);
		rainhaPreta.mover(6, 3);
		iRainhaPreta.setIconeBranco(new ImageIcon("imagens/Rainha-Pretas-Branco.png"));
		iRainhaPreta.setIconeMarrom(new ImageIcon("imagens/Rainha-Pretas-Marrom.png"));
		iRainhaPreta.mover(6, 3);
		TELA.getContentPane().add(iRainhaPreta.getImagem());
		listaPretas.add(rainhaPreta);

*/		
		// Pe�es

		peaoBranco1 = new Peao();
		iPeaoBranco1 = new IPeao(peaoBranco1);

		peaoBranco1.setCor(Xadrez.corBRANCA);
		peaoBranco1.mover(4, 6);
		iPeaoBranco1.setIconeBranco(new ImageIcon("imagens/Peao-Brancas-Branco.png"));
		iPeaoBranco1.setIconeMarrom(new ImageIcon("imagens/Peao-Brancas-Marrom.png"));
		iPeaoBranco1.mover(4, 6);
		TELA.getContentPane().add(iPeaoBranco1.getImagem());
		listaBrancas.add(peaoBranco1);

		peaoPreto1 = new Peao();
		iPeaoPreto1 = new IPeao(peaoPreto1);
		peaoPreto1.setCor(Xadrez.corPRETA);
		peaoPreto1.mover(3, 1);
		iPeaoPreto1.setIconeBranco(new ImageIcon("imagens/Peao-Pretas-Branco.png"));
		iPeaoPreto1.setIconeMarrom(new ImageIcon("imagens/Peao-Pretas-Marrom.png"));
		iPeaoPreto1.mover(3, 1);
		TELA.getContentPane().add(iPeaoPreto1.getImagem());
		listaPretas.add(peaoPreto1);

		// Cavalos
		cavaloPreto1 = new Cavalo();
		iCavaloPreto1 = new ICavalo(cavaloPreto1);

		cavaloBranco1 = new Cavalo();
		iCavaloBranco1 = new ICavalo(cavaloBranco1);
		
		cavaloBranco1.setCor(Xadrez.corBRANCA);
		cavaloBranco1.mover(2, 5);
		iCavaloBranco1.setIconeBranco(new ImageIcon("imagens/Cavalo-Brancas-Branco.png"));
		iCavaloBranco1.setIconeMarrom(new ImageIcon("imagens/Cavalo-Brancas-Marrom.png"));
		iCavaloBranco1.mover(2, 5);
		TELA.getContentPane().add(iCavaloBranco1.getImagem());
		listaBrancas.add(cavaloBranco1);

		cavaloPreto1.setCor(Xadrez.corPRETA);
		cavaloPreto1.mover(4, 1);
		iCavaloPreto1.setIconeBranco(new ImageIcon("imagens/Cavalo-Pretas-Branco.png"));
		iCavaloPreto1.setIconeMarrom(new ImageIcon("imagens/Cavalo-Pretas-Marrom.png"));
		iCavaloPreto1.mover(4, 1);
		TELA.getContentPane().add(iCavaloPreto1.getImagem());
		listaPretas.add(cavaloPreto1);

		
		TELA.getContentPane().add(iTabuleiro.getImagem());
		TELA.setSize(400, 400);
		TELA.setVisible(true);
		TELA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void avaliarEventoPeca(Peca p, IPeca ip) {
		if (p.getCor() == corJogadorAtual) 
			marcarPeca(p, ip);
		else if (pecaMarcada != null)
			capturarPeca(p, ip);		
	}
	
	public static void avaliarEventoTabuleiro(int x, int y) {
		if ( (pecaMarcada != null) && (x >= 0) && (x <= 7) && (y >=0) && (y <= 7) ) {
			moverPecaMarcada(x, y);
		}
	}

	public static void marcarPeca(Peca p, IPeca ip) {
		if (iPecaMarcada != null)
			iPecaMarcada.desmarcar();
		pecaMarcada = p;
		iPecaMarcada = ip;
		iPecaMarcada.marcar();
	}

	public static void capturarPeca(Peca p, IPeca ip) {
		if (pecaMarcada.capturar(p.getPosX(), p.getPosY())) {
			ip.remover();
			TELA.getContentPane().remove(ip.getImagem());
			iPecaMarcada.desmarcar();
			iPecaMarcada.mover(p.getPosX(), p.getPosY());
			p.remover();
			pecaMarcada = null;
			iPecaMarcada = null;
			if (corJogadorAtual == Xadrez.corBRANCA)
				corJogadorAtual = Xadrez.corPRETA;
			else
				corJogadorAtual = Xadrez.corBRANCA;			
		}
	}
	
	public static void moverPecaMarcada(int x, int y) {
		if (pecaMarcada.mover(x, y)) {
			iPecaMarcada.desmarcar();
			iPecaMarcada.mover(x, y);
			pecaMarcada = null;
			iPecaMarcada = null;
			if (corJogadorAtual == Xadrez.corBRANCA)
				corJogadorAtual = Xadrez.corPRETA;
			else
				corJogadorAtual = Xadrez.corBRANCA;
		}
	}
}
