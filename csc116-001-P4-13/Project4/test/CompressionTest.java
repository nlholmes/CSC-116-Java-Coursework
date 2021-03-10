import org.junit.Test;
import junit.framework.TestCase;

/**
 * Program to test Compression methods
 * @author Suzanne Balik
 * @author Nathan Holmes
 */
public class CompressionTest extends TestCase {

    /** single word with two "re"'s and one "ing" character sequence */
    public static final String WORD1 = "regretting";

    /** single word with one of two "re"'s and one "ing" replaced by characters */
    public static final String WORD1_COMPRESSED = "$grett@";
    
    /** single word with one the and on re*/
    public static final String WORD2 = "there";

    /** single word of only compressed characters */
    public static final String WORD2_COMPRESSED = "&$";
    
    /** single word with two ions */
    public static final String WORD3 = "rationalization";

    /** single word with one of two ions compressed */
    public static final String WORD3_COMPRESSED = "rat#alization";
    
    /** single word with one men and one ion and one ing */
    public static final String WORD4 = "mentioning";

    /** single word with one men, one ion and one ing compressed */
    public static final String WORD4_COMPRESSED = "+t#@";
    
    /** single word with one an and one tis*/
    public static final String WORD5 = "mantis";

    /** single word with one an and one tis compressed */
    public static final String WORD5_COMPRESSED = "m~%";
    
    /** single word with no compression replacements */
    public static final String WORD6 = "proliferate";

    /** single word that is unchanged */
    public static final String WORD6_COMPRESSED = "proliferate";
    
    

    /** multiword line with multiple character sequences */
    public static final String LINE1 = "the action had an equal and opposite reaction.";
    
    /** multiword line with multiple replacement characters */
    public static final String LINE1_COMPRESSED = "& act# had ~ equal ~d opposite $act#.";
    
    /** apostrophes and quotations */
    public static final String LINE2 = "\"the pasta can't be that good\" said johnny";
    
    /** apostrophes and quotations with replacement characters */
    public static final String LINE2_COMPRESSED = "\"& pasta c~'t be that good\" said johnny";
    
    /** multiword line with multiple character sequences */
    public static final String LINE3 = "repetitive typing of lines with few changes. praying mantis";
    
    /** multiword line with multiple replacement characters */
    public static final String LINE3_COMPRESSED = "$petitive typ@ of lines with few ch~ges. pray@ m~%";
    
    /** multiword line with multiple character sequences */
    public static final String LINE4 = "do you want a brief explanation of what an acorn is?";
    
    /** multiword line with multiple replacement characters */
    public static final String LINE4_COMPRESSED = "do you w~t a brief expl~at# of what ~ acorn is?";
    
    /** multiword line with multiple character sequences */
    public static final String LINE5 = "in a nutshell, it's an oak tree.";
    
    /** multiword line with multiple replacement characters */
    public static final String LINE5_COMPRESSED = "in a nutshell, it's ~ oak t$e.";
    
    /** line with no replacements possible */
    public static final String LINE6 = "you put ice in my lasagne!";
    
    /** line with no replacements */
    public static final String LINE6_COMPRESSED = "you put ice in my lasagne!";
    
    
    
    @Test
    public void testCompressWord1() {
        String description = "Compress Word 1";
        String actual = Compression.compressWord(WORD1);
        assertEquals(description, WORD1_COMPRESSED, actual);
    }

    // TODO: Add 5 more test cases here for compressWord method. Each test should be
    // in its own method
    @Test//
    public void testCompressWord2() {
        String description = "Compress Word 2";
        String actual = Compression.compressWord(WORD2);
        assertEquals(description, WORD2_COMPRESSED, actual);
    }
    
    @Test//
    public void testCompressWord3() {
        String description = "Compress Word 3";
        String actual = Compression.compressWord(WORD3);
        assertEquals(description, WORD3_COMPRESSED, actual);
    }
    
    @Test//
    public void testCompressWord4() {
        String description = "Compress Word 4";
        String actual = Compression.compressWord(WORD4);
        assertEquals(description, WORD4_COMPRESSED, actual);
    }
    
    @Test//
    public void testCompressWord5() {
        String description = "Compress Word 5";
        String actual = Compression.compressWord(WORD5);
        assertEquals(description, WORD5_COMPRESSED, actual);
    }
    
