/*******************************************************************************
 *			File              : Numbers.java								   *
 *			Programer         : Mohammed ZAGANE								   *
 *			E-mail            : zagmoh2005@yahoo.fr							   *
 *			Web site          : http://zaagane-mohammed.ifrace.com			   *
 *			Source date	      : 03/10/2008									   *
 *			Source version    : v1.03.10.2008								   *
 *			Modification date : 03/10/2008									   *
 ******************************************************************************/
 
//import java.lang.Math.*;

class Numbers
{
		//Attributs
		private int Nbr;
		
		//Méthodes
		//Accesseurs
		public void set_Nbr(int Value)
		{
				Nbr = Value;
		}
		
		public int get_Nbr()
		{
				return Nbr;
		}
		
		// tester si un nimbre est premier ou non
		public boolean isPrime_Number()
		{
				boolean isPrime=true;
				
				for(int i=2;i<Nbr;i++)
				{
						if(Nbr % i==0)
						{
								isPrime = false;
								break;								
						}
								
				}
				
				return isPrime;
		}
				
		//Constructeur
		public Numbers(int Nmbr)
		{
				set_Nbr(Nmbr);				
		}
		
		
		
}