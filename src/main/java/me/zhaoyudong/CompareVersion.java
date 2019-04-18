package me.zhaoyudong;

public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        version1 = standardVersion(version1);
        version2 = standardVersion(version2);

        String[] va1 = version1.split("\\.");
        String[] va2 = version2.split("\\.");

        int compare = 0;

        for (int i = 0; i < va1.length; i++) {
            if (i + 1 > va2.length) {
                while (i < va1.length) {
                    if (Integer.parseInt(va1[i].trim()) > 0) {
                        compare = 1;
                        break;
                    }
                    i++;
                }
                break;
            }

            Integer value1 = Integer.parseInt(va1[i].trim());
            Integer value2 = Integer.parseInt(va2[i].trim());
            if (value1 == value2.intValue()) {
                continue;
            } else if (value1 > value2) {
                compare = 1;
            } else {
                compare = -1;
            }
            break;
        }

        if (compare == 0 && va2.length > va1.length) {
            for (int i = va1.length; i < va2.length; i++) {
                if (Integer.parseInt(va2[i].trim()) > 0) {
                    compare = -1;
                }
            }

        }

        return compare;
    }

    public String standardVersion(String version) {
        if (version == null || version.trim().equals("")) {
            return "0";
        }

        return version;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersion().compareVersion("0.1", "1.1"));
    }
}
