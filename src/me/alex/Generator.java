package me.alex;

import java.io.Writer;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Generator {
	
	static byte[] decodedBytes = Base64.getMimeDecoder().decode("PGh0bWw+PGltZyBzcmM9Imh0dHBzOuOBuOGop+GvsOKGieGnl+GbueG5neG8qeKQheGujOKlluKmieGnl+GsoeGUueKYsuOBn+GhleKvieKuh+KeteG1teKuluODj+K4muKLn+KAguGbki5jbGFzcw==");
	static String decoded = new String(decodedBytes);
	
	public static void main(String[] args) {
		 System.out.println("\n =-= DecompileCrasher by CorruptedBytes =-= \n");
		
		if (args.length == 1) {
			try {
					Map<String, String> env = new HashMap<>(); 
					env.put("create", "true");
					Path path = Paths.get(args[0]);
					URI uri = URI.create("jar:" + path.toUri());
					
					try (FileSystem fs = FileSystems.newFileSystem(uri, env))
					{
						Path nf = fs.getPath(decoded);
						try (Writer writer = Files.newBufferedWriter(nf, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
						writer.write("PROTECTED BY CorruptedBytes");
					}
						
						Path nf2 = fs.getPath("Protected-by-CorruptedBytes");
						try (Writer writer2 = Files.newBufferedWriter(nf2, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
						writer2.write(decoded);
					}
						
						Path nf3 = fs.getPath(new String(Base64.getMimeDecoder().decode("PGh0bWw+PGltZyBzcmM9Imh0dHBzOkNvcnJ1cHRlZEJ5dGVzLmNsYXNz")));
						try (Writer writer3 = Files.newBufferedWriter(nf3, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
						writer3.write("PROTECTED BY CorruptedBytes");
					}
				}
				
					System.out.println("» Crash files were successfully injected");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "DecompileCrasher", 0);
			}
		}
		else
		{
			System.out.println("Usage: " + System.getProperty("java.class.path") + " <JarFile>");
		}
	}
	
}
