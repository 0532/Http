package myTest.http.util;

/**
 * @author Wanglichao on 1/15/15.
 * @author Eric Nielsen
 */
public final class Escape {
    private Escape() {
        // not instantiable
    }

    private static StringBuilder createStringBuilder(int len) {
        return new StringBuilder(Math.max(len + len/8, 16));
    }

    /**
     * Escapes HTML appending to StringBuilder.
     *
     * @param sb StringBuilder to append to
     * @param html input
     */
    public static void html(StringBuilder sb, String html) {
        for (int i = 0; i < html.length(); i++) {
            char c = html.charAt(i);
            switch (c) {
            case '&':
                sb.append("&amp;");
                break;
            case '"':
                sb.append("&quot;");
                break;
            case '\'':
                sb.append("&apos;");
                break;
            case '<':
                sb.append("&lt;");
                break;
            case '>':
                sb.append("&gt;");
                break;
            default:
                sb.append(c);
            }
        }
    }

    /**
     * Escapes HTML.
     *
     * @param html input
     * @return escaped HTML
     */
    public static String html(String html) {
        StringBuilder sb = createStringBuilder(html.length());
        html(sb, html);
        return sb.toString();
    }

    /**
     * Escapes JSON appending to StringBuilder.
     *
     * @param sb StringBuilder to append to
     * @param json input
     */
    public static void json(StringBuilder sb, String json) {
        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            switch (c) {
            case '\\':
                sb.append("\\\\");
                break;
            case '"':
                sb.append("\\\"");
                break;
            case '\b':
                sb.append("\\\b");
                break;
            case '\f':
                sb.append("\\\f");
                break;
            case '\n':
                sb.append("\\\n");
                break;
            case '\r':
                sb.append("\\\r");
                break;
            case '\t':
                sb.append("\\\t");
                break;
            default:
                sb.append(c);
            }
        }
    }

    /**
     * Escapes JSON.
     *
     * @param json input
     * @return escaped JSON
     */
    public static String json(String json) {
        StringBuilder sb = createStringBuilder(json.length());
        json(sb, json);
        return sb.toString();
    }


    /**
     * Escapes XML appending to StringBuilder.
     *
     * @param sb StringBuilder to append to
     * @param xml input
     */
    public static void xml(StringBuilder sb, String xml) {
        html(sb, xml);
    }

    /**
     * Escapes XML.
     *
     * @param xml input
     * @return escaped XML
     */
    public static String xml(String xml) {
        return html(xml);
    }
}
