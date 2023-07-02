package gregica.common.data.steam;

import io.netty.buffer.ByteBuf;

import java.io.InputStream;

public class GCDataInputStream extends InputStream {
    private final ByteBuf in;
    
    public GCDataInputStream(ByteBuf in) {
        this.in = in;
    }
    
    @Override
    public int read() {
        return in.readByte() & 255;
    }
}
