
class Solution {

    public boolean validUtf8(int[] data) {

        for (int i = 0; i < data.length; i++) {

            if ((data[i] >> 7) == 0) {
                continue;
            }

            else if ((data[i] >> 5) == 0b110) {

                if (i + 1 >= data.length) {
                    return false;
                }

                if ((data[i + 1] >> 6) != 0b10) {
                    return false;
                }

                i++;
            }

            else if ((data[i] >> 4) == 0b1110) {

                if (i + 2 >= data.length) {
                    return false;
                }

                if ((data[i + 1] >> 6) != 0b10 ||
                    (data[i + 2] >> 6) != 0b10) {
                    return false;
                }

                i += 2;
            }

            else if ((data[i] >> 3) == 0b11110) {

                if (i + 3 >= data.length) {
                    return false;
                }

                if ((data[i + 1] >> 6) != 0b10 ||
                    (data[i + 2] >> 6) != 0b10 ||
                    (data[i + 3] >> 6) != 0b10) {
                    return false;
                }

                i += 3;
            }
            else {
                return false;
            }
        }

        return true;
    }
}