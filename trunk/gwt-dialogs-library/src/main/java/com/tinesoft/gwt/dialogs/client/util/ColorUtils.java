
package com.tinesoft.gwt.dialogs.client.util;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;

/**
 * Utility class to convert colors from a representation to another.
 * 
 * @author Tine Kondo
 */
public final class ColorUtils {

    private static final RegExp RGB_COLOR_PATTERN = RegExp.compile("rgb\\((\\d{1,3}),\\s*(\\d{1,3}),\\s*(\\d{1,3})\\)",
                                                                   "i");
    private static final RegExp RGBA_COLOR_PATTERN = RegExp.compile("rgba\\((\\d{1,3}),\\s*(\\d{1,3}),\\s*(\\d{1,3})\\)",
                                                                    "i");
    private static final RegExp HEX_COLOR_PATTERN = RegExp.compile("#?([0123456789abcdef]{2})([0123456789abcdef]{2})([0123456789abcdef]{2})",
                                                                   "i");

    /**
     * Decomposes a given color into its red, green, and blue components. The color string can be
     * given in 3 different formats:
     * <ul>
     * <li>in hexadecimal mode. Eg: #ff0000</li>
     * <li>in RBG mode. Eg: rgb(255,0,0)</li>
     * <li>in RBGA mode. Eg: rgba(255,0,0,a)</li>
     * </ul>
     * 
     * @param color the color to decompose
     * @return a <tt>int []</tt> array with the red at position 0, the green at postion 1, and the
     *         blue at position 2
     * @throws IllegalArgumentException if the color's format is not supported
     */
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

    /**
     * Converts a color from its hsl representation to its hexadecimal representation.
     * 
     * @param h the "hue" value of the color to convert
     * @param s the "saturation" value of the color to convert
     * @param l the "ligthness" value of the color to convert
     * @return the hexadecimal representation of the color
     */
    public static String hsl2hex(final int h, final int s, final int l) {
        return hsl2hex(new int[] { h, s, l });
    }

    /**
     * Converts a color from its hsl representation to its hexadecimal representation.
     * 
     * @param hsl the hsl representation of the color
     * @return the hexadecimal representation of the color
     */
    public static String hsl2hex(final int[] hsl) {
        return rgb2hex(hsl2rgb(hsl));
    }

    /**
     * Converts a color from its hsl representation to its rbg representation.
     * 
     * @param hsl the hsl representation of the color
     * @return the rgb representation of the color as a <tt>int[]</tt>
     */
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

    /**
     * Converts a color from its rgb representation to its hexadecimal representation.
     * 
     * @param r the red value of the color to convert
     * @param g the green value of the color to convert
     * @param b the blue value of the color to convert
     * @return the hexadecimal representation of the color
     */
    public static String rgb2hex(final int r, final int g, final int b) {
        return rgb2hex(new int[] { r, g, b });
    }

    /**
     * 
     * Converts a color from its rgb representation to its hexadecimal representation.
     * 
     * @param rgb the rgb representation of the color
     * @return the hexadecimal representation of the color
     */
    public static String rgb2hex(final int[] rgb) {
        return toHex(rgb[0]) + toHex(rgb[1]) + toHex(rgb[2]);
    }

    /**
     * Converts a color from its rgb representation to its hsl representation.
     * 
     * @param rgb the rgb representation of the color
     * @return the hsl representation of the color as a <tt>int[]</tt>
     */
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

    /**
     * Converts a given integer value into its hexadecimal representation.
     * 
     * @param v the <tt>int</tt> value to convert (within [0-255])
     * @return the hexadecimal representation of the value
     */
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
