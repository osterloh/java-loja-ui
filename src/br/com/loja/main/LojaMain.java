package br.com.loja.main;

import java.awt.EventQueue;
import javax.swing.JFrame;

import br.com.loja.view.LojaView;

public class LojaMain extends JFrame {
	public LojaMain() {
		setAutoRequestFocus(false);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// faz a chamada da tela VIEW
					LojaView frame = new LojaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
