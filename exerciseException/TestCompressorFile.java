package objOrientProgr.exerciseException;

public class TestCompressorFile {
    public static void main(String[] args) {
        CompressorFile theCompressor = new CompressorFile();
        theCompressor.comprimiFile("text.txt", "textCompresso.txt", null);
    }
}
