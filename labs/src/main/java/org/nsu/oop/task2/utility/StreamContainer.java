package org.nsu.oop.task2.utility;
import org.nsu.oop.task2.error.FileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamContainer {
    public final Logger LOGGER = LoggerFactory.getLogger(StreamContainer.class);
    private final String filename;
    private Stream<String> command_stream;

    public StreamContainer(String filename){
        this.filename = filename;
    }

    public void initializeStream() throws FileException {
        if (filename == null){
            this.command_stream = new BufferedReader(new InputStreamReader(System.in)).lines();
        }
        else{
            try{
                this.command_stream = Files.lines(Paths.get(filename));
            } catch (Exception e) {
                throw new FileException("Could not open " + filename);
            }
        }
    }

    public Stream<String> getCommandStream() {
        return command_stream;
    }
}
