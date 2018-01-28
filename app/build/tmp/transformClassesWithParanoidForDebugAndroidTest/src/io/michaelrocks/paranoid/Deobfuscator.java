package io.michaelrocks.paranoid;

public class Deobfuscator {
  private static final char[] chars = new char[0];
  private static final short[] indexes = new short[0];
  private static final int[] locations = new int[0];

  static {
  }

  public static String getString(final int id) {
    final int offset = locations[id * 2];
    final int length = locations[id * 2 + 1];
    final char[] stringChars = new char[length];
    for (int i = 0; i < length; ++i) {
      stringChars[i] = chars[indexes[offset + i]];
    }
    return new String(stringChars);
  }
}
