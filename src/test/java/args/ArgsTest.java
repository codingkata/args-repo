package args;

import org.junit.Ignore;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArgsTest {

    @org.junit.Test
    @Ignore
    public void test1() {
        Args args = new Args("l:bool,d:int,f:string", "-l -d 8010 -f /usr/local");
        assertEquals(args.getValue("l"), FALSE);
        assertEquals(args.getValue("d"), new Integer(8080));
        assertEquals(args.getValue("f"), "/usr/local");
    }

    @Test
    @Ignore
    public void test_2() {
        Args args = new Args("l:bool,d:int,f:string,s:string", "-d -9 -f /usr/local -s");
        assertEquals(args.getValue("l"), FALSE);
        assertEquals(args.getValue("d"), new Integer(-9));
        assertEquals(args.getValue("f"), "/usr/local");
        assertEquals(args.getValue("s"), null);
    }

    @org.junit.Test
    @Ignore
    public void test3() {
        Args args = new Args("l:bool,d:int,f:string", "-d 80 80");
        assertEquals(args.getValue("d"), new UnspportError("flag input with unspport format!"));
    }

    @org.junit.Test
    @Ignore
    public void test4() {
        Args args = new Args("l:bool,d:int,f:string", "-d 8080");
        assertEquals(args.getValue("l"), FALSE);
        assertEquals(args.getValue("d"), new Integer(8080));
        assertEquals(args.getValue("f"), ".");
        assertEquals(args.getValue("x"), new UnspportError("Unspport Error"));
    }

}