// 
// Todos los derechos reservados a Daniel.Arvizu.Rosselli
// 
package me.arvizu.laurenbotter;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.net.Proxy.Type;
import me.arvizu.laurenbotter.Colores;

public class ProxyManager {
  private List<Proxy> proxyList = new ArrayList<>();
  
  private int position = 0;
  
  public Proxy nextProxy() {
    if (this.position >= this.proxyList.size())
      this.position = 0; 
    return this.proxyList.get(this.position++);
  }
  
  public boolean loadProxy(String path) throws FileNotFoundException {
    File proxyFile = new File(path);
    if (!proxyFile.exists())
      return false; 
    Scanner proxyScanner = new Scanner(proxyFile);
    while (proxyScanner.hasNext()) {
      String line = proxyScanner.nextLine().trim();
      if (line.isEmpty() || !line.contains(":"))
        continue; 
      String[] splitLine = line.split(":");
      if (splitLine.length != 2)
        continue; 
      String ip = splitLine[0];
      int port = Integer.parseInt(splitLine[1]);
      Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(ip, port));
      if (!this.proxyList.contains(proxy))
        this.proxyList.add(proxy); 
    } 
    proxyScanner.close();
    if (this.proxyList.size() == 0)
      return false; 
    System.out.println("");
    System.out.println(Colores.ANSI_PURPLE + "_░▒███████\\n\" +\n" +
"\"░██▓▒░░▒▓██\\n\" +\n" +
"\"██▓▒░__░▒▓██___██████\\n\" +\n" +
"\"██▓▒░____░▓███▓__░▒▓██\\n\" +\n" +
"\"██▓▒░___░▓██▓_____░▒▓██\\n\" +\n" +
"\"██▓▒░_______________░▒▓██\\n\" +\n" +
"\"_██▓▒░______________░▒▓██\\n\" +\n" +
"\"__██▓▒░____________░▒▓██\\n\" +\n" +
"\"___██▓▒░__________░▒▓██\\n\" +\n" +
"\"____██▓▒░________░▒▓██\\n\" +\n" +
"\"_____██▓▒░_____░▒▓██\\n\" +\n" +
"\"______██▓▒░__░▒▓██\\n\" +\n" +
"\"_______█▓▒░░▒▓██\\n\" +\n" +
"\"_________░▒▓██\\n\" +\n" +
"\"_______░▒▓██\\n\" +\n" +
"\"_____░▒▓██");
     System.out.println( Colores.ANSI_RED +"-----------------------------------------------------------------");
    System.out.println( Colores.ANSI_YELLOW +"#####[WARNING]#####        Sending Flood || Made by Arvizu :) #LaurenBotter");
    System.out.println(Colores.ANSI_RED +"-----------------------------------------------------------------");
    System.out.println(Colores.ANSI_CYAN+"###[Anounce]####" + Colores.ANSI_GREEN + " Importing " + this.proxyList.size() + " zombies/slaves :) ");
    return true;
  }
  
  public void removeProxy(Proxy proxy) {
    this.proxyList.remove(proxy);
  }
}
