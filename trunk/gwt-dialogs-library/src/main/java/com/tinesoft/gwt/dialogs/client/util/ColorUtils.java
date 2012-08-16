
package com.tinesoft.gwt.dialogs.client.util;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;

/**
 * Utility class to convert colors from a representation to another.
 * 
 * @author Tine Kondo<kondotine@gmail.com>
 * @version $Id$
 */
public final class ColorUtils {

    private static final RegExp RGB_COLOR_PATTERN = RegExp.compile("rgb\\((\\d{1,3}),\\s*(\\d{1,3}),\\s*(\\d{1,3})\\)",
                                                                   "i");
    private static final RegExp RGBA_COLOR_PATTERN = RegExp.compile("rgba\\((\\d{1,3}),\\s*(\\d{1,3}),\\s*(\\d{1,3})\\)",
                                                                    "i");
    private static final RegExp HEX_COLOR_PATTERN = RegExp.compile("#?([0123456789abcdef]{2})([0123456789abcdef]{2})([0123456789abcdef]{2})",
                                                                   "i");

    public static int[] getRGB(final String color) {

        MatchResult m;

        if ((m = HEX_COLOR_PATTERN.exec(color)) != null) {
            return new int[] { Integer.parseInt(m.getGroup(1), 16),
                    Integer.parseInt(m.getGroup(2), 16), Integer.parseInt(m.getGroup(3), 16) };
        } else if ((m = RGB_COLOR_PATTERN.exec(color)) != null) {
            return new int[] { Integer.parseInt(m.getGroup(1), 10),
                    Integer.parseInt(m.getGroup(2), 10), Integer.parseInt(m.getGroup(3), 10) };
        } else if ((m = RGBA_COLOR_PATTERN.exec(color)) != null) {
            return new int[] { Integer.parseInt(m.getGroup(1), 10),
                    Integer.parseInt(m.getGroup(2), 10), Integer.parseInt(m.getGroup(3), 10) };
        } else {
            throw new IllegalArgumentException("invalid string color representation:'" + color
                                               + "'");
        }

    }

    public static String hsl2hex(final int h, final int s, final int l) {
        return hsl2hex(new int[] { h, s, l });
    }

    public static String hsl2hex(final int[] hsl) {
        return rgb2hex(hsl2rgb(hsl));
    }

    public static int[] hsl2rgb(final int[] hsl) {
        double h = hsl[0] / 360d;
        final double s = hsl[1] / 100d;
        double l = hsl[2] / 100d;
        double r = 0d;
        double g = 0d;
        double b;

        if (s > 0d) {
            if (h >= 1d) {
                h = 0d;
            }

            h = h * 6d;
            final double f = h - Math.floor(h);
            final double a = Math.round(l * 255d * (1d - s));
            b = Math.round(l * 255d * (1d - (s * f)));
            final double c = Math.round(l * 255d * (1d - (s * (1d - f))));
            l = Math.round(l * 255d);

            switch ((int) Math.floor(h)) {
                case 0:
                    r = l;
                    g = c;
                    b = a;
                    break;
                case 1:
                    r = b;
                    g = l;
                    b = a;
                    break;
                case 2:
                    r = a;
                    g = l;
                    b = c;
                    break;
                case 3:
                    r = a;
                    g = b;
                    b = l;
                    break;
                case 4:
                    r = c;
                    g = a;
                    b = l;
                    break;
                case 5:
                    r = l;
                    g = a;
                    break;
            }
            return new int[] { (int) Math.round(r), (int) Math.round(g), (int) Math.round(b) };
        }

        l = Math.round(l * 255d);
        return new int[] { (int) l, (int) l, (int) l };
    }

    public static String rgb2hex(final int r, final int g, final int b) {
        return rgb2hex(new int[] { r, g, b });
    }

    public static String rgb2hex(final int[] rgb) {
        return toHex(rgb[0]) + toHex(rgb[1]) + toHex(rgb[2]);
    }

    public static int[] rgb2hsl(final int[] rgb) {
        final double max = Math.max(Math.max(rgb[0], rgb[1]), rgb[2]); // 0xdd = 221
        final double delta = max - Math.min(Math.min(rgb[0], rgb[1]), rgb[2]); // 153
        double h = 0;
        int s = 0;
        final int l = (int) Math.round((max * 100d) / 255d); // 87 ok
        if (max != 0) {
            s = (int) Math.round((delta * 100d) / max); // 69 ok
            if (max == rgb[0]) {
                h = (rgb[1] - rgb[2]) / delta;
            } else if (max == rgb[1]) {
                h = ((rgb[2] - rgb[0]) / delta) + 2d;
            } else {
                h = ((rgb[0] - rgb[1]) / delta) + 4d; // 4.8888888888
            }
            h = Math.min(Math.round(h * 60d), 360d); // 293
            if (h < 0d) {
                h += 360d;
            }
        }
        return new int[] { (int) Math.round(h), Math.round(s), l };
    }

    public static String toHex(int v) {
        v = Math.min(Math.max(v, 0), 255);
        return String.valueOf("0123456789abcdef".charAt(((v - (v % 16)) / 16))) + //$NON-NLS-1$
               String.valueOf("0123456789abcdef".charAt(v % 16)); //$NON-NLS-1$
    }

    /**
     * Utility class. No public constructor.
     */
    private ColorUtils() {}
}
