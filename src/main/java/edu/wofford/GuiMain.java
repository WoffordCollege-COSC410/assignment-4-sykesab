package edu.wofford;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiMain extends JFrame implements ActionListener {
	private JLabel result;
	private JButton location00;
	private JButton location01;
	private JButton location02;
	private JButton location10;
	private JButton location11;
	private JButton location12;
	private JButton location20;
	private JButton location21;
	private JButton location22;

	private TicTacToeModel board;

    public void actionPerformed(ActionEvent event) {

		if (event.getSource() == location00) {
			if (board.setMarkAt(0, 0)) {location00.setText("" + board.getMarkAt(0, 0));}
		} else if (event.getSource() == location01) {
			if (board.setMarkAt(0, 1)) {location01.setText("" + board.getMarkAt(0, 1));}
		} else if (event.getSource() == location02) {
			if (board.setMarkAt(0, 2)) {location02.setText("" + board.getMarkAt(0, 2));}
		} else if (event.getSource() == location10) {
			if (board.setMarkAt(1, 0)) {location10.setText("" + board.getMarkAt(1, 0));}
		} else if (event.getSource() == location11) {
			if (board.setMarkAt(1, 1)) {location11.setText("" + board.getMarkAt(1, 1));}
		} else if (event.getSource() == location12) {
			if (board.setMarkAt(1, 2)) {location12.setText("" + board.getMarkAt(1, 2));}
		} else if (event.getSource() == location20) {
			if (board.setMarkAt(2, 0)) {location20.setText("" + board.getMarkAt(2, 0));}
		} else if (event.getSource() == location21) {
			if (board.setMarkAt(2, 1)) {location21.setText("" + board.getMarkAt(2, 1));}
		} else if (event.getSource() == location22) {
			if (board.setMarkAt(2, 2)) {location22.setText("" + board.getMarkAt(2, 2));}
		}

    	if (board.getResult() == TicTacToeModel.Result.XWIN) {
    		result.setText("X wins");
    	} else if (board.getResult() == TicTacToeModel.Result.OWIN) {
    		result.setText("O wins");
    	} else if (board.getResult() == TicTacToeModel.Result.TIE) {
    		result.setText("Tie");
    	}
    }
    
    public GuiMain() {
        setTitle("Tic Tac Toe");

        board = new TicTacToeModel();

        setLayout(new GridLayout(4, 4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        location00 = new JButton("");
        location01 = new JButton("");
        location02 = new JButton("");
        location10 = new JButton("");
        location11 = new JButton("");
        location12 = new JButton("");
        location20 = new JButton("");
        location21 = new JButton("");
        location22 = new JButton("");

        location00.setName("location00");
        location01.setName("location01");
        location02.setName("location02");
        location10.setName("location10");
        location11.setName("location11");
        location12.setName("location12");
        location20.setName("location20");
        location21.setName("location21");
        location22.setName("location22");

        location00.addActionListener(this);
        location01.addActionListener(this);
        location02.addActionListener(this);
        location10.addActionListener(this);
        location11.addActionListener(this);
        location12.addActionListener(this);
        location20.addActionListener(this);
        location21.addActionListener(this);
        location22.addActionListener(this);

        add(location00);
        add(location01);
        add(location02);
        add(location10);
        add(location11);
        add(location12);
        add(location20);
        add(location21);
        add(location22);

        // This is just to get the result label in the center of the grid because it looks better that way
        add(new JLabel());

        result = new JLabel("", JLabel.CENTER);
        add(result);

        pack();
    }

    
	public static void main(String[] args) {
	    GuiMain window = new GuiMain();
        window.setVisible(true);
	}
}