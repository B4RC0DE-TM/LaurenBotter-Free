// 
// Todos los derechos reservados a Daniel.Arvizu.Rosselli
// 
package me.arvizu.laurenbotter;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import me.arvizu.laurenbotter.RandomOptions;

public class Paquetes {
  private String ip;
  
  private int port;
  
  private DataOutputStream out;
  
    private static byte[] motdPreparedBytes;
    
      public static byte[] getMotdPreparedBytes() {
    return motdPreparedBytes;
  }
  
  public Paquetes(String ip, int port, DataOutputStream out) {
    this.ip = ip;
    this.port = port;
    this.out = out;
  }
  
  public void writeHandshakePacket() throws IOException {
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    DataOutputStream handshake = new DataOutputStream(bout);
    handshake.writeByte(0);
    writeVarInt(handshake, 47);
    writeVarInt(handshake, this.ip.length());
    handshake.writeBytes(this.ip);
    handshake.writeShort(this.port);
    writeVarInt(handshake, 2);
    writeVarInt(this.out, bout.size());
    this.out.write(bout.toByteArray());
  }
  
  public void writeLoginStartPacket() throws IOException {
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    DataOutputStream loginStart = new DataOutputStream(bout);
    loginStart.writeByte(0);
    String name = RandomOptions.randomString(6) + "_LAUREN";
    writeVarInt(loginStart, name.length());
    loginStart.writeBytes(name);
    writeVarInt(this.out, bout.size());
    this.out.write(bout.toByteArray());

  }
  
  public void writeVarInt(DataOutputStream out, int paramInt) throws IOException {
    while (true) {
      if ((paramInt & 0xFFFFFF80) == 0) {
        out.writeByte(paramInt);
        return;
      } 
      out.writeByte(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    } 
  }
}
