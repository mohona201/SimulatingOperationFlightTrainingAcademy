package oop.simulatingoperationflighttrainingacademy;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOuputStream extends ObjectOutputStream {

    public AppendableObjectOuputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
//        super.writeStreamHeader();
    }
}
