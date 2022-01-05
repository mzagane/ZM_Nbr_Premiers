/*******************************************************************************
 *			File              : ZM_Nbr_Premiers.java (main class)			   *
 *			Programer         : Mohammed ZAGANE								   *
 *			E-mail            : zagmoh2005@yahoo.fr							   *
 *			Web site          : http://zaagane-mohammed.ifrace.com			   *
 *			Source date	      : 03/10/2008									   *
 *			Source version    : v1.03.10.2008								   *
 *			Modification date : 03/10/2008									   *
 ******************************************************************************/
 
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

		
public class ZM_Nbr_Premiers extends JFrame implements ActionListener
{
		
		//Attributs	
			
		/**
		 *les éléments de l'Interface graphique
		 */
		JMenuBar Principal_MB = new JMenuBar();
		JMenu Application_Mn = new JMenu("Application");
		JMenu Help_Mn = new JMenu("Aide");
		JMenuItem Quit_MnItm = new JMenuItem("Quitter");
		JMenuItem About_MnItm = new JMenuItem("A propos");
		JButton Calcul_Button = new JButton("Calculer");
		JButton Find_Prime_Nbrs_Button = new JButton("Trouver les nombres premiers");
		JTextField Nbr_Edit = new JTextField();		
		JTextField Min_Nbr_Edit = new JTextField();		
		JTextField Max_Nbr_Edit = new JTextField();		
		JLabel Nbr_Label = new JLabel("Le nombre : ");
		JLabel Interval_Label = new JLabel("Entrez l'intervalle des nombres :     de : ");
		JLabel Interval_2_Label = new JLabel(" a:");
		JRadioButton Show_Nbr_Prm_Only_RdBtn = new JRadioButton("Afficher les nombres premiers seulement");
		JRadioButton Show_Nbr_Not_Prm_RdBtn = new JRadioButton("Afficher les nombres premiers et non premiers");
		ButtonGroup Show_Nbr_Prm_BtnGrp = new ButtonGroup();
		
		
		// Les méthodes
		
		
		/**
		 *Construction de l'interface graphique
		 */
		void Grafic_Interface()
		{
				setLayout(null);				
				setTitle("JZM Nombres premiers V1.31.10.2008");
				setJMenuBar(Principal_MB);
				
				Principal_MB.add(Application_Mn);
				Principal_MB.add(Help_Mn);
				Application_Mn.add(Quit_MnItm);
				Help_Mn.add(About_MnItm);
				
				// dimensions et positions des objets	------------------------			
				//dimensions de la fenêtre principale
				this.setBounds(387,55,400,333);
				
				//Labels
				Nbr_Label.setBounds(20,20,70,20);				
				Interval_2_Label.setBounds(300,100,20,20);
				Interval_Label.setBounds(20,100,230,20);
				
				//Buttons				
				Calcul_Button.setBounds(210,20,100,20);
				Find_Prime_Nbrs_Button.setBounds(20,190,250,25);
				
				//Edits
				Nbr_Edit.setBounds(100,20,100,20);			
				Min_Nbr_Edit.setBounds(240,100,50,20);				
				Max_Nbr_Edit.setBounds(330,100,50,20);
				
				//RadioButtons
				Show_Nbr_Prm_Only_RdBtn.setBounds(20,130,300,25);				
				Show_Nbr_Not_Prm_RdBtn.setBounds(20,160,300,25);
				//--------------------------------------------------------------
				
				// gestionnaire des évènements ---------------------------------				
				//Buttons
				Calcul_Button.addActionListener(this);
				Find_Prime_Nbrs_Button.addActionListener(this);
				
				//MenuItem
				Quit_MnItm.addActionListener(this);				
				About_MnItm.addActionListener(this);
				//--------------------------------------------------------------
				
				// Ajouter a la fenêtre principale	----------------------------			
				//labels
				add(Nbr_Label);
				add(Interval_Label);
				add(Interval_2_Label);
				
				// Edit				
				add(Nbr_Edit);				
				add(Min_Nbr_Edit);
				add(Max_Nbr_Edit);
				
				//Buttons
				add(Calcul_Button);
				add(Find_Prime_Nbrs_Button);
				
				//RadioButtons
				add(Show_Nbr_Prm_Only_RdBtn);
				add(Show_Nbr_Not_Prm_RdBtn);
				Show_Nbr_Prm_BtnGrp.add(Show_Nbr_Prm_Only_RdBtn);
				Show_Nbr_Prm_BtnGrp.add(Show_Nbr_Not_Prm_RdBtn);
				//--------------------------------------------------------------
				
				// Intialisation
				
				//RadioButtons
				Show_Nbr_Prm_Only_RdBtn.setSelected(true);
				Show_Nbr_Not_Prm_RdBtn.setSelected(false);
				
				setResizable(false);
				
				
				show();// affichage de la fenêtre
		}
				
