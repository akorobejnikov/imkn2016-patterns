package imkn.strategy;


import imkn.strategy.engine.KeyValueStoreEngine;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class KeyValueFSEngine implements KeyValueStoreEngine {

    private File storeDir = new File("tmp");

    {
        try {
            FileUtils.deleteDirectory(storeDir);
            Files.createDirectory(storeDir.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getFile(String id) {
        return new File(storeDir, id);
    }

    @Override
    public void add(String id, byte[] data) throws IOException {
        FileUtils.writeByteArrayToFile(getFile(id), data);
    }

    @Override
    public byte[] get(String id) throws IOException {
        return FileUtils.readFileToByteArray(getFile(id));
    }

    @Override
    public void remove(String id) throws IOException {
        FileUtils.deleteQuietly(getFile(id));
    }

    @Override
    public List<String> listIds(String prefix) throws IOException {
        //noinspection ConstantConditions
        return Arrays.asList(storeDir.list((dir, name) -> name.startsWith(prefix)));
    }

}
