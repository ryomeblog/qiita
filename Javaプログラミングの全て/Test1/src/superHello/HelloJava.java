/** @author Ryome */
/** Javaプログラミングの全て（カプセル化・継承・ポリモーフィズム・インターフェース・オーバーロード・オーバーライド・
 *  List・try-catch・例外・Javadoc）*/
package superHello;

import java.util.Arrays;
class HelloException extends Exception{private static final long serialVersionUID=1L;HelloException(String m){super(m);}}
interface SuperHelloWorld {public abstract String SuperHello() throws HelloException;}
abstract class Hello implements SuperHelloWorld{final String HELLO="Helloworld";private String hello;
Hello(){this.hello=HELLO;}Hello(String hello){this.hello=hello;}public abstract String SuperHello() throws HelloException;
public String getHello(){return hello;}}
class HelloWorld extends Hello {HelloWorld(){super();}@Override public String SuperHello() throws HelloException{return getHello();}}
public class HelloJava{
    /** mainメソッド @param args 使用しない */
    public static void main(String[] args){
        try {Arrays.asList(new HelloWorld().SuperHello()).forEach(System.out::println);}catch(HelloException e){}finally{}
    }
}