		//Constructeur
		public ZM_Nbr_Premiers()
		{
				Grafic_Interface();
		}
		
		
		//Gestionnaire des evènements
		public void actionPerformed(ActionEvent Evnt)
		{
				
				Object Source_Object = Evnt.getSource();
				String MnItm_Caption = new String(); // Caption du menuitem actif												
								
				//les évènements de cliques sur les boutons
				
				// Calculer				
				if(Source_Object==Calcul_Button)
				{
						if(Nbr_Edit.getText().equals(""))
						{
								JOptionPane.showMessageDialog(this,"Veuillez entrer un nombre entier.",
								"JZM Nombres Premiers V1.31.10.2008",JOptionPane.WARNING_MESSAGE);		
						}
						else
						{						
								Integer Nmbr = new Integer(Nbr_Edit.getText());
						
								Numbers My_Number = new Numbers(Nmbr.intValue());
						
								if(My_Number.isPrime_Number())
								{
										JOptionPane.showMessageDialog(this,"le nombre : "+Nbr_Edit.getText()+" est premier.",
										"JZM Nombres Premiers V1.31.10.2008",JOptionPane.INFORMATION_MESSAGE);
								}
								else
								{
										JOptionPane.showMessageDialog(this,"le nombre : " + Nbr_Edit.getText() +" n'est pas premier.",
										"JZM Nombres Premiers V1.31.10.2008",JOptionPane.ERROR_MESSAGE);
								}
						}
				}
				else if	(Source_Object==Find_Prime_Nbrs_Button)
				{
						if(Min_Nbr_Edit.getText().equals("") || Max_Nbr_Edit.getText().equals(""))
						{
								JOptionPane.showMessageDialog(this,"Veuillez entrer les bornes de l'intervalle.",
								"JZM Nombres Premiers V1.31.10.2008",JOptionPane.WARNING_MESSAGE);				
						}
						else
						{
								Integer Min_Nbr,Max_Nbr;
								Min_Nbr = new Integer(Min_Nbr_Edit.getText());
								Max_Nbr = new Integer(Max_Nbr_Edit.getText());
						
								for(int j=Min_Nbr.intValue();j<=Max_Nbr.intValue();j++)
								{
										Numbers My_Number = new Numbers(j);
								
										if(My_Number.isPrime_Number())
										{
												JOptionPane.showMessageDialog(this,"le nombre : "+j+" est premier.",
												"JZM Nombres Premiers V1.31.10.2008",JOptionPane.INFORMATION_MESSAGE);
										}		
										else 
										{
												if(Show_Nbr_Not_Prm_RdBtn.isSelected())
												{
														JOptionPane.showMessageDialog(this,"le nombre : "+j+" n'est pas premier.",
														"JZM Nombres Premiers V1.31.10.2008",JOptionPane.ERROR_MESSAGE);
												}
										
										}
								}
						}
				}			
				//les évènements de cliques sur les éléments du menu principale				
				else if(((JMenuItem)Source_Object).getText().equals("Quitter")) 				
				//if(MnItm_Caption=="Quitter")
				{
						dispose();
				}
				else if(((JMenuItem)Source_Object).getText().equals("A propos"))
				//else if(MnItm_Caption=="A propos")
				{
						JOptionPane.showMessageDialog(this,"JZM Nombres Premiers V1.31.10.2008\nProgrammé par : Mohammed ZAGANE\nE-mail : zagmoh2005@yahoo.fr\nSite Web : http://zaagane-mohammed.ifrance.com",
						"JZM Nombres Premiers V1.31.10.2008",JOptionPane.INFORMATION_MESSAGE);
				}	
								
		}
	
		//main		
		public static void main(String args[])
		{
				new ZM_Nbr_Premiers();
		}	
		
		
}

