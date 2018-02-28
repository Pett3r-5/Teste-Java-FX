package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BackEnd {
	public String[] listarUsuariosPraInterface(String nome) {
		// abre os arquivos
		File f = new File(nome + ".txt");

		String dir = ".";
		// acessa os arquivos no diretorio "."
		File diretorio = new File(dir);

		// coloca os nomes dos arquivos no vetor
		String[] nomes = diretorio.list();
	
		int cont = 0;
		for (int i = 0; i < nomes.length; i++) {
			if (nomes[i].contains(".txt")) {
				cont++;
			}
		}
		String[] nomes2 = new String[cont];
		
		int cont2 = 0;
		for (int i = 0; i < nomes.length; i++) {
			if (nomes[i].contains(".txt")) {
				nomes2[cont2] = nomes[i];
				cont2++;
			}
		}
		

		for (int i = 0; i < nomes2.length; i++) {
			// verifica se o que vai ser listado realmente é um txt
			if (nomes2[i].contains(".txt")) {
				System.out.println(nomes2[i]);
			}
		}
		
		return nomes2;
		
	}
	
	public String texto(String nomesSemTxt) {
		String retorno = "";
		try {
			// abre os arquivo já existente para poder buscar informações
			File f = new File(nomesSemTxt + ".txt");
			String conct = "";
			/*
			while (!f.exists()) {
				System.out.println("Usuário inexistente. Digite novamente:");
				nome = scanner.nextLine();
				// System.out.println("2"+nome);
				f = new File(nome + ".txt");
			}
			

			
			
			Class cls = Class.forName("BackEnd");

	        // returns the ClassLoader object associated with this Class
	        ClassLoader cLoader = cls.getClassLoader();
			
			
			InputStream is = cLoader.getResourceAsStream(nomesSemTxt + ".txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(is));
			*/
			FileReader fr1 = new FileReader(nomesSemTxt + ".txt");
			BufferedReader bf = new BufferedReader(fr1);
			String line = bf.readLine();
			 
			while(!(line.equals("%"))) {
				line = bf.readLine();
				if(!(line.equals("%")))
					conct = conct+"\n"+line;
			}
			
			retorno = conct;
			/*
			do {
				System.out.println("Senha:");
				senha = scanner.nextLine();
			} while (!senhaCorreta.equals(senha));
			*/

			bf.close();

			// apos o login do usuario vai listar o nome de todos que estã cadastrados
			//listarUsuarios(nome);
			
			
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		return retorno;
	}
	
	
	
}
