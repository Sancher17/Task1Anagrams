package io.michaelrocks.paranoid;

public class Deobfuscator {
  private static final char[] chars = new char[24];
  private static final short[] indexes = new short[120];
  private static final int[] locations = new int[20];

  static {
    fillChars0();
    fillIndexes0();
    fillLocations0();
  }

  public static void fillChars0() {
    final char[] array = chars;
    array[0] = '\u0065';
    array[1] = '\u0028';
    array[2] = '\u0064';
    array[3] = '\u002f';
    array[4] = '\u003a';
    array[5] = '\u0063';
    array[6] = '\u0070';
    array[7] = '\u0075';
    array[8] = '\u0073';
    array[9] = '\u0069';
    array[10] = '\u0061';
    array[11] = '\u0029';
    array[12] = '\u006c';
    array[13] = '\u006f';
    array[14] = '\u0078';
    array[15] = '\u0052';
    array[16] = '\u0074';
    array[17] = '\u0020';
    array[18] = '\u0054';
    array[19] = '\u006e';
    array[20] = '\u0049';
    array[21] = '\u0076';
    array[22] = '\u0072';
    array[23] = '\u0053';
  }

  public static void fillIndexes0() {
    final short[] array = indexes;
    array[0] = 8;
    array[1] = 0;
    array[2] = 16;
    array[3] = 18;
    array[4] = 0;
    array[5] = 14;
    array[6] = 16;
    array[7] = 13;
    array[8] = 19;
    array[9] = 15;
    array[10] = 0;
    array[11] = 8;
    array[12] = 16;
    array[13] = 13;
    array[14] = 22;
    array[15] = 0;
    array[16] = 20;
    array[17] = 19;
    array[18] = 8;
    array[19] = 16;
    array[20] = 10;
    array[21] = 19;
    array[22] = 5;
    array[23] = 0;
    array[24] = 23;
    array[25] = 16;
    array[26] = 10;
    array[27] = 16;
    array[28] = 0;
    array[29] = 8;
    array[30] = 0;
    array[31] = 16;
    array[32] = 18;
    array[33] = 0;
    array[34] = 14;
    array[35] = 16;
    array[36] = 13;
    array[37] = 19;
    array[38] = 23;
    array[39] = 10;
    array[40] = 21;
    array[41] = 0;
    array[42] = 20;
    array[43] = 19;
    array[44] = 8;
    array[45] = 16;
    array[46] = 10;
    array[47] = 19;
    array[48] = 5;
    array[49] = 0;
    array[50] = 23;
    array[51] = 16;
    array[52] = 10;
    array[53] = 16;
    array[54] = 0;
    array[55] = 22;
    array[56] = 0;
    array[57] = 21;
    array[58] = 0;
    array[59] = 22;
    array[60] = 8;
    array[61] = 0;
    array[62] = 1;
    array[63] = 11;
    array[64] = 17;
    array[65] = 5;
    array[66] = 10;
    array[67] = 12;
    array[68] = 12;
    array[69] = 0;
    array[70] = 2;
    array[71] = 17;
    array[72] = 3;
    array[73] = 17;
    array[74] = 9;
    array[75] = 19;
    array[76] = 6;
    array[77] = 7;
    array[78] = 16;
    array[79] = 17;
    array[80] = 16;
    array[81] = 0;
    array[82] = 14;
    array[83] = 16;
    array[84] = 4;
    array[85] = 17;
    array[86] = 17;
    array[87] = 17;
    array[88] = 22;
    array[89] = 0;
    array[90] = 21;
    array[91] = 0;
    array[92] = 22;
    array[93] = 8;
    array[94] = 0;
    array[95] = 1;
    array[96] = 11;
    array[97] = 17;
    array[98] = 5;
    array[99] = 10;
    array[100] = 12;
    array[101] = 12;
    array[102] = 0;
    array[103] = 2;
    array[104] = 17;
    array[105] = 3;
    array[106] = 17;
    array[107] = 13;
    array[108] = 7;
    array[109] = 16;
    array[110] = 6;
    array[111] = 7;
    array[112] = 16;
    array[113] = 17;
    array[114] = 16;
    array[115] = 0;
    array[116] = 14;
    array[117] = 16;
    array[118] = 4;
    array[119] = 17;
  }

  public static void fillLocations0() {
    final int[] array = locations;
    array[0] = 0;
    array[1] = 7;
    array[2] = 7;
    array[3] = 22;
    array[4] = 29;
    array[5] = 7;
    array[6] = 36;
    array[7] = 19;
    array[8] = 55;
    array[9] = 31;
    array[10] = 86;
    array[11] = 1;
    array[12] = 87;
    array[13] = 0;
    array[14] = 87;
    array[15] = 0;
    array[16] = 87;
    array[17] = 1;
    array[18] = 88;
    array[19] = 32;
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
