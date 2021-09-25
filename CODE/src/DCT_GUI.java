package dct;

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class DCT_GUI{

	public static void main(String[] args) {
		/*
		* @praveenK257
		*
		*/
		Scanner sc = new Scanner(System.in);
		int m=sc.nextInt(),n=sc.nextInt();
		int[][] matrix = new int[m][n];
		
		
		JFrame frame = new JFrame("Discrete Cosine Transform - 18D017_78_93");
		frame.setSize(600,600);
		frame.setLayout(null);
		
		
		JButton SolveButton, ExitButton, ResetButton;
		
		SolveButton = new JButton("SOLVE");
		SolveButton.setBounds(230,500,100,30);
		
		ResetButton = new JButton("RESET");
		ResetButton.setBounds(40,500,100,30);

		ExitButton = new JButton("EXIT");
		ExitButton.setBounds(435,500,100,30);

		frame.add(ResetButton);
		frame.add(SolveButton);
		frame.add(ExitButton);
		
		int posX= 130, posY= 30;
		
		JTextField[][] inputEntry = new JTextField[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				inputEntry[i][j] = new JTextField(String.valueOf(0));
				inputEntry[i][j].setBounds(posX,posY,30,30);
				posX+=35;
				frame.add(inputEntry[i][j]);
			}
			posX=130;
			posY+=40;
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				frame.add(inputEntry[i][j]);
			}
		}
		
		
		frame.setVisible(true);

		SolveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				boolean invalidInput = false;

				for(int i=0;i<m;i++) {
					for(int j=0;j<n;j++) {
						matrix[i][j] = Integer.valueOf(inputEntry[i][j].getText());
					}
				}

				//Creating board object
				DiscreteCosineTransform dct = new DiscreteCosineTransform(matrix);
				
				double[][] result = dct.dctTransform(matrix);
				
				
				for(int i=0;i<m;i++) {
					for(int j=0;j<n;j++) {
						inputEntry[i][j].setText( String.valueOf(result[i][j]) );
						System.out.print(result[i][j]+" ");
					}
					System.out.print('\n');
				}
			}	
	
		});


		ResetButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				for(int i=0;i<m;i++) {
					for(int j=0;j<n;j++) {
						inputEntry[i][j].setText(String.valueOf(0));
					}
				}
			}
		
		});
		

		ExitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		
		});
		
	}

}
