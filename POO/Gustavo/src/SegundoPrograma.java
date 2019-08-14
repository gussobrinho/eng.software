/*Made By = Gustavo dos Santos Sobrinho*/

public class SegundoPrograma {

	public static void main(String[] args) {
		
		float notas[]= {9.5f, 7.0f, 4.5f, 3.7f, 3.9f, 4.8f, 7.8f, 6.7f};
		String alunos[]= {"Bruno", "Cesar", "Ygor", "Rafael", "Fabricio", "Carla", "Iago", "José"};
		float Mnota = 1;
		float mnota = 100;
		String MNaluno = null;
		String mnaluno = null;
		float media = 0;
		
		
		for(int i=0; i<8; i++) {
			System.out.println(alunos[i] + " = " + notas[i]);
			if(notas[i] > Mnota) {
				Mnota = notas[i];
				MNaluno = alunos[i];
			}
			if(notas[i] < mnota) {
				mnota = notas[i];
				mnaluno = alunos[i];
			}
			media = media + notas[i];
		}
		
		media = media/8;
		
		System.out.println();
		System.out.println("Maior nota = " + MNaluno + " " + Mnota);
		System.out.println("Menor nota = " + mnaluno + " " + mnota);
		System.out.println("Média = " + media);
		System.out.println();
		
		System.out.println("Notas acima da média");
		for(int i=0; i<8; i++) {
			if(notas[i] > media) {
				System.out.println(alunos[i] + " = " + notas[i]);
			}
		}
		
		System.out.println();
		System.out.println("Notas abaixo da média");
		for(int i=0; i<8; i++) {
			if(notas[i] < media) {
				System.out.println(alunos[i] + " = " + notas[i]);
			}
		}
	}	
}