package imkn.strategy;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class KeyValueCompressedStoreEngine implements KeyValueStoreEngine {

    private KeyValueStoreEngine baseStorage;

    public KeyValueCompressedStoreEngine(KeyValueStoreEngine baseStorage) {
        this.baseStorage = baseStorage;
    }

    private byte[] compress(byte[] data) throws IOException {
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        try (GZIPOutputStream gzip = new GZIPOutputStream(bos)) {
            gzip.write(data);
        }
        return bos.toByteArray();
    }

    private byte[] decompress(byte[] compressed) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
        return IOUtils.toByteArray(new GZIPInputStream(byteArrayInputStream));
    }

    @Override
    public void add(String id, byte[] data) throws IOException {
        baseStorage.add(id, compress(data));
    }

    @Override
    public byte[] get(String id) throws IOException {
        return decompress(baseStorage.get(id));
    }

    @Override
    public void remove(String id) throws IOException {
        baseStorage.remove(id);
    }

    @Override
    public List<String> listIds(String prefix) throws IOException {
        return baseStorage.listIds(prefix);
    }

}
