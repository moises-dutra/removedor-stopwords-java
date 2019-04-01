import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Removedor {

	private String textoCorpus = "";
	private String nomeArquivoStopwords = "";
	private String nomeArquivoCorpus = "";
	
	private List<String> stopwords = null; 

	public Removedor(String arquivoStopwords, String arquivoCorpus) {

		nomeArquivoStopwords = arquivoStopwords;
		nomeArquivoCorpus = arquivoCorpus;

		try {
			
			stopwords = Files.readAllLines(new File(nomeArquivoStopwords).toPath(), Charset.defaultCharset() );
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	
		try {
			
			textoCorpus = new String(Files.readAllBytes(Paths.get(nomeArquivoCorpus)));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void removerStopWords() {


		String stopWordsPattern = String.join("|", stopwords);
		Pattern pattern = Pattern.compile("\\b(?:" + stopWordsPattern + ")\\b\\s*", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(textoCorpus);

		textoCorpus = matcher.replaceAll("");

		System.out.print(textoCorpus);
	}

	//construa a exportação para arquivo texto...
}
