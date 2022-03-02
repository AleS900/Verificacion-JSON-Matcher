package practicaComparadorJSON;

public class JSONMatcher {
    /*
    actual result   --> ar
    expected result --> er
    actual attributes   --> aa
    expected attributes --> ea
    */
    boolean ar_Blk, er_Blk, mk;
    String ar, er, aa, ea, ak, ek, av, ev;
    String[] aaArr, eaArr;

    public void jsonAreEqual(String expectedResult, String actualResult, String error) throws Exception {
        ar_Blk = actualResult.isBlank();
        er_Blk = expectedResult.isBlank();
        if ((ar_Blk || er_Blk) && (!ar_Blk || !er_Blk)) {
            throw new Exception(error);
        } else {
            ar = actualResult.replaceAll("\r\n", "");
            er = expectedResult.replaceAll("\r\n", "");
            if ((ar.length() == 2 && er.length() != 2) || (ar.length() != 2 && er.length() == 2)) {
                throw new Exception(error);
            } else {
                aaArr = ar.substring(1, ar.length() - 1).split(",");
                eaArr = er.substring(1, er.length() - 1).split(",");
                if (aaArr.length != eaArr.length) {
                    throw new Exception(error);
                } else {
                    for (String a_str : aaArr) {
                        aa = a_str.trim();
                        ak = aa.split(":")[0];
                        av = aa.split(":")[1];
                        mk = false;
                        for (String ignored : eaArr) {
                            ea = a_str.trim();
                            ek = ea.split(":")[0];
                            ev = ea.split(":")[1];
                            if (ek.equals(ak)) {
                                mk = true;
                                if (ev.equals("\"IGNORE\"")) {
                                    break;
                                } else if (!av.equals(ev)) {
                                    throw new Exception(error);
                                }
                            }
                        }
                        if (!mk) {
                            throw new Exception(error);
                        }
                    }
                }

            }

        }
    }
}
