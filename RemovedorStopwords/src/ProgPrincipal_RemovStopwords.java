
public class ProgPrincipal_RemovStopwords {

	public ProgPrincipal_RemovStopwords() {
		
	}

	public static void main(String[] args) {

		String arquivoStopwords = "    "; //inclua aqui o caminho para o arquivo com a lista de stopwords 
		String arquivoCorpus = "    "; //inclua aqui o caminho para o arquivo com o corpus textual LIMPO e TOKENIZADO

		Removedor removedor = new Removedor(arquivoStopwords, arquivoCorpus);
		removedor.removerStopWords();
	}

}
