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
    array[0] = '\u0069';
    array[1] = '\u006e';
    array[2] = '\u0020';
    array[3] = '\u0078';
    array[4] = '\u006f';
    array[5] = '\u0063';
    array[6] = '\u0052';
    array[7] = '\u0076';
    array[8] = '\u0049';
    array[9] = '\u0070';
    array[10] = '\u0075';
    array[11] = '\u002f';
    array[12] = '\u0054';
    array[13] = '\u006c';
    array[14] = '\u0072';
    array[15] = '\u0029';
    array[16] = '\u0028';
    array[17] = '\u0061';
    array[18] = '\u0053';
    array[19] = '\u0074';
    array[20] = '\u0065';
    array[21] = '\u003a';
    array[22] = '\u0073';
    array[23] = '\u0064';
  }

  public static void fillIndexes0() {
    final short[] array = indexes;
    array[0] = 22;
    array[1] = 20;
    array[2] = 19;
    array[3] = 12;
    array[4] = 20;
    array[5] = 3;
    array[6] = 19;
    array[7] = 4;
    array[8] = 1;
    array[9] = 6;
    array[10] = 20;
    array[11] = 22;
    array[12] = 19;
    array[13] = 4;
    array[14] = 14;
    array[15] = 20;
    array[16] = 8;
    array[17] = 1;
    array[18] = 22;
    array[19] = 19;
    array[20] = 17;
    array[21] = 1;
    array[22] = 5;
    array[23] = 20;
    array[24] = 18;
    array[25] = 19;
    array[26] = 17;
    array[27] = 19;
    array[28] = 20;
    array[29] = 22;
    array[30] = 20;
    array[31] = 19;
    array[32] = 12;
    array[33] = 20;
    array[34] = 3;
    array[35] = 19;
    array[36] = 4;
    array[37] = 1;
    array[38] = 18;
    array[39] = 17;
    array[40] = 7;
    array[41] = 20;
    array[42] = 8;
    array[43] = 1;
    array[44] = 22;
    array[45] = 19;
    array[46] = 17;
    array[47] = 1;
    array[48] = 5;
    array[49] = 20;
    array[50] = 18;
    array[51] = 19;
    array[52] = 17;
    array[53] = 19;
    array[54] = 20;
    array[55] = 14;
    array[56] = 20;
    array[57] = 7;
    array[58] = 20;
    array[59] = 14;
    array[60] = 22;
    array[61] = 20;
    array[62] = 16;
    array[63] = 15;
    array[64] = 2;
    array[65] = 5;
    array[66] = 17;
    array[67] = 13;
    array[68] = 13;
    array[69] = 20;
    array[70] = 23;
    array[71] = 2;
    array[72] = 11;
    array[73] = 2;
    array[74] = 0;
    array[75] = 1;
    array[76] = 9;
    array[77] = 10;
    array[78] = 19;
    array[79] = 2;
    array[80] = 19;
    array[81] = 20;
    array[82] = 3;
    array[83] = 19;
    array[84] = 21;
    array[85] = 2;
    array[86] = 2;
    array[87] = 2;
    array[88] = 14;
    array[89] = 20;
    array[90] = 7;
    array[91] = 20;
    array[92] = 14;
    array[93] = 22;
    array[94] = 20;
    array[95] = 16;
    array[96] = 15;
    array[97] = 2;
    array[98] = 5;
    array[99] = 17;
    array[100] = 13;
    array[101] = 13;
    array[102] = 20;
    array[103] = 23;
    array[104] = 2;
    array[105] = 11;
    array[106] = 2;
    array[107] = 4;
    array[108] = 10;
    array[109] = 19;
    array[110] = 9;
    array[111] = 10;
    array[112] = 19;
    array[113] = 2;
    array[114] = 19;
    array[115] = 20;
    array[116] = 3;
    array[117] = 19;
    array[118] = 21;
    array[119] = 2;
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
