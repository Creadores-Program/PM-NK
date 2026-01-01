package org.CreadoresProgram.PNK;
import name.npetrovski.jphar.Phar;
import name.npetrovski.jphar.Entry;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
public class PharManager{
    public static Map<String, byte[]> readPhar(File file){
        Map<String, byte[]> dirP = new HashMap<>();
        Phar phar = new Phar(file);
        for(Entry entry : phar.getEntries().values()){
            if(entry.isDirectory()){
                continue;
            }
            try(InputStream inputSt = entry.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream()){
                int dread;
                byte[] data = new byte[1024];
                while((dread = inputSt.read(data)) != -1){
                    buffer.write(data, 0, dread);
                }
                dirP.put(entry.getName(), buffer.toByteArray());
            }
        }
        return dirP;
    }
}