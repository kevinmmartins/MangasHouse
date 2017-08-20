package br.com.mangahouse.infra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

public class FileSaver {

	private static Logger logger = Logger.getLogger(FileSaver.class.getName());
	public static final String FULL_PATCH = "/mangaHouse";

	public String saveFile(Part file, String patch) {
		StringBuilder relativePatch = new StringBuilder();
		relativePatch.append(patch);
		relativePatch.append("/");
		relativePatch.append(file.getSubmittedFileName());
		try {
			file.write(FULL_PATCH + "/" + relativePatch.toString());
		} catch (Exception e) {
			logger.error(e);
		}

		return relativePatch.toString();
	}

	public static void transfer(Path source, ServletOutputStream outputStream) {
		try {
			FileInputStream input = new FileInputStream(source.toFile());
			try (ReadableByteChannel inputChannel = Channels.newChannel(input);
					WritableByteChannel outputChannel = Channels.newChannel(outputStream)) {
				ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 10);

				while (inputChannel.read(buffer) != -1) {
					buffer.flip();
					outputChannel.write(buffer);
					buffer.clear();
				}
			} catch (IOException e) {
				logger.error(e);
			}
		} catch (FileNotFoundException e) {
			logger.error(e);
		}

	}

}