    @Test//
    public void testCompressWord6() {
        String description = "Compress Word 6";
        String actual = Compression.compressWord(WORD6);
        assertEquals(description, WORD6_COMPRESSED, actual);
    }
    
    
    
    
    @Test
    public void testDecompressWord1() {
        String description = "Decompress Word 1";
        String actual = Compression.decompressWord(WORD1_COMPRESSED);
        assertEquals(description, WORD1, actual);
    }

    // TODO: Add 5 more test cases here for decompressWord method. Each test should be
    // in its own method
    @Test//
    public void testDecompressWord2() {
        String description = "Decompress Word 2";
        String actual = Compression.decompressWord(WORD2_COMPRESSED);
        assertEquals(description, WORD2, actual);
    }
    
    @Test//
    public void testDecompressWord3() {
        String description = "Decompress Word 3";
        String actual = Compression.decompressWord(WORD3_COMPRESSED);
        assertEquals(description, WORD3, actual);
    }
    
    @Test//
    public void testDecompressWord4() {
        String description = "Decompress Word 4";
        String actual = Compression.decompressWord(WORD4_COMPRESSED);
        assertEquals(description, WORD4, actual);
    }
    
    @Test//
    public void testDecompressWord5() {
        String description = "Decompress Word 5";
        String actual = Compression.decompressWord(WORD5_COMPRESSED);
        assertEquals(description, WORD5, actual);
    }
    
    @Test//
    public void testDecompressWord6() {
        String description = "Decompress Word 6";
        String actual = Compression.decompressWord(WORD6_COMPRESSED);
        assertEquals(description, WORD6, actual);
    }

    
    
    
    
    
    
    @Test
    public void testCompressLine1() {
        String description = "Compress Line 1";
        String actual = Compression.compressLine(LINE1);
        assertEquals(description, LINE1_COMPRESSED, actual);
    }

    // TODO: Add 5 more test cases here for compressLine method. Each test should be
    // in its own method
    @Test//
    public void testCompressLine2() {
        String description = "Compress Line 2";
        String actual = Compression.compressLine(LINE2);
        assertEquals(description, LINE2_COMPRESSED, actual);
    }
    
    @Test//
    public void testCompressLine3() {
        String description = "Compress Line 3";
        String actual = Compression.compressLine(LINE3);
        assertEquals(description, LINE3_COMPRESSED, actual);
    }
    
    @Test//
    public void testCompressLine4() {
        String description = "Compress Line 4";
        String actual = Compression.compressLine(LINE4);
        assertEquals(description, LINE4_COMPRESSED, actual);
    }
    
    @Test//
    public void testCompressLine5() {
        String description = "Compress Line 5";
        String actual = Compression.compressLine(LINE5);
        assertEquals(description, LINE5_COMPRESSED, actual);
    }
    
    @Test//
    public void testCompressLine6() {
        String description = "Compress Line 6";
        String actual = Compression.compressLine(LINE6);
        assertEquals(description, LINE6_COMPRESSED, actual);
    }

    
    
    
    
    
    @Test
    public void testDecompressLine1() {
        String description = "Decompress Line 1";
        String actual = Compression.decompressLine(LINE1);
        assertEquals(description, LINE1, actual);
    }

    // TODO: Add 5 more test cases here for decompressLine method. Each test should be
    // in its own method
    @Test//
    public void testDecompressLine2() {
        String description = "Decompress Line 2";
        String actual = Compression.decompressLine(LINE2);
        assertEquals(description, LINE2, actual);
    }
    
    @Test//
    public void testDecompressLine3() {
        String description = "Decompress Line 3";
        String actual = Compression.decompressLine(LINE3);
        assertEquals(description, LINE3, actual);
    }
    
    @Test//
    public void testDecompressLine4() {
        String description = "Decompress Line 4";
        String actual = Compression.decompressLine(LINE4);
        assertEquals(description, LINE4, actual);
    }
    
    @Test//
    public void testDecompressLine5() {
        String description = "Decompress Line 5";
        String actual = Compression.decompressLine(LINE5);
        assertEquals(description, LINE5, actual);
    }
    
    @Test//
    public void testDecompressLine6() {
        String description = "Decompress Line 6";
        String actual = Compression.decompressLine(LINE6);
        assertEquals(description, LINE6, actual);
    }
}