import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Tests {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		LineNumberReader  lnA = new LineNumberReader(new FileReader(new File("similarMixturesA_similarityMatrix.dat")));
		lnA.skip(Long.MAX_VALUE);
		 System.out.println("# of lines A"+(lnA.getLineNumber() + 1)); //Add 1 because line index starts at 0
		int nlA=lnA.getLineNumber()+1;
		// Finally, the LineNumberReader object should be closed to prevent resource leak Note: must not press enter in last line
		lnA.close();
		
		
		LineNumberReader  lnB = new LineNumberReader(new FileReader(new File("similarMixturesB_similarityMatrix.dat")));
		lnB.skip(Long.MAX_VALUE);
		System.out.println("# of lines B"+(lnB.getLineNumber() + 1)); //Add 1 because line index starts at 0
		// Finally, the LineNumberReader object should be closed to prevent resource leak Note: must not press enter in last line
		int nlB=lnB.getLineNumber()+1;

		lnB.close();
		
		BufferedReader brA = new BufferedReader(new FileReader("similarMixturesA_similarityMatrix.dat"));
		BufferedReader brB = new BufferedReader(new FileReader("similarMixturesB_similarityMatrix.dat"));
		double D=0;
		
		try {
			 
		    StringBuilder sb = new StringBuilder();
		    StringBuilder sb2 = new StringBuilder();
		    String line = brA.readLine();
		    String line2 = brB.readLine();
		    
		    int lenA=line.split(" ").length;
		   // System.out.println(lenA);
		    String [][] MA=new String [nlA][lenA];
		    String [][] MB=new String [nlB][lenA];
		    String [][] R=new String [9][lenA];


		   // String [][] MAD=new String [9][lenA];
		    String [] splitA= new String [nlA/2]; //4
		    String [] splitB= new String [nlB/2]; //4

		    //double [][] SMA=new double [9][9];
		    int i=0;
		    		
		    	
		    while (line != null) {
		    	 
		        sb.append(line);
		       sb.append(System.lineSeparator());
		       splitA=line.split(" ");
		       
		       sb2.append(line2);
		       sb2.append(System.lineSeparator());
		       splitB=line2.split(" ");
		       
		      //  System.out.print(line);
		        //System.out.println();
		        for (int k=0;k<splitA.length;k++)
		        {
		        	MA[i][k]=splitA[k];
		        	MB[i][k]=splitB[k];

		        	
		        	// System.out.print(MA[i][k]+" ");
				        //System.out.println();
		        	//if(j==3)
		        		//break;
		        	 //D+=Double.parseDouble(MA[0][0])*Double.parseDouble(MA[0][0]);
		        	 //m++;
		        	 
		        }
		      //  System.out.println("*******************");
		    //  System.out.println(D);
		        //System.out.println();
		       
		        //MA[i][k]=splitA[k];
		      //  System.out.print(MA[i][j]);
		        //System.out.println();
		        line = brA.readLine();
		        line2 = brB.readLine();

		        i++;
		       
		    }
		  
		    
		    
		    for (int l=0;l<MA.length;l++)
		    {
		    	for(int j=0;j<MA[l].length;j++)
		    	{  
		    System.out.print(MA[l][j]+"  ");
		    	}
		    System.out.println();
		  
		    }
		    System.out.println("**************************************************");
		    
		    
		    System.out.println("**************************************************");

		    
		    
		    for (int l=0;l<MB.length;l++)
		    {
		    	for(int j=0;j<MB[l].length;j++)
		    	{  
		    System.out.print(MB[l][j]+"  ");
		    	}
		    System.out.println();
		  
		    }
		    
		    for (int l=0;l<MB.length;l++)
		    {
		    	for(int j=0;j<MB[l].length;j++)
		    	{  
		    D+=Math.pow((Double.parseDouble(MA[l][j])-Double.parseDouble(MB[l][j])), 2);
		    	}
		    
		  
		    }
		   System.out.println("D= "+D);     
		    
		 /*
		    for (int l=0;l<4;l++)//SMA.lengh
		    {
		    	//if(l==9)break;
		    	for(int j=0;j<4;j++)//<SMA[l].length
		    	{  
		    		for(int a=0;a<4;a++)//MA.length
		    			for(int b=0;b<4;b++)//b<MA.length
		    			{
		    				 
		    		D+=Double.parseDouble(MA[l][j])*Double.parseDouble(MA[a][b]);
		    			}
		    		if(l==4 || j==4 )break;
		    		SMA[l][j]=D;
		    		// System.out.print(MA[l][j]+"  ");
		    	}
		    	
		    System.out.println();
		    }
		
		     */
		    
		    
		   
				   
 		    
		} 
		    
		catch (IOException ie)
		{
			System.out.println("error");
		}
		finally {
			
		    brA.close();
		}
	}

}
