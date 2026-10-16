import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

// Inspeciona e exibe os cabeçalhos do arquivo CSV.
public class HeaderProbe {
    public static void main(String[] args) throws Exception {
        Path p = Path.of("csv", "versao_que_vamos_usar_completo.csv");
        try (CSVParser parser = CSVFormat.DEFAULT.builder()
                .setDelimiter(';')
                .setHeader()
                .setSkipHeaderRecord(true)
                .get()
                .parse(Files.newBufferedReader(p, StandardCharsets.UTF_8))) {
            List<String> headers = parser.getHeaderNames();
            System.out.println("TOTAL=" + headers.size());
            for (int i = 80; i < Math.min(headers.size(), 100); i++) {
                System.out.println(i + " => [" + headers.get(i) + "]");
            }
        }
    }
